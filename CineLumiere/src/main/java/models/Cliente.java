/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

public class Cliente extends Usuario{

    private ArrayList<Ingresso> compras;

    public Cliente(String cpf, String email, String senha) {
        super(cpf, email, senha);
        this.compras = new ArrayList<Ingresso>();
    }

    public ArrayList<Ingresso> getCompras() {
        return compras;
    }
    
}
