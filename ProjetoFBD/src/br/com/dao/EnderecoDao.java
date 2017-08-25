/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Carro;
import br.com.model.Endereco;
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
public class EnderecoDao {

    Connection con;
    PreparedStatement statement;

    public EnderecoDao() {
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

    public Endereco salvar(Endereco end) throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_ENDERECO_ALL);

            statement.setInt(1, end.getId());
            statement.setString(2, end.getRua());
            statement.setString(3, end.getBairro());
            statement.setString(4, end.getCep());
            statement.setString(5, end.getCidade());
            statement.setString(6, end.getUf());
            

            return end;

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

    public Endereco alterar(Endereco end) throws Exception {

        try {
            statement = con.prepareStatement(SqlUtil.UPDATE_ENDERECO);

            statement.setString(1, end.getRua());
            statement.setString(2, end.getBairro());
            statement.setString(3, end.getCep());
            statement.setString(4, end.getCidade());
            statement.setString(5, end.getUf());
            statement.setInt(6, end.getId());

            statement.execute();

            return end;

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
