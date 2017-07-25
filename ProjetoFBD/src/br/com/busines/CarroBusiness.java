/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.busines;

import br.com.dao.CarrosDao;
import br.com.model.Carro;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */


public class CarroBusiness implements IACarrosBusines{
    
    private CarrosDao carroDao;
    
    public CarroBusiness() {
        carroDao = new CarrosDao();
    }
    /*
    public boolean salvar(Carro carro){
        
        return carroDao.salvar(carro);
    }
*/

    @Override
    public boolean salvarOuEditar(Carro carro) {
    try{
        carroDao.salvar(carro);
        return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    return false;
    }

    @Override
    public Carro buscarPorid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carro> getAllI() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
