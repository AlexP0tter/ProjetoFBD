/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.busines;

import br.com.dao.CarrosDao;
import br.com.dao.EnderecoDao;
import br.com.model.Carro;
import br.com.model.Endereco;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */


public class EnderecoBusiness{
    
    private EnderecoDao enderecoDao;
    
    public EnderecoBusiness() {
        enderecoDao = new EnderecoDao();
    }
   
    
    public boolean salvar(Endereco end) {
    try{
        enderecoDao.salvar(end);
        return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    return false;
    }
    
    public boolean alterar(Endereco end) {

        try {
            enderecoDao.alterar(end);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    
}
