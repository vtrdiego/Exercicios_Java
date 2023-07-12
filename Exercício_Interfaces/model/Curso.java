package model;

import java.io.Serializable;

public class Curso implements Serializable, Comparable{
	
  private String codigo;
  private String nome;
  private String tipo;
  private int cargaHoraria;

  public Curso(String c,String n,String t,int ch)throws Exception{
    this.setCodigo(c);
    this.setNome(n);
    this.setTipo(t);
    this.setCargaHoraria(ch);
  }

  public String getCodigo(){
    return this.codigo;
  }

  public String getNome(){
    return this.nome;
  }

  public String getTipo(){
    return this.tipo;
  }

  public int getCargaHoraria(){
    return this.cargaHoraria;
  }

  public void setCodigo(String c)throws Exception{
    Curso.validarCodigo(c);
      this.codigo=c;
  }

  public void setNome(String n)throws Exception{
    Curso.validarNome(n);
      this.nome=n;
  }

  public void setTipo(String t)throws Exception{
    Curso.validarTipo(t);
      this.tipo=t;
  }

  public void setCargaHoraria(int ch)throws Exception{
    Curso.validarCargaHoraria(ch,getTipo());
      this.cargaHoraria=ch;
  }

  public void mensagem(){
    System.out.println("\nDados do Curso: \n");
    System.out.println("CODIGO: "+getCodigo());
    System.out.println("NOME: "+getNome());
    System.out.println("TIPO: "+getTipo());
    System.out.println("CARGA HORÁRIA: "+this.cargaHoraria); 
  }

  public static void validarCodigo(String c)throws Exception{
    if(c.length()>3)
      throw new Exception("Código não pode ter mais de três caracteres!");

    for(int i=0;i<c.length();i++){
      char l=c.charAt(i);

      if(!Character.isUpperCase(l))
        throw new Exception("Código deve ter apenas letras maiúsculas!");
    }

  }

  public static void validarNome(String n)throws Exception{
  int cont=0;
    
    if(n==null)
      throw new Exception("O nome não pode ser nulo!");
    
    if(n.length()>60)
      throw new Exception("O nome não pode ter mais de 60 caracteres!");
    
    for(int i=0;i<n.length();i++){
      char l=n.charAt(i);

      if(Character.isLetter(l) || l==' ')
          cont++;
      }

    if(cont!=n.length())
      throw new Exception("Só pode haver letras ou espaço em branco no nome!");
    
  }

  public static void validarTipo(String t)throws Exception{
    int cont=0;
    
    if(t==null)
      throw new Exception("Tipo não pode ser nulo!");
    
    String cst="Curso Superior de Tecnologia";
    String b="Bacharelado";
    String l="Licenciatura";
    
    if(!t.equalsIgnoreCase(cst))
    	if(!t.equalsIgnoreCase(b))
    		if(!t.equalsIgnoreCase(l))
    			throw new Exception("Tipo inserido é inválido!");
    		
  }

  public static void validarCargaHoraria(int ch,String t)throws Exception{
    
    if(ch==0)
    throw new Exception("Carga Horária não pode ser zerada!");

    String cst="Curso Superior de Tecnologia";
    String b="Bacharelado";
    String l="Licenciatura";

    if(t.equalsIgnoreCase(cst)){
      if(ch<1400 || ch>2800) {
    	  throw new Exception("Carga H. não é compatível com Curso Superior!");
      }
    }else if(t.equalsIgnoreCase(b)){
      if(ch<3000 || ch>6400) {
    	  throw new Exception("Carga H. não é compatível com Bacharelado!");
      }
    }else if(t.equalsIgnoreCase(l)){
      if(ch<2880 || ch>3400) {
    	  throw new Exception("Carga H. não é compatível com Licenciatura!");
      }
    }
   }
  
}
