/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.sql.Date;





/**
 *
 * @author Alexp0tter
 */
public class LocacaoModel {
    
    //private Carro carro;
    //private Cliente cliente;
    //private Funcionario fun;
    
    private Cliente cliente;
    private Carro carro;
    private Funcionario fun;
    private Date dataRetirada, dataDevolucao;
    private double valor;
    private boolean statusLocacao;
    
    private int id;

    public LocacaoModel(Cliente cliente, Carro carro, Funcionario fun, Date dataRetirada, Date dataDevolucao, double valor, boolean statusLocacao, int id) {
        this.cliente = cliente;
        this.carro = carro;
        this.fun = fun;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
        this.statusLocacao = statusLocacao;
        this.id = id;
    }
    
    
    public LocacaoModel(){
        
        cliente = new Cliente();
        carro = new Carro();
        fun = new Funcionario();
        
    } 

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Funcionario getFun() {
        return fun;
    }

    public void setFun(Funcionario fun) {
        this.fun = fun;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isStatusLocacao() {
        return statusLocacao;
    }

    public void setStatusLocacao(boolean statusLocacao) {
        this.statusLocacao = statusLocacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
