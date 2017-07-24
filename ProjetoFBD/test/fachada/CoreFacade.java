/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.fachada;

import br.com.projeto.business.AlunoBusiness;
import br.com.projeto.business.IAlunoBusiness;
import br.com.projeto.entidades.Aluno;
import br.com.projeto.entidades.Professor;
import java.util.List;

/**
 *
 * @author heldonjose
 */
public class CoreFacade implements ICoreFacade{

    IAlunoBusiness alunoBusiness;
    
    public CoreFacade() {
        this.alunoBusiness = new AlunoBusiness();
    }
    

    @Override
    public boolean salvarOuEditarAluno(Aluno aluno) {
        return alunoBusiness.salvarOuEditar(aluno);
    }

    @Override
    public Aluno buscarAlunoPorid(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> getAlunos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean salvarOuEditarProfessor(Professor professor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno buscarProfessorPorid(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Professor> getProfessores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
