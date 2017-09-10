/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Cliente;
import br.com.model.Endereco;
import br.com.model.Funcionario;
import br.com.util.ConnectionFactory;
import br.com.util.SqlUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public class FuncionarioDao{
    
    Connection con;
    PreparedStatement statement, statement2;
    ResultSet result;

    public FuncionarioDao() {
        try {
            con = ConnectionFactory.getInstance(ConnectionFactory.NOME_DATABASE_MYSQL);
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace();
            }
        }

    }
    public Funcionario salvar(Funcionario fun)throws Exception {
        try {
            Long idEnd = salvarEndereco(fun.getEndereco());
            
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_FUNCIONARIO_ALL);
            
            statement.setInt(1, fun.getId());
            statement.setLong(2, idEnd);         
            statement.setString(3, fun.getNome());
            statement.setString(4, fun.getCpf());
            statement.setString(5, fun.getCargo());            
            statement.setString(6, fun.getContato());
            statement.setString(7, fun.getLogin());
            statement.setString(8, fun.getSenha());
            
            statement.execute();
            return fun;
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        throw new Exception("Erro....");
    }
    
    public Funcionario alterar(Funcionario fun)throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.UPDATE_FUNCIONARIO);       
                   
            statement.setString(1, fun.getNome());
            statement.setString(2, fun.getCpf());
            statement.setString(3, fun.getCargo());            
            statement.setString(4, fun.getContato());
            statement.setString(5, fun.getLogin());
            statement.setString(6, fun.getSenha());
            statement.setInt(7, fun.getId());
            
            statement2 = con.prepareStatement(SqlUtil.UPDATE_ENDERECO_FUN);
            
            statement2.setString(1, fun.getEndereco().getRua());
            statement2.setString(2, fun.getEndereco().getBairro());
            statement2.setString(3, fun.getEndereco().getCidade());            
            statement2.setString(4, fun.getEndereco().getUf()); 
            statement2.setString(5, fun.getEndereco().getCep());
           
            statement2.setLong(6, fun.getId());
            statement2.execute();

            statement.execute();
                    
            return fun;
                     
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
             throw new Exception("Erro....");
        
    }
    
    private Long salvarEndereco(Endereco end) throws Exception{
        
        try{
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_ENDERECO_ALL);

            statement.setInt(1, end.getId());
            statement.setString(2, end.getRua());
            statement.setString(3, end.getBairro());
            statement.setString(4, end.getCep());
            statement.setString(5, end.getCidade());
            statement.setString(6, end.getUf());
            statement.execute();
            
            statement = con.prepareStatement("select * from endereco");
            result = statement.executeQuery();
            
            while(result.next()){
                if(result.isLast()){
                    return result.getLong("id");
                }
            }
            
            return new Long(0);
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                throw new Exception(ex1.getMessage());
            }
            throw new Exception(ex.getMessage());
    }
   }

    
    
    
}
