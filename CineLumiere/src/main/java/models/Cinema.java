package models;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String nome;
    private String endereco;
    private List<Sala> salas;

    public Cinema(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.salas = new ArrayList<>();
    }

    public void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public void exibirDetalhes(){
        System.out.println("Cinema: " + nome +
                "\nLocalização: " + endereco +
                "\nSalas disponíveis: " +salas);
    }


}