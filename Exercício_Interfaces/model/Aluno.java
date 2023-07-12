package model;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable, Comparable {
  private String matr;
  
  final public static int NUM_DIGITOS_MATR = 10;

  public Aluno(String c,String n,int i,String m)throws Exception{
    super(c,n,i);
    this.setMatr(m);
  }

  public String getMatr(){
    return this.matr;
  }

  public void setMatr(String m)throws Exception{
    Aluno.validarMatri(m);
      this.matr=m;
  }

  public void mensagem(){
    System.out.println("\nDados do aluno: \n");
    System.out.println("CPF: "+getCpf());
    System.out.println("NOME: "+getNome());
    System.out.println("IDADE: "+getIdade());
    System.out.println("MATRÍCULA: "+this.matr); 
  }

  public static void validarMatri(String m) throws Exception{
    if(m==null)
      throw new Exception("Não pode ser nulo!");
    
    if(m.length()>NUM_DIGITOS_MATR)
      throw new Exception("Matrícula não pode ser maior que 10 caracteres! ");

    for(int i=0;i<m.length();i++){
      char l=m.charAt(i);

      if(!Character.isDigit(l))
        throw new Exception("Matrícula só pode ser dígitos!");
    }
   }
  
}
