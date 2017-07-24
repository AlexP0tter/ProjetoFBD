/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.business;

import br.com.projeto.dao.IProfessorDao;
import br.com.projeto.dao.ProfessorDao;

/**
 *
 * @author heldonjose
 */
public class ProfessorBusiness implements IProfessorBusiness{
    
    private IProfessorDao professorDao;

    public ProfessorBusiness() {
    this.professorDao = new ProfessorDao();
    }
    
    
    
    
}
