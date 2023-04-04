package models;

public class Clube {
    private String nome;
    private int pontos;
    private int saldoGols;

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

    public String getNome() {
        return this.nome;
    }

    public int getPontos() {
        return this.pontos;
    }

    public int getSaldoGols() {
        return this.saldoGols;
    }

    public Boolean equals(Clube clube) {
        return this.nome.equals(clube.nome);
    }

    public String toString() {
        return this.nome;
    }
}
