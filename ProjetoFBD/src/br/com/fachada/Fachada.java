/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fachada;

import br.com.busines.CarroBusiness;
import br.com.busines.ClienteBusiness;
import br.com.busines.EnderecoBusiness;
import br.com.busines.FuncionarioBusiness;
import br.com.busines.LocaBusiness;
import br.com.model.Carro;
import br.com.model.Cliente;
import br.com.model.Endereco;
import br.com.model.Funcionario;
import br.com.model.LocacaoModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexp0tter
 */
public class Fachada{
    
    private static Fachada fachada;

    //Todos os business
    private ClienteBusiness clienteBusiness;
    private CarroBusiness carroBusiness;
    private FuncionarioBusiness funcionarioBusiness;
    private LocaBusiness locaBusiness;
    private EnderecoBusiness endBusiness;

    public Fachada() {
        clienteBusiness = new ClienteBusiness();
        carroBusiness = new CarroBusiness();
        funcionarioBusiness = new FuncionarioBusiness(); 
        locaBusiness = new LocaBusiness();
        endBusiness = new EnderecoBusiness();
        
    }

    public static Fachada getInstace() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }
    
    public boolean salvarEnd(Endereco endereco) {
        return endBusiness.salvar(endereco);
    }
    
    public boolean alterarEnd(Endereco endereco) {
        return endBusiness.alterar(endereco);        
    }

   
    public boolean salvarCliente(Cliente cliente) {
        return clienteBusiness.salvarOuEditar(cliente);
    }
    
    public boolean alterarCliente(Cliente cliente) {
        return clienteBusiness.alterar(cliente);        
    }
    
    public boolean salvarFuncionario(Funcionario funcionario) {
        return funcionarioBusiness.salvarOuEditar(funcionario);
    }
    
    public boolean alterarFun(Funcionario fun) {
        return funcionarioBusiness.alterar(fun);
    }
    
    public boolean salvarCarro(Carro carro) {
        return carroBusiness.salvar(carro);
    }
    
    public boolean alterarCarro(Carro car) {
        return carroBusiness.alterar(car);
    }
    
    public boolean salvarLoca(LocacaoModel loc){
        return locaBusiness.salvar(loc);
        
    }
    
    public boolean alterarLoca(LocacaoModel loc){
       return locaBusiness.alterar(loc);
    }    

    

    
}
