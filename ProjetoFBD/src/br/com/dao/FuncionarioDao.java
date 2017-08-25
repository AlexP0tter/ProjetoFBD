/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Cliente;
import br.com.model.Funcionario;
import br.com.util.ConnectionFactory;
import br.com.util.SqlUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public class FuncionarioDao{
    
    Connection con;
    PreparedStatement statement;

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
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_FUNCIONARIO_ALL);
            statement.setInt(1, fun.getId());
            statement.setInt(2, fun.getEnd().getId());         
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
            
            statement.setInt(1, fun.getEnd().getId());         
            statement.setString(2, fun.getNome());
            statement.setString(3, fun.getCpf());
            statement.setString(4, fun.getCargo());            
            statement.setString(5, fun.getContato());
            statement.setString(6, fun.getLogin());
            statement.setString(7, fun.getSenha());
            statement.setInt(8, fun.getId());
            
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

    
    
    
}
