/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Carro;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public interface IaCarroDao {
    
    public Carro salvar(Carro carro)throws Exception;
    public boolean editar(Carro carro);
    public Carro buscarPorid(Carro carro)throws Exception;
    public List<Carro> getAllI()throws Exception;
    
}
