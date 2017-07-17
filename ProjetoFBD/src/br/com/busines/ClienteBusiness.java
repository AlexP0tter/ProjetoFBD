/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.busines;

import br.com.dao.ClienteDao;
import br.com.model.Cliente;

/**
 *
 * @author Alexp0tter
 */
public class ClienteBusiness {
    
    private ClienteDao clienteDao;
    
    public ClienteBusiness() {
        clienteDao = new ClienteDao();
    }
    
    public boolean salvar(Cliente cliente){
        
        return clienteDao.salvar(cliente);
    }
    
}
