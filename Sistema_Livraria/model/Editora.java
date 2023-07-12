package model;

import java.io.Serializable;

public class Editora implements Serializable, Comparable{
	
	final public static int TAM_NOME=40;
	final public static int TAM_CNPJ=18;
	final public static int TAM_CIDADE=20;
		
	private String cnpj;
	private String nome;
	private String cidade;
	private String uf;
	
	public Editora(String c,String n,String cd,String uf)throws Exception {
		this.setCnpj(c);
		this.setNome(n);
		this.setCidade(cd);
		this.setUf(uf);
		
	}
	
	public String getCnpj() {
		return this.cnpj;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public String getUf() {
		return this.uf;
	}
	
	public void setCnpj(String c)throws Exception {
		Editora.validarCnpj(c);
			this.cnpj=c;
	}
	
	public void setNome(String n)throws Exception {
		Editora.validarNome(n);
			this.nome=n;
	}
	
	public void setCidade(String cd)throws Exception {
		Editora.validarCidade(cd);
			this.cidade=cd;
	}
	
	public void setUf(String uf)throws Exception {
		Editora.validarUf(uf);
			this.uf=uf;
	}
	
	public static void validarCnpj(String cnpj)throws Exception {
		if(cnpj==null)
			throw new Exception(" O cnpj não pode ser nulo!");
		
		if(cnpj.length()!=TAM_CNPJ)
			throw new Exception(" O cnpj não tem 18 caracteres!");
		
		for (int i = 0; i < TAM_CNPJ; i++) {
			char c = cnpj.charAt(i);
			switch(i) {
				case  2:
					if(c != '.')
						throw new Exception("Na posição " + (i+1) + " deve constar '.'");
				case  6: 
					if(c != '.') 
						throw new Exception("Na posição " + (i+1) + " deve constar '.'");
					break;
				case 10: 
					if(c != '/') 
						throw new Exception("Na posição " + (i+1) + " deve constar '/'");
					break;
				case 11:
					if(c!='0')
						throw new Exception("Na posição " + (i+1) + " deve constar '0'");
					break;
				case 12:
					if(c!='0')
						throw new Exception("Na posição " + (i+1) + " deve constar '0'");
					break;
				case 13:
					if(c!='0')
						throw new Exception("Na posição " + (i+1) + " deve constar '0'");
					break;
				case 14:
					if(c!='1')
						if(c!='2')
							throw new Exception("Na posição " + (i+1) + " deve constar '1' ou '2' ");
					break;
				case 15:
					if(c!='-')
						throw new Exception("Na posição " + (i+1) + " deve constar '-' ");
					break;
				default: 
					if(!Character.isDigit(c)) 
						throw new Exception("Na posição " + (i+1) + " deve ter um dígito!");
				}
			}
		
	}
	
	public static void validarNome(String n)throws Exception{
		if(n==null)
			throw new Exception(" Nome não pode ser nulo!");
		
		if(n.length()>TAM_NOME)
			throw new Exception(" Nome não pode ter mais de 40 caracteres!");
	}
	
	public static void validarCidade(String c)throws Exception{
		if(c==null)
			throw new Exception(" Cidade não pode ser nulo!");
		
		if(c.length()>TAM_CIDADE)
			throw new Exception(" Cidade não pode ter mais de 20 caracteres!");
	}
	
	public static void validarUf(String uf)throws Exception{
		if(uf==null)
			throw new Exception(" UF não pode ser nulo!");
		
		for(int i=0;i<uf.length();i++) {
			char l=uf.charAt(i);
			if(!Character.isUpperCase(l))
				throw new Exception(" UF deve estar em maiúsculo!");
		}
	}
	
	public String toString() {
		String resultado;
		
		resultado="\nEditora:";
		resultado="\nCnpj: "+this.getCnpj();
		
		return resultado;
	}
	
	public int compareTo(Object outro) {
		if(!(outro instanceof Editora))
			return -1;
		Editora outraEditora = (Editora)outro;
		return this.getNome().compareTo(outraEditora.getNome());
	}
	
	
}

