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
    public static final String SELECT_CLIENTE = "select cl.id, cl.nome, cl.cpf, cl.contato, cl.idEndereco, end.rua, end.bairro, end.cidade, end.cep, end.uf from cliente as cl inner join endereco AS end ON end.id = cl.idEndereco";
    public static final String UPDATE_CLIENTE = "update cliente set cpf = ?,nome = ?, contato = ? where id = ?";

    public static final String SQL_INSERT_FUNCIONARIO_ALL = "INSERT INTO funcionario(id ,idEndereco ,nome ,cpf ,cargo ,contato ,loginUser ,loginSenha) values(?,?,?,?,?,?,?,?)";
    public static final String SELECT_FUNCIONARIO = "SELECT fun.id,fun.nome, fun.cpf, fun.cargo, fun.contato, fun.loginUser, fun.loginSenha, fun.idEndereco, end.rua, end.bairro, end.cidade, end.cep, end.uf FROM funcionario AS fun inner join endereco AS end ON end.id = fun.idEndereco";
    public static final String UPDATE_FUNCIONARIO = "update funcionario set nome = ?, cargo = ?, cpf = ?, contato = ?, loginUser = ?, loginSenha = ?  where id = ?";

    public static final String SQL_INSERT_CARRO_ALL = "INSERT INTO carro(id,modelo,marca,placa,cor,valorDiaria,statusLocacao) values(?,?,?,?,?,?,?)";
    public static final String SELECT_CARROS = "SELECT id,modelo,marca,placa,cor,valorDiaria,statusLocacao FROM carro ";
    public static final String UPDATE_CARROS = "update carro set modelo = ?, marca = ?, placa = ?, cor = ? , valorDiaria = ?, statusLocacao = ? where id = ?";
    
    public static final String SQL_INSERT_LOCACAO_ALL = "INSERT INTO locacao(id,idCliente,idFuncionario,idCarro,dataSaida,dataVolta,valorPagamento,statusLocacao ) values(?,?,?,?,?,?,?,?)";
    public static final String SELECT_LOCACAO = "SELECT loc.id,loc.idCliente,loc.idFuncionario,loc.idCarro,loc.dataSaida,loc.dataDevo,  loc.valorPagamento,loc.statusLocacao FROM locacao AS loc "
            + "INNER JOIN cliente AS cl ON cl.id = loc.idCliente "
            + "INNER JOIN funcionario AS fun ON fun.id = loc.idFuncionario "
            + "INNER JOIN carro AS cr ON cr.id = loc.idCarro";
   public static final String SELECT_TABELA_LOC = "select loc.id, cl.cpf,cr.modelo,fun.nome, loc.dataSaida,loc.dataVolta,loc.valorPagamento, loc.StatusLocacao from locacao as loc INNER JOIN cliente AS cl ON cl.id = loc.idCliente INNER JOIN funcionario AS fun ON fun.id = loc.idFuncionario INNER JOIN carro AS cr ON cr.id = loc.idCarro"; 

    public static final String UPDATE_LOCACAO = "update locacao set cliente = ?, carro = ?,funcionario=?, dataRetirada = ?,dataDevo = ?,valor = ? where id = ?";
    
    public static final String SQL_INSERT_ENDERECO_ALL ="INSERT INTO endereco(id ,rua ,bairro ,cep ,cidade ,uf) values(?,?,?,?,?,?)";
    public static final String SELECT_ENDERECO ="SELECT id ,rua ,bairro ,cep ,cidade ,uf FROM endereco";
    public static final String UPDATE_ENDERECO ="update endereco set rua = ?, bairro = ?, cidade = ?, uf = ?, cep =? where id = (select idEndereco from cliente where id = ?)";
    
    public static final String UPDATE_ENDERECO_FUN ="update endereco set rua = ?, bairro = ?, cidade = ?, uf = ?, cep =? where id = (select idEndereco from funcionario where id = ?)";
    
    private SqlUtil() {
    }
}
