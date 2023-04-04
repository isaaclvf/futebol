package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Campeonato {
    private ArrayList<Clube> clubes;
    private Boolean finalizado;

    public Campeonato(Clube... clubes) {
        this.clubes = new ArrayList<Clube>();

        for (Clube clube : clubes) {
            this.clubes.add(clube);
        }
    }

    public void jogarCampeonato() {
        for (Clube clubeDaCasa : clubes) {
            for (Clube clubeVisitante : clubes) {
                if (clubeDaCasa.equals(clubeVisitante)) {
                    continue;
                }

                jogarPartida(clubeDaCasa, clubeVisitante);
            }
        }
        finalizado = true;
    }

    private void jogarPartida(Clube m, Clube v) {
        int golsM = (int) Math.round((Math.random() * 10)) % 6;
        int golsV = (int) Math.round((Math.random() * 10)) % 6;

        if (golsM == golsV) {
            m.empatar();
            v.empatar();
        }

        if (golsM > golsV) {
            int saldoGols = golsM - golsV;
            m.ganhar(saldoGols);
            v.perder(saldoGols);
        }

        if (golsV > golsM) {
            int saldoGols = golsV - golsM;
            v.ganhar(saldoGols);
            m.perder(saldoGols);
        }

        // Para ficar fácil de entender o resultado final
        System.out.println(m + " " + golsM + " x " + v + " " + golsV);
    }

    public String getClassificacao() {
        Comparator<Clube> comp = new Comparator<Clube>() {
            @Override
            public int compare(Clube a, Clube b) {
                // Compara 'b' com 'a' nessa ordem porque assim fica em ordem decrescente
                int pontosComp = Integer.compare(b.getPontos(), a.getPontos());

                if (pontosComp != 0) {
                    return pontosComp;
                }

                return Integer.compare(b.getSaldoGols(), a.getSaldoGols());
            }
        };

        Collections.sort(clubes, comp);

        String classificacao = "";

        for (Clube clube : clubes) {
            classificacao += clube.toString() + " " + clube.getPontos() + " " + clube.getSaldoGols() + "\n";
        }

        return classificacao;
    }

    public String getCampeao() {
        if (!finalizado) {
            return "Não há campeão porque o campeonato ainda não foi jogado";
        }

        return clubes.get(0).toString();
    }
}
