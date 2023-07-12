package model;

public class Disciplina{
  private String codigo;
  private String nome;
  private int numCreditos;

  public Disciplina(String c,String n,int nc) throws Exception{
    this.setCodigo(c);
    this.setNome(n);
    this.setNumCreditos(nc);
  }

  public String getCodigo(){
    return this.codigo;
  }

  public String getNome(){
    return this.nome;
  }

  public int getNumCreditos(){
    return this.numCreditos;
  }

  public void setCodigo(String c) throws Exception{
    Disciplina.validarCodigo(c);
      this.codigo=c;
  }

  public void setNome(String n)throws Exception{
    Disciplina.validarNome(n);
      this.nome=n;
  }

  public void setNumCreditos(int nc)throws Exception{
    Disciplina.validaCreditos(nc);
      this.numCreditos=nc;
  }
  
  public void mensagem(){
    System.out.println("\nDados da Disciplina: \n");
    System.out.println("CODIGO: "+this.codigo); 
    System.out.println("NOME: "+this.nome);
    System.out.println("CRÉDITOS: "+this.numCreditos); 
  }

  public static void validarCodigo(String cod)throws Exception{
    if(cod==null)
      throw new Exception("A Disciplina não pode ser nula!");
    
    if(cod.length()!=8)
      throw new Exception("Código deve ter 8 dígitos!");
    
    for(int i=0;i<cod.length();i++){
      char l=cod.charAt(i);
      if(i<3){
        if(!Character.isUpperCase(l)){
          throw new Exception("As letras iniciais devem ser maiúsculas!");
        }
      }
      if(i>=3){
        if(Character.isLetter(l)){
          throw new Exception(" 5 últimos devem ser dígitos!");
          }
        }
    }

  }

  
  public static void validarNome(String n) throws Exception{
  int cont=0;
    
    if(n==null)
      throw new Exception("Nome não pode ser nulo!");
    
    if(n.length()>60)
      throw new Exception("Nomenão pode termais de 60 caracteres!");
    
    for(int i=0;i<n.length();i++){
      char l=n.charAt(i);

      if(Character.isLetter(l) || l==' ')
          cont++;
      }

    if(cont!=n.length())
      throw new Exception("Só pode haver letras ou espaço em branco no nome!");
    
  }

  public static void validaCreditos(int c)throws Exception{
    if(c==0)
      throw new Exception("Crédito não pode inicar zerado!");
    
    if(c<1 || c>8)
      throw new Exception("Crédito deve estar entre 1 e 8!");
    
  }
   
}