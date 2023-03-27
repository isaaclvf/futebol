package models;

public class Clube {
    String nome;
    int pontos;
    int saldoGols;

    public Clube(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.saldoGols = 0;
    }

    public void ganhar(int saldoGols) {
        this.pontos += 3;
        this.saldoGols += saldoGols;
    }

    public void empatar() {
        this.pontos += 1;
    }

    public void perder(int saldoGols) {
        this.saldoGols -= saldoGols;
    }

    public Boolean equals(Clube clube) {
        return this.nome.equals(clube.nome);
    }

    public String toString() {
        return this.nome;
    }
}
