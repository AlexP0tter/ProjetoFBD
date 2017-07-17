/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Carro;
import br.com.model.Cliente;
import br.com.util.ConnectionFactory;
import br.com.util.SqlUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alexp0tter
 */
public class ClienteDao {
    
    Connection con;
    PreparedStatement statement;

    public ClienteDao() {
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
    public boolean salvar(Cliente cliente) {
        try {
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_CLIENTE_ALL);
            statement.setInt(1, cliente.getId());
            statement.setString(2, cliente.getNome());
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
