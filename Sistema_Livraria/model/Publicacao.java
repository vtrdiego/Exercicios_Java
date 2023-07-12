package model;

import java.io.Serializable;

public class Publicacao implements Serializable, Comparable {
	
	final public static int TAM_ISBN=10;

	private String isbn;
	private int ano;
	private int numEdicao;
	private String tipoMidia;
	private Obra obra;
	private Editora editora;
	
	public Publicacao(String i,int an,int ne,String tm, Obra ob, Editora ed) throws Exception {
		this.setIsbn(i);
		this.setAno(an);
		this.setNumEdicao(ne);
		this.setTipoMidia(tm);
		this.setObra(ob);
		this.setEditora(ed);
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public int getNumEdicao() {
		return this.numEdicao;
	}
	
	public String getTipoMidia() {
		return this.tipoMidia;
	}
	
	public Obra getObra() {
		return this.obra;
	}
	
	public Editora getEditora() {
		return this.editora;
	}
	
	public void setIsbn(String i) throws Exception{
		Publicacao.validarIsbn(i);
			this.isbn=i;
	}
	
	public void setAno(int an) {
		this.ano=an;
	}
	
	public void setNumEdicao(int ne) throws Exception{
		Publicacao.validarNumEdicao(ne);
			this.numEdicao=ne;
	}
	
	public void setTipoMidia(String tm) throws Exception {
		Publicacao.validarTipoMidia(tm);
			this.tipoMidia=tm;
	}
	
	public void setObra(Obra o) throws Exception {
		Publicacao.validarObra(o);
			this.obra = o;
	}
	
	public void setEditora(Editora e) throws Exception {
		Publicacao.validarEditora(e);
			this.editora = e;
	}
	
	public static void validarIsbn(String isbn) throws Exception{
		if(isbn==null)
			throw new Exception(" O isbn n�o pode ser nulo!");
		
		if(isbn.length()>TAM_ISBN)
			throw new Exception(" O isbn n�o pode ser maior que 10 caracteres!");
		
	}
	
	public static void validarNumEdicao(int ne) throws Exception{
		if(ne<=0)
			throw new Exception(" O n�mero de edi��o deve ser maior que 0!");
	}
	
	public static void validarTipoMidia(String tm) throws Exception{
		if(tm==null)
			throw new Exception(" O tipo de m�dia n�o pode ser nulo!");
			
		String i="IMPRESSO";
		String d="DIGITAL";
		
		if(!tm.equalsIgnoreCase(i))
			if(!tm.equalsIgnoreCase(d))
				throw new Exception(" O formato de m�dia � inv�lido!");
	}
	
	public static void validarObra(Obra o) throws Exception {
		if(o == null)
			throw new Exception("A obra n�o foi indicada!");
	}
	
	public static void validarEditora(Editora e) throws Exception {
		if(e == null)
			throw new Exception("O curso n�o foi indicado!");
	}
	
	public String toString() {
		String resultado;
		
		resultado="\nPublica��o:";
		resultado="\nIsbn: "+this.getIsbn();
		resultado="\nAno: "+this.getAno();
		resultado="\nN� Edi��o: "+this.getNumEdicao();
		resultado="\nTipo de M�dia: "+this.getTipoMidia();
		resultado="\nObra: "+this.getObra();
		resultado="\nEditora"+this.getEditora();
		
		return resultado;
	}
	
	public int compareTo(Object outro) {
		if(!(outro instanceof Publicacao))
			return -1;
		Publicacao outraPublicacao = (Publicacao)outro;
		return this.getIsbn().compareTo(outraPublicacao.getIsbn());
	}
	
}
