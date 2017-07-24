/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.business;

import br.com.projeto.entidades.Aluno;
import java.util.List;

/**
 *
 * @author heldonjose
 */
public interface IAlunoBusiness {
      
    public boolean salvarOuEditar(Aluno aluno);
    public Aluno buscarPorid(Long id);
    public List<Aluno> getAllI();
}
