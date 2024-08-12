/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Flip_
 */
public abstract class Usuario {
    private String cpf;
    private String email;
    private String senha;

    public Usuario(String cpf, String email, String senha) {
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean checkSenha(String senha) {
        return this.senha.equals(senha);
    }
}
