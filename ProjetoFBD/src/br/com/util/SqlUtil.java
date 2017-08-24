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
    public static final String SELECT_CLIENTE = "SELECT id ,nome,cpf,endereco,contato FROM cliente";
    public static final String UPDATE_CLIENTE = "update cliente set nome = ?, cpf = ?, endereco = ?, contato = ? where id = ?";

    public static final String SQL_INSERT_FUNCIONARIO_ALL = "INSERT INTO funcionário(id, nome,cargo, cpf,contato,endereco) values(?,?,?,?,?,?)";
    public static final String SELECT_FUNCIONARIO = "SELECT id, nome,cargo, cpf,contato,endereco FROM funcionário ";
    public static final String UPDATE_FUNCIONARIO = "update funcionário set nome = ?, cargo=?, cpf = ?, contato = ?, endereco = ? where id = ?";

    public static final String SQL_INSERT_CARRO_ALL = "INSERT INTO carro(id, modelo, marca, placa, cor) values(?,?,?,?,?)";
    public static final String SELECT_CARROS = "SELECT id, modelo, marca, placa, cor FROM carro ";
    public static final String UPDATE_CARROS = "update carro set modelo = ?, marca=?, placa = ?, cor = ? where id = ?";

    public static final String SQL_INSERT_LOCACAO_ALL = "INSERT INTO locacao(id, cliente, carro, funcionario, dataRetirada,dataDevo,valor) values(?,?,?,?,?,?,?)";
    public static final String SELECT_LOCACAO = "SELECT id, cliente, carro, funcionario, dataRetirada,dataDevo,valor FROM locacao";
    public static final String UPDATE_LOCACAO = "update locacao set cliente = ?, carro = ?,funcionario=?, dataRetirada = ?,dataDevo = ?,valor = ? where id = ?";

    private SqlUtil() {
    }
}
