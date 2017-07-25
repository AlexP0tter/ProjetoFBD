/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Funcionario;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public interface IaFuncionarioDao {
    
    public Funcionario salvar(Funcionario fun)throws Exception;
    public boolean editar(Funcionario fun);
    
    public Funcionario buscarPorid(Funcionario fun)throws Exception;
    public List<Funcionario> getAllI()throws Exception;
    
}
