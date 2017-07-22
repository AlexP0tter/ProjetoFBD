/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Carro;
import br.com.util.ConnectionFactory;
import br.com.util.SqlUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alexp0tter
 */
public class CarrosDao {
    
    Connection con;
    PreparedStatement statement;

    public CarrosDao() {
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
    public boolean salvar(Carro carro) {
        try {
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_CARRO_ALL);
            statement.setInt(1, carro.getId());
            statement.setString(2, carro.getModelo());
            statement.setString(3, carro.getNome());
            statement.setString(4, carro.getPlaca());
            statement.setString(5, carro.getCategoria());
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
