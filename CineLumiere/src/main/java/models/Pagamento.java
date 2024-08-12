/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pagamento {
    private double valor;
    private Cliente cliente;
    private ArrayList<Ingresso> ingressos;
    private String metodoPagamento;
    private LocalDateTime data;

    public Pagamento(double valor, Cliente cliente, ArrayList<Ingresso> ingressos, String metodoPagamento) {
        this.valor = valor;
        this.cliente = cliente;
        this.ingressos = ingressos;
        this.metodoPagamento = metodoPagamento;
        this.data = LocalDateTime.now();
    }

    public double getPagamento() {
        return valor;
    }

    public void setPagamento(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }


    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void adicionaIngresso(Ingresso ingresso){
        this.ingressos.add(ingresso);
    } 
    
}
