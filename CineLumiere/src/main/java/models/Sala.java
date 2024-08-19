package models;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private Cinema cinema;
    private int numero;
    private List<Sessao> sessoes;

    public Sala(Cinema cinema, int numero) {
        this.cinema = cinema;
        this.numero = numero;
        this.sessoes = new ArrayList<>();
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "sala : " + numero;
    }

    public void adicionarSessao(Sessao sessao) {
        sessoes.add(sessao);
    }

    public void removerSessao(Sessao sessao) { 
        sessoes.remove(sessao); 
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void exibirDetalhes(){
        System.out.println("Sala: " +
                "\n " + cinema.getNome() +
                ", n°: " + numero +
                "\n Programação: " + sessoes);
    }
}
