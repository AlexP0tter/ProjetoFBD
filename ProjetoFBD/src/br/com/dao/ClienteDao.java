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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexp0tter
 */
public class ClienteDao {

    Connection con;
    PreparedStatement statement;
    ResultSet result;

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

    public Cliente salvar(Cliente cliente) throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_CLIENTE_ALL);

            statement.setInt(1, cliente.getId());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getCPF());
            statement.setString(4, cliente.getEndereco());
            statement.setString(5, cliente.getContato());
            statement.execute();

            return cliente;

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

    public Cliente alterar(Cliente cliente) throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.UPDATE_CLIENTE);

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCPF());
            statement.setString(3, cliente.getEndereco());
            statement.setString(4, cliente.getContato());
            statement.setInt(5, cliente.getId());

            statement.execute();

            return cliente;

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
