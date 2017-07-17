/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.busines;

import br.com.dao.ClienteDao;
import br.com.dao.FuncionarioDao;
import br.com.model.Cliente;
import br.com.model.Funcionario;

/**
 *
 * @author Alexp0tter
 */
public class FuncionarioBusiness {
    
     private FuncionarioDao funcionarioDao;
    
    public FuncionarioBusiness() {
        funcionarioDao = new FuncionarioDao();
    }
    
    public boolean salvar(Funcionario funcionario){
        
        return funcionarioDao.salvar(funcionario);
    }
    
}
