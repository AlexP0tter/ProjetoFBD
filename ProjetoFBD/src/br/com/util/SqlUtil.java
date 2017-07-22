/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

/**
 *
 * @author Alexp0tter
 */
public class SqlUtil {
    
     
    public static final String SQL_INSERT_CLIENTE_ALL = "INSERT INTO cliente(id,nome, cpf, endereco, contato) values(?,?,?,?,?)";
    public static final String SQL_INSERT_CARRO_ALL = "INSERT INTO carro(id, modelo, marca, placa, categoria) values(?,?,?,?,?)";
    public static final String SQL_INSERT_FUNCIONARIO_ALL = "INSERT INTO funcionário(id, nome,cargo, cpf,contato,endereco) values(?,?,?,?,?,?)";
}
