package model;

public class Professor extends Pessoa{
	
	private static Pessoa[] listaPessoas= new Pessoa[Pessoa.NUM_MAX_PESSOAS];
	private static int numPessoas=0;
	
  	private int matrFuncional;
  	private String titulacaoProfessor;

  public Professor(String c,String n,int i,int mf,String t)throws Exception{
    super(c,n,i);
    this.setMatrFuncional(mf); 
    this.setTitulacaoProfessor(t);
    
    Professor.listaPessoas[Professor.numPessoas++]=this;
  }
  
  public static int getNumPessoas() {
		return Professor.numPessoas;
	  }
	  

	  public static Pessoa[] getListaPessoas() {
		return Professor.listaPessoas;
	  }
	  
	  public static void setListaPessoas(Pessoa[] novaLista) {
			Professor.listaPessoas = novaLista;
			
			for(int i = 0; i < Pessoa.NUM_MAX_PESSOAS; i++) {
				if(Professor.listaPessoas[i] != null)
					System.out.println(Professor.listaPessoas[i]);
				else {
					Professor.numPessoas = i;
					break;
				}
			}
		}

  public int getMatrFuncional(){
    return this.matrFuncional;
  }

  public String getTitulacaoProfessor(){
    return this.titulacaoProfessor;
  }

  public void setMatrFuncional(int mf) throws Exception{
    Professor.validaMatr(mf);
    this.matrFuncional=mf;
  }

  public void setTitulacaoProfessor(String t) throws Exception{
    Professor.validarTitulacao(t); 
      this.titulacaoProfessor=t;
  }

  public void mensagem(){
    System.out.println("\nDados do Professor: \n");
    System.out.println("CPF: "+getCpf()); 
    System.out.println("NOME: "+getNome());
    System.out.println("IDADE: "+getIdade());
    System.out.println("MATRÍCULA FUNCIONAL: "+this.matrFuncional);
  }

  public static void validaMatr(int m)throws Exception {
    if(m==0)
      throw new Exception("A matrícula não pode ser nula!");

    if(m<1000 && m>9999)
      throw new Exception("A matrícula deve estar entre 1000 e 9999!");

    String valor= String.valueOf(m);

    if(valor.length()>4 || valor.length()<4)
      throw new Exception("A matrícula deve ter 4 dígitos!");
  }

  public static void validarTitulacao(String t) throws Exception{
    
    if(t==null)
      throw new Exception("O valor não pode ser nulo!");
    
    String e="Especialista";
    String d="Doutor";
    String m="Mestre";
    
    if(!t.equalsIgnoreCase(e))
    	if(!t.equalsIgnoreCase(d))
    		if(!t.equalsIgnoreCase(m)) 
    			throw new Exception(" O título está incorreto! ");
    
  }
}
