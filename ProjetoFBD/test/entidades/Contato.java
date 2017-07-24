
package br.com.projeto.entidades;

import br.com.projeto.enuns.TipoContato;


public class Contato {
    
    private Long id;
    private String tipo;
    private String descricao;

    public Contato() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    
}
