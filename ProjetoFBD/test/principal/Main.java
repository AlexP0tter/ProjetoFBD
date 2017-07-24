/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.principal;

import br.com.projeto.entidades.Aluno;
import br.com.projeto.entidades.Contato;
import br.com.projeto.enuns.TipoContato;
import br.com.projeto.fachada.CoreFacade;
import br.com.projeto.fachada.ICoreFacade;

/**
 *
 * @author heldonjose
 */
public class Main {
    
    public static void main(String[] a){
        
        ICoreFacade facade = new CoreFacade();
        
        
        Aluno aluno = new Aluno();
        aluno.setNome("Heldon");
        aluno.setCpf("123.123.123-12");
        
        aluno.getEndereco().setCep("58701-090");
        aluno.getEndereco().setLogradouro("Capitao");
        
        Contato contato1 = new Contato();
        contato1.setTipo(TipoContato.EMAIL.getTipo());
        contato1.setDescricao("heldonjose@gmail.com");
        
        Contato contato2 = new Contato();
        contato2.setTipo(TipoContato.TELEFONE.getTipo());
        contato2.setDescricao("99627-9632");
        
        aluno.getContatos().add(contato1);
        aluno.getContatos().add(contato2);
        
        facade.salvarOuEditarAluno(aluno);
        
        
       // facade.salvarOuEditarAluno(aluno)
       
    }
    
}
