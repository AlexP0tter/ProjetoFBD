/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.busines;

import br.com.model.Funcionario;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public interface IAFuncionarioBusines {
    
    public boolean salvarOuEditar(Funcionario fun);
    public Funcionario buscarPorid(int id);
    public List<Funcionario> getAllI()throws Exception;
    
}
