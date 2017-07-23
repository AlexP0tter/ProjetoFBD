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
    
    public List<Carro> buscarPorCarro(String busca){
        
        List<Carro> carros = new ArrayList<Carro>();
        try {
            statement = con.prepareStatement(SqlUtil.SQL_SELECT_CARRO);
            statement.setString(1,"%" + busca + "%");
            statement.setString(2,"%" + busca + "%");
            statement.setString(3,"%" + busca + "%");
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Carro carro = new Carro(Integer.parseInt(result.getString("id")), 
                        result.getString("modelo"), 
                        result.getString("marca"), 
                        result.getString("placa"), 
                        result.getString("categoria"));
                carros.add(carro);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CarrosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carros;
    }
    
    
}
