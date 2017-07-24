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
public class ClienteDao implements IaClienteDao{
    
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
    public Cliente salvar(Cliente cliente)throws Exception {
        try {
            statement = con.prepareStatement(SqlUtil.SQL_INSERT_CLIENTE_ALL);
            
            statement.setInt(1, cliente.getId());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getCPF());
            statement.setString(4, cliente.getEndereco());
            statement.setString(5, cliente.getContato());            
            statement.execute();
            
            
            statement = con.prepareStatement(SqlUtil.SELECT_CLIENTE_ULTIMO_REGISTRO);        
            result = statement.executeQuery();            
            result.next();
            
            cliente.setId(new Integer(result.getInt("id")));                 
            
            return cliente;
            
            //statement.executeQuery(); consulta no bd, retorna uma lisat de valores
            //statement.executeUpdate(); execulta uma inclusao, exclusao, alteração
            //result.getString("nome do campo na tabela"); recupera valor
            
            
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

    /**
     *
     * @param cliente
     * @return
     * @throws Exception
     */
    @Override
    public Cliente buscarPorid(Cliente cliente) throws Exception{
        try {
            statement = con.prepareStatement(SqlUtil.SELECT_CLIENTE_ULTIMO_REGISTRO);        
            result = statement.executeQuery();            
            result.next();            
            cliente.setId(new Integer(result.getInt("id")));
            
            return cliente;
            
            } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         throw new Exception("Erro....");
    }
    

    @Override
    public List<Cliente> getAllI() throws Exception{
        
        List<Cliente> lista = new ArrayList<>();
        ArrayList dados = new ArrayList();
        
        try{
            statement = con.prepareStatement(SqlUtil.SELECT);
            result.first();
            //result = statement.executeQuery();
            do{
            //lista.add(new Cliente(result.getInt("id"),result.getString("nome"),result.getString("cpf"),result.getString("endereco"),result.getString("contato")));
            dados.add(new Object[]{result.getInt("id"),result.getString("nome"),result.getString("cpf"),result.getString("endereco"),result.getString("contato")});
            }
            while(result.next());
            
            //return lista;
            return dados;
        
        }catch(SQLException ex){
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new Exception("Erro....");
    }
    
    

    @Override
    public boolean editar(Cliente aluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
