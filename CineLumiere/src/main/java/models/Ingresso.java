/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class Ingresso {
    private int id;
    private Sessao sessao;
    private Poltrona poltrona;
    private double price;

    public Ingresso(int id, Sessao sessao, Poltrona poltrona, double price) {
        this.id = id;
        this.sessao = sessao;
        this.poltrona = poltrona;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Poltrona getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Poltrona poltrona) {
        this.poltrona = poltrona;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
