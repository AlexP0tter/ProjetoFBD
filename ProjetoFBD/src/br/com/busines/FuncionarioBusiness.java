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
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public class FuncionarioBusiness implements IAFuncionarioBusines {
    
     private FuncionarioDao funcionarioDao;
    
    public FuncionarioBusiness() {
        funcionarioDao = new FuncionarioDao();
    }
    /*
    public Funcionario salvar(Funcionario funcionario){
        
        
    }
*/
    @Override
    public boolean salvarOuEditar(Funcionario fun) {
        
        try{
        funcionarioDao.salvar(fun);
        return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Funcionario buscarPorid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> getAllI() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
