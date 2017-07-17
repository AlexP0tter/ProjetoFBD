/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;


import br.com.fachada.Fachada;
import br.com.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author heldonjose
 */
public class JdbcFbd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Ant2");

        Fachada coreFachada = new Fachada();
        coreFachada.salvarCliente(cliente);
        
       // coreFachada.salvarProfessor(professor);
       // coreFachada.matricularAluno(aluno, curso);
        
        
    }

}
