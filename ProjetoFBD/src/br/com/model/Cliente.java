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
    private String Nome, CPF,contato;
    private Endereco endereco; 
    
    public Cliente( int id,int idEnd,String Nome, String CPF,  String contato, String rua, String bairro, String cidade, String uf, String cep) {
        this.id = id;
        this.Nome = Nome;
        this.CPF = CPF;
        this.contato = contato;
        endereco = new Endereco(idEnd,rua, cidade, uf, bairro,cep);
    }
    
    public Cliente(){
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
    
    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    
    
}
