
package br.com.projeto.enuns;

public enum TipoContato {
    
     EMAIL("EMAIL"),
     TELEFONE("TELEFONE");
    
    private String tipo;
    
    private TipoContato (String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    } 
    
}
