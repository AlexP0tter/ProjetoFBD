/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Locacao;
import br.com.util.ConnectionFactory;
import br.com.util.SqlUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alexp0tter
 */
public class LocaDao {
    
    Connection con;
    PreparedStatement statement;

    public LocaDao() {
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
    public Locacao salvar(Locacao loc)throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_LOCACAO_ALL);
            statement.setInt(1, loc.getId());
            statement.setString(2, loc.getCliente());
            statement.setString(3, loc.getCarro());
            statement.setString(4, loc.getFun());            
            statement.setString(5, loc.getDataRetirada());
            statement.setString(6, loc.getDataDevolucao());
            statement.setDouble(7, loc.getValor());            
            
            statement.execute();
            return loc;
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
    
    public Locacao alterar(Locacao loc)throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.UPDATE_LOCACAO);            
            
            statement.setString(1, loc.getCliente());
            statement.setString(2, loc.getCarro());
            statement.setString(3, loc.getFun());            
            statement.setString(4, loc.getDataRetirada());
            statement.setString(5, loc.getDataDevolucao());
            statement.setDouble(6, loc.getValor()); 
            statement.setInt(7, loc.getId());
            
            statement.execute();
                    
            return loc;
                     
            
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
