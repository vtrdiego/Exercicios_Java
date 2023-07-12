package model;

import java.io.Serializable;

public class Obra implements Serializable,Comparable{
	
	final public static int TAM_TITULO=80;
	
	private String titulo;
	private String autor;
	private int ano;
	
	public Obra(String t,String a,int ao) throws Exception {
		this.setTitulo(t);
		this.setAutor(a);
		this.setAno(ao);
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public void setTitulo(String t) throws Exception{
		Obra.validarTitulo(t);
			this.titulo=t;
	}
	
	public void setAutor(String a){
		this.autor=a;
	}
	
	public void setAno(int ao){
		this.ano=ao;
	}
	
	public static void validarTitulo(String vt) throws Exception{
		if(vt==null)
			throw new Exception(" O título não pode ser nulo!");
		
		if(vt.length()>TAM_TITULO)
			throw new Exception(" O título não pode ser maior que 80 caracteres!");
		
		for(int i = 0; i < vt.length(); i++) {
			char c = vt.charAt(i);
			
			if(!Character.isAlphabetic(c))
				if(!Character.isDigit(c))
					if(c!=':' && c!=',' && c!=';' && c!='-' && c!='.')
						throw new Exception(" O título só pode ter Caracteres com letras, números, ponto e traço!");
				
		}
	}
	
	public String toString() {
		String resultado;
		
		resultado="\nOBRA:";
		resultado="\nTítulo: "+this.getTitulo();
		
		return resultado;
	}
	
	public int compareTo(Object outro) {
		if(!(outro instanceof Obra))
			return -1;
		Obra outraObra = (Obra)outro;
		return this.getTitulo().compareTo(outraObra.getTitulo());
	}
	
}
