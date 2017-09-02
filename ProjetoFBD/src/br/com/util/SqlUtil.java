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

    //public static final String SQL_INSERT_CLIENTE_ALL = "INSERT INTO cliente(id,idEndereco, cpf, nome, contato) values(?,(SELECT id FROM endereco ORDER BY id DESC LIMIT 1),?,?,?)";
    public static final String SQL_INSERT_CLIENTE_ALL = "INSERT INTO cliente(id,idEndereco, cpf, nome, contato) values(?,?,?,?,?)";
    public static final String SELECT_CLIENTE = "select cl.id, cl.nome, cl.cpf. cl.contato, cl.idEndereco, end.rua, end.bairro, end.cidade, end.cep, end.uf from cliente as cl inner join endereco AS end ON end.id = cl.idEndereco";
    public static final String UPDATE_CLIENTE = "update cliente set idEndereco = ?, cpf = ?,nome = ?, contato = ? where id = ?";

    public static final String SQL_INSERT_FUNCIONARIO_ALL = "INSERT INTO funcionario(id ,idEndereco ,nome ,CPF ,cargo ,contato ,loginUser ,loginSenha) values(?,?,?,?,?,?,?,?)";
    public static final String SELECT_FUNCIONARIO = "SELECT fun.id, end.rua, end.bairro, end.cidade, fun.nome, fun.cpf, fun.contato, fun.cargo, fun.loginUser, fun.loginSenha FROM funcionario AS fun inner join endereco AS end ON end.id = fun.idEndereco";
    public static final String UPDATE_FUNCIONARIO = "update funcionario set nome = ?, cargo = ?, cpf = ?, contato = ?, idEndereco = ?, loginUser = ?, loginSenha = ?  where id = ?";

    public static final String SQL_INSERT_CARRO_ALL = "INSERT INTO carro(id,modelo,marca,placa,cor,valorDiaria,statusLocacao) values(?,?,?,?,?,?,?)";
    public static final String SELECT_CARROS = "SELECT id,modelo,marca,placa,cor,valorDiaria,statusLocacao FROM carro ";
    //public static final String UPDATE_CARROS = "update carro set modelo = ?, marca = ?, placa = ?, cor = ? , valorDiaria = ?, statusLocacao = ? where id = ?";
    public static final String UPDATE_CARROS = "UPDATE `carro` SET `modelo`= ?,`marca`= ?,`placa`= ?,`cor`= ?,`valorDiaria`= ?,`statusLocacao`= ? WHERE 'id' = ? ";
    

    public static final String SQL_INSERT_LOCACAO_ALL = "INSERT INTO locacao(id, cliente, carro, funcionario, dataRetirada,dataDevo,valor) values(?,?,?,?,?,?,?)";
    public static final String SELECT_LOCACAO = "SELECT id, cliente, carro, funcionario, dataRetirada,dataDevo,valor FROM locacao";
    public static final String UPDATE_LOCACAO = "update locacao set cliente = ?, carro = ?,funcionario=?, dataRetirada = ?,dataDevo = ?,valor = ? where id = ?";
    
    public static final String SQL_INSERT_ENDERECO_ALL ="INSERT INTO endereco(id ,rua ,bairro ,cep ,cidade ,uf) values(?,?,?,?,?,?)";
    public static final String SELECT_ENDERECO ="SELECT id ,rua ,bairro ,cep ,cidade ,uf FROM endereco";
    public static final String UPDATE_ENDERECO ="update endereco set rua = ?, bairro = ?, cidade = ?, uf = ?, where id =?";
    
    private SqlUtil() {
    }
}
