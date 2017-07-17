/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.busines;

import br.com.dao.CarrosDao;
import br.com.model.Carro;

/**
 *
 * @author Alexp0tter
 */


public class CarroBusiness {
    
    private CarrosDao carroDao;
    
    public CarroBusiness() {
        carroDao = new CarrosDao();
    }
    
    public boolean salvar(Carro carro){
        
        return carroDao.salvar(carro);
    }
    
}
