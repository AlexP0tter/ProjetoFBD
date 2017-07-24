/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.fachada;

import br.com.projeto.entidades.Aluno;
import br.com.projeto.entidades.Professor;
import java.util.List;


public interface ICoreFacade {
    
          
    public boolean salvarOuEditarAluno(Aluno aluno);
    public Aluno buscarAlunoPorid(Long id);
    public List<Aluno> getAlunos();
    
    
    public boolean salvarOuEditarProfessor(Professor professor);
    public Aluno buscarProfessorPorid(Long id);
    public List<Professor> getProfessores();
    
    
    
}
