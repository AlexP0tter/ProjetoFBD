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
    public Funcionario salvar(Funcionario funcionario)throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_FUNCIONARIO_ALL);
            statement.setInt(1, funcionario.getId());
            statement.setString(2, funcionario.getNome());
            statement.setString(3, funcionario.getCargo());
            statement.setString(4, funcionario.getCpf());            
            statement.setString(5, funcionario.getContato());
            statement.setString(6, funcionario.getEndereco());            
            
            statement.execute();
            return funcionario;
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
            statement.setString(2, fun.getCargo());
            statement.setString(3, fun.getCpf());
            statement.setString(5, fun.getEndereco());
            statement.setString(4, fun.getContato());
            statement.setInt(6, fun.getId());
            
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
