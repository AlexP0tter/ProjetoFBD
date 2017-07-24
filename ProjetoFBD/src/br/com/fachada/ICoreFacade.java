/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fachada;


import br.com.model.Cliente;
import br.com.model.Funcionario;
import java.util.List;


public interface ICoreFacade {
    
          
    public boolean salvarOuEditarCliente(Cliente cliente);
    public Cliente buscarClientePorid(Long id);
    public List<Cliente> getClientes();
    
    
    public boolean salvarOuEditarProfessor(Funcionario funcionario);
    public Funcionario buscarFUncionarioPorid(Long id);
    public List<Funcionario> getFuncionarios();
    
    
    
}
