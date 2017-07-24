/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fachada;

import br.com.busines.CarroBusiness;
import br.com.busines.ClienteBusiness;
import br.com.busines.FuncionarioBusiness;
import br.com.model.Carro;
import br.com.model.Cliente;
import br.com.model.Funcionario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexp0tter
 */
public class Fachada implements ICoreFacade {
    
    private static Fachada fachada;

    //Todos os business
    private ClienteBusiness clienteBusiness;
    private CarroBusiness carroBusiness;
    private FuncionarioBusiness funcionarioBusiness;

    public Fachada() {
        clienteBusiness = new ClienteBusiness();
        carroBusiness = new CarroBusiness();
        funcionarioBusiness = new FuncionarioBusiness();
        
        
    }

    public static Fachada getInstace() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }
/*
    public boolean salvarCliente(Cliente cliente) {
        return clienteBusiness.salvarOuEditar(cliente);
    }

    
    public boolean salvarCarro(Carro carro) {
        return carroBusiness.salvar(carro);
    }
    
    public boolean salvarFuncionario(Funcionario funcionario) {
        return funcionarioBusiness.salvar(funcionario);
    }
*/

    @Override
    public boolean salvarOuEditarCliente(Cliente cliente) {
        return clienteBusiness.salvarOuEditar(cliente);
    }

    @Override
    public Cliente buscarClientePorid(Long id) {
        return clienteBusiness.buscarPorid(id);
    }
    
        

    @Override
    public List<Cliente> getClientes() {
        try {
            return clienteBusiness.getAllI();
        } catch (Exception ex) {
            Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public boolean salvarOuEditarProfessor(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario buscarFUncionarioPorid(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> getFuncionarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
