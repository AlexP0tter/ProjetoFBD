/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.busines;

import br.com.model.Carro;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public interface IACarrosBusines {
    
    public boolean salvarOuEditar(Carro carro);
    public Carro buscarPorid(int id);
    public List<Carro> getAllI()throws Exception;
    
}
