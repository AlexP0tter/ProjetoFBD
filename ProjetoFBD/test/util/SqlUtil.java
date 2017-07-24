/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

/**
 *
 * @author heldonjose
 */
public class SqlUtil {

    
    public static final String INSERT_ALUNO_ALL = "INSERT INTO Aluno( nome, cpf, id_endereco) values ( ?, ?, ?)";
    public static final String INSERT_ENDERECO_ALL = "INSERT INTO Endereco(cep, logradouro) values ( ?, ?)";
    public static final String INSERT_CONTATO_ALL = "INSERT INTO Contato( tipo, descricao, id_aluno) values (?, ?, ?)";
    
    
    
    public static final String SELECT_ALUNO_ULTIMO_REGISTRO = "SELECT * FROM aluno ORDER BY id DESC LIMIT 1";
    
    
    
    
    private SqlUtil() {
    }
    
    
    
    
}
