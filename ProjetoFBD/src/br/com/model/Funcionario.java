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
public class Funcionario {
    
    private int id;
    private String nome,cargo,contato,cpf;
    private String senha, login;
    private Endereco endereco;

    public Funcionario(int id,Endereco end, String nome, String cargo, String contato, String cpf,String rua, String bairro, String cidade, String uf, String cep, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.contato = contato;
        this.cpf = cpf;
        this.login = usuario;
        this.senha = senha;
        this.endereco = end;
    }

    public Funcionario() {
        
        endereco = new Endereco();
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
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

   
}
