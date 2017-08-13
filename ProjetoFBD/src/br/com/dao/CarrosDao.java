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
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public class CarrosDao {

    Connection con;
    PreparedStatement statement;

    public CarrosDao() {
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

    public Carro salvar(Carro carro) throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_CARRO_ALL);

            statement.setInt(1, carro.getId());
            statement.setString(2, carro.getModelo());
            statement.setString(3, carro.getMarca());
            statement.setString(4, carro.getPlaca());
            statement.setString(5, carro.getCor());
            statement.execute();

            return carro;

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

    public Carro alterar(Carro carro) throws Exception {

        try {
            statement = con.prepareStatement(SqlUtil.UPDATE_CARROS);

            statement.setString(1, carro.getModelo());
            statement.setString(2, carro.getMarca());
            statement.setString(3, carro.getPlaca());
            statement.setString(4, carro.getCor());
            statement.setInt(5, carro.getId());

            statement.execute();

            return carro;

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

    public Carro buscarPorid(Carro carro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Carro> getAllI() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
