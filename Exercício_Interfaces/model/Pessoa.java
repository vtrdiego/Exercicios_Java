package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
	
	final public static int NUM_MAX_PESSOAS= 10;
	
	private static Pessoa[] listaPessoas= new Pessoa[Pessoa.NUM_MAX_PESSOAS];
	private static int numPessoas=0;
	
	private String cpf;
	private String nome;
	private int idade;

  public Pessoa(String c,String n,int i){
    this.setCpf(c);
    this.setNome(n);
    this.setIdade(i);
    
    Pessoa.listaPessoas[Pessoa.numPessoas++]=this;
  }
  
  public static int getNumPessoas() {
	return Pessoa.numPessoas;
  }
  

  public static Pessoa[] getListaPessoas() {
	return Pessoa.listaPessoas;
  }
  
  public static void setListaPessoas(Pessoa[] novaLista) {
		Pessoa.listaPessoas = novaLista;
		
		for(int i = 0; i < Pessoa.NUM_MAX_PESSOAS; i++) {
			if(Pessoa.listaPessoas[i] != null)
				System.out.println(Pessoa.listaPessoas[i]);
			else {
				Pessoa.numPessoas = i;
				break;
			}
		}
	}
  

  public String getCpf(){
    return this.cpf;
  }

  public String getNome(){
    return this.nome;
  }

  public int getIdade(){
    return this.idade;
  }

  public void setCpf(String c){
    this.cpf=c;
  }

  public void setNome(String nm){
    this.nome=nm;
  }

  public void setIdade(int i){
    this.idade=i;
  }

  public void mensagem(){
    System.out.println("\nDados da Pessoa:\n");
    System.out.println("CPF: "+getCpf()); 
    System.out.println("NOME: "+getNome());
    System.out.println("IDADE: "+getIdade());
  }

}
