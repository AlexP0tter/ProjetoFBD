/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.LocacaoModel;
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
    public LocacaoModel salvar(LocacaoModel loc)throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_LOCACAO_ALL);
            statement.setInt(1, loc.getId());
            statement.setInt(2, loc.getCliente().getId());
            statement.setInt(3, loc.getFun().getId());
            statement.setInt(4, loc.getCarro().getId());            
            statement.setString(5, loc.getDataRetirada());
            statement.setString(6, loc.getDataDevolucao());
            statement.setDouble(7, loc.getValor());
            statement.setBoolean(8, loc.isStatusLocacao());
            
            
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
    
    public LocacaoModel alterar(LocacaoModel loc)throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.UPDATE_LOCACAO);            
          
            statement.setString(1, loc.getDataRetirada());
            statement.setString(2, loc.getDataDevolucao());
            statement.setDouble(3, loc.getValor());
            statement.setBoolean(4, loc.isStatusLocacao()); 
            statement.setInt(5, loc.getId());
            
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
