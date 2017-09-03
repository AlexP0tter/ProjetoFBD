/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Carro;
import br.com.model.Cliente;
import br.com.model.Endereco;
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
    PreparedStatement statement,statement2;
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
            Long idEnd = salvarEndereco(cliente.getEndereco());
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_CLIENTE_ALL);

            statement.setInt(1, cliente.getId());
            statement.setLong(2, idEnd);
            statement.setString(3, cliente.getCPF());
            statement.setString(4, cliente.getNome());
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

            statement.setString(1, cliente.getCPF());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getContato());  
            statement.setInt(4, cliente.getId());
            
            statement2 = con.prepareStatement(SqlUtil.UPDATE_ENDERECO);
            
            statement2.setString(1, cliente.getEndereco().getRua());
            statement2.setString(2, cliente.getEndereco().getBairro());
            statement2.setString(3, cliente.getEndereco().getCidade());            
            statement2.setString(4, cliente.getEndereco().getUf()); 
            statement2.setString(5, cliente.getEndereco().getCep());
           
           // statement2.setLong(6, cliente.getEndereco().getId());
            statement2.setLong(6, cliente.getId());
            statement2.execute();

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
    
    private Long salvarEndereco(Endereco end) throws Exception{
        
        try{
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_ENDERECO_ALL);

            statement.setInt(1, end.getId());
            statement.setString(2, end.getRua());
            statement.setString(3, end.getBairro());
            statement.setString(4, end.getCep());
            statement.setString(5, end.getCidade());
            statement.setString(6, end.getUf());
            statement.execute();
            
            statement = con.prepareStatement("select * from endereco");
            result = statement.executeQuery();
            
            while(result.next()){
                if(result.isLast()){
                    return result.getLong("id");
                }
            }
            
            return new Long(0);
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                throw new Exception(ex1.getMessage());
            }
            throw new Exception(ex.getMessage());
    }
   }
    
    
}
