/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fachada;

import br.com.busines.CarroBusiness;
import br.com.busines.ClienteBusiness;
import br.com.busines.FuncionarioBusiness;
import br.com.model.Carro;
import br.com.model.Cliente;
import br.com.model.Funcionario;
import java.util.List;

/**
 *
 * @author Alexp0tter
 */
public class Fachada {
    
    private static Fachada fachada;

    //Todos os business
    private ClienteBusiness clienteBusiness;
    private CarroBusiness carroBusiness;
    private FuncionarioBusiness funcionarioBusiness;

    public Fachada() {
        clienteBusiness = new ClienteBusiness();
        carroBusiness = new CarroBusiness();
        funcionarioBusiness = new FuncionarioBusiness();
        
        
    }

    public static Fachada getInstace() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }

    public boolean salvarCliente(Cliente cliente) {
        return clienteBusiness.salvar(cliente);
    }
    
    public boolean salvarCarro(Carro carro) {
        return carroBusiness.salvar(carro);
    }
    
    public boolean salvarFuncionario(Funcionario funcionario) {
        return funcionarioBusiness.salvar(funcionario);
    }
    
    public List<Carro> buscarCarro(String busca){
        
        return carroBusiness.buscarCarro(busca);
    }
    
}
