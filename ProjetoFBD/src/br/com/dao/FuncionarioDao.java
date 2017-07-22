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

/**
 *
 * @author Alexp0tter
 */
public class FuncionarioDao {
    
    Connection con;
    PreparedStatement statement;

    public FuncionarioDao() {
        try {
            //con = ConnectionFactory.getInstance(ConnectionFactory.NOME_DATABASE_MYSQL);
            con = ConnectionFactory.getInstance(ConnectionFactory.NOME_DATABASE_POSTGRES);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace();
            }
        }

    }
    public boolean salvar(Funcionario funcionario) {
        try {
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_FUNCIONARIO_ALL);
            statement.setInt(1, funcionario.getId());
            statement.setString(2, funcionario.getNome());
            statement.setString(3, funcionario.getCpf());
            statement.setString(4, funcionario.getContato());
            statement.setString(5, funcionario.getEndereco());
            statement.setString(6, funcionario.getCargo());
            
            statement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        return false;
    }
    
}
