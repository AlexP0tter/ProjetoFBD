/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.busines;

import br.com.dao.ClienteDao;
import br.com.model.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexp0tter
 */
public class ClienteBusiness {

    private ClienteDao clienteDao;

    public ClienteBusiness() {
        clienteDao = new ClienteDao();
    }

    public boolean salvarOuEditar(Cliente cliente) {

        try {
            clienteDao.salvar(cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean alterar(Cliente cliente) {

        try {
            clienteDao.alterar(cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }  

}
