/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.business;

import br.com.projeto.dao.AlunoDao;
import br.com.projeto.dao.IAlunoDao;
import br.com.projeto.entidades.Aluno;
import br.com.projeto.entidades.Contato;
import java.util.List;

/**
 *
 * @author heldonjose
 */
public class AlunoBusiness implements IAlunoBusiness {

    private IAlunoDao alunoDao;

    public AlunoBusiness() {
        this.alunoDao = new AlunoDao();
    }

    @Override
    public boolean salvarOuEditar(Aluno aluno) {
        try {
            if (aluno.getId() == null) {
                aluno  = alunoDao.salvar(aluno);
                
                for (Contato c : aluno.getContatos()) {
                    System.out.println(c.getTipo());
                    System.out.println(c.getDescricao());
                    alunoDao.salvarContato(c, aluno.getId());
                }
                return true;
            }
            if (aluno.getId() != null) {
                alunoDao.editar(aluno);
                return true;
            }

        } catch (Exception e) {
                e.printStackTrace();
               // O que fazer com a exeçao.. 
        }
        return false;

    }

    @Override
    public Aluno buscarPorid(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> getAllI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
