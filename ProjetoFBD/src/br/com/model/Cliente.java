/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Alexp0tter
 */
public class Cliente {   
    
    private int id;
    private String Nome, CPF, endereco,contato;
    
    public Cliente(int id, String Nome, String CPF, String endereco, String contato) {
        this.id = id;
        this.Nome = Nome;
        this.CPF = CPF;
        this.endereco = endereco;
        this.contato = contato;
    }
    
    public Cliente(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    
    
}
