import models.Campeonato;
import models.Clube;

public class Teste {
    public static void main(String[] args) {
        Campeonato faresLopes = new Campeonato(new Clube[] {
                new Clube("Icasa"),
                new Clube("Floresta"),
                new Clube("Guarany de Sobral"),
                new Clube("Maracanã"),
                new Clube("Pacajus"),
        });

        System.out.println("Taça Fares Lopes 2023\n");
        faresLopes.jogarCampeonato();

        String classificacao = faresLopes.getClassificacao();
        String campeao = faresLopes.getCampeao();

        System.out.println("\nResultado final\n");
        System.out.println(classificacao);

        System.out.println("Parabéns ao vencedor! " + campeao);
    }
}
