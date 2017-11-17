
package poo.heranca;

/**
 *
 * @author MarcoGorak
 */
public class Usuario {
    
    //Declaração de variáveis
    private String nome;
    private String cpf;
    private int dia,mes,ano;
    
    //Métodos get e set
    public String getNome (){
	 return this.nome; 
    }
	
    public void setNome (String nome){ 
        this.nome=nome; 
    }	

    public String getCpf(){
	return this.cpf;		
    }
	
    public void setCPF (String cpf){
	this.cpf=cpf;
    }

    
}
