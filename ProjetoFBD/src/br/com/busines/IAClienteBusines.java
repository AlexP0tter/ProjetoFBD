/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.busines;

import br.com.model.Cliente;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public interface IAClienteBusines {
    
    public boolean salvarOuEditar(Cliente cliente);
    public Cliente buscarPorid(Long id);
    public List<Cliente> getAllI()throws Exception;
    
}
