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
public class Reserva {
    
    private Carro carro;
    private Date dataRetirada, dataDevolucao;     

    

    public Reserva(Carro carro, Date dataRetirada, Date dataDevolucao) {
        this.carro = carro;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
    }
    
    public Reserva(){
        
    }
    
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
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
    
}
