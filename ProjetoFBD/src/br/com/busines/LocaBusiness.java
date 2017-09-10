/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.busines;

import br.com.dao.LocaDao;
import br.com.model.LocacaoModel;

/**
 *
 * @author Alexp0tter
 */
public class LocaBusiness {
    
    private LocaDao locaDao;
    
    public LocaBusiness() {
        locaDao = new LocaDao();
    }
    /*
    public Funcionario salvar(Funcionario funcionario){
        
        
    }
*/
    
    public boolean salvar(LocacaoModel loc) {
        
        try{
        locaDao.salvar(loc);
        return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean alterar(LocacaoModel loc) {
        
        try{
        locaDao.alterar(loc);
        return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return true;
    } 
    
}
