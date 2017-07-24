/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.entidades.Aluno;
import br.com.projeto.entidades.Contato;
import br.com.projeto.entidades.Endereco;
import br.com.projeto.util.ConnectionFactory;
import br.com.projeto.util.SqlUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heldonjose
 */
public class AlunoDao implements IAlunoDao {

    Connection conexaoPost;
    Connection conexaoMySql;
    PreparedStatement statment;
    ResultSet result;

    public AlunoDao() {
        try {
            conexaoPost = ConnectionFactory.getInstance(ConnectionFactory.TIPO_BASE_DADOS_POSTGRES);
            //  conexaoMySql = ConnectionFactory.getInstance(ConnectionFactory.TIPO_BASE_DADO_MY_SQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aluno salvar(Aluno aluno)throws Exception{

        try {
            Long id = salvarEndereco(aluno.getEndereco());
           // System.out.println("AQUI...." + id);
            statment = conexaoPost.prepareStatement(SqlUtil.INSERT_ALUNO_ALL);
            //statment.setLong(1, aluno.getId());
            statment.setString(1, aluno.getNome());
            statment.setString(2, aluno.getCpf());
            statment.setLong(3, id);
            statment.execute();

          
            
            statment = conexaoPost.prepareStatement(SqlUtil.SELECT_ALUNO_ULTIMO_REGISTRO);
            result = statment.executeQuery();
            
            result.next();
            aluno.setId(new Long(result.getInt("id")));
            return aluno;
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                conexaoPost.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
             throw new Exception("Erro....");
  
    }

    @Override
    public boolean editar(Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno buscarPorid(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> getAllI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Long salvarEndereco(Endereco end) throws Exception {
        try {
            statment = conexaoPost.prepareStatement(SqlUtil.INSERT_ENDERECO_ALL);
           // statment.setLong(1, end.getId());
            statment.setString(1, end.getCep());
            statment.setString(2, end.getLogradouro());
            statment.execute();
            
            statment = conexaoPost.prepareStatement("select * from endereco");
            result = statment.executeQuery();
            
            while(result.next()){
                if(result.isLast()){
                     return result.getLong("id");
                }
            }
           
            return new Long(0);
           

        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                conexaoPost.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                throw new Exception(ex1.getMessage());
            }
            throw new Exception(ex.getMessage());
        }

    }
    
    public void salvarContato(Contato contato, Long idAluno) throws Exception {
        try {
            statment = conexaoPost.prepareStatement(SqlUtil.INSERT_CONTATO_ALL);
          //  statment.setLong(1, contato.getId());
            statment.setString(1, contato.getTipo());
            statment.setString(2, contato.getDescricao());
            statment.setLong(3, idAluno);
            statment.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                conexaoPost.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                throw new Exception(ex1.getMessage());
            }
            throw new Exception(ex.getMessage());
        }

    }

}
