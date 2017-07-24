/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.entidades.Aluno;
import br.com.projeto.entidades.Contato;
import br.com.projeto.entidades.Endereco;
import java.util.List;

/**
 *
 * @author heldonjose
 */
public interface IAlunoDao {
    
    
     public Aluno salvar(Aluno aluno)throws Exception;
    public boolean editar(Aluno aluno);
    public Aluno buscarPorid(Long id);
    public List<Aluno> getAllI();
    public void salvarContato(Contato contato, Long idAluno) throws Exception;
    
}
