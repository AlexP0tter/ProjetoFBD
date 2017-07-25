/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Cliente;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public interface IaClienteDao {
    
    public Cliente salvar(Cliente cliente)throws Exception;
    public boolean editar(Cliente aluno);
    public Cliente buscarPorid(Cliente cliente)throws Exception;
    public List<Cliente> getAllI()throws Exception;
    
    //public void salvarContato(Contato contato, Long idAluno) throws Exception;
    
}
