package model;

import util.Lista;
import util.MeuArrayList;

public class DaoObra extends AbstractDao{
	
	final public static int NUM_OBRA=10;
	
	private static Lista listaObra = new MeuArrayList();
	
	public void setLista(Comparable[] novaLista) throws ModelException {
		for(int i = 0; i < novaLista.length; i++)
			this.listaObra.adicionar(novaLista[i]);
	}
	
	public static int getNumObra() {
		return DaoObra.listaObra.getNumElementos();
	}
	
	public void incluir(Comparable novo) throws ModelException {
		if(! (novo instanceof Obra) )
			throw new ModelException("Voc� solicitou a persist�ncia de um objeto que n�o � Obra");
		DaoObra.listaObra.adicionar(novo);
	}
	
	public void alterar(Comparable obj) throws ModelException {
		if(! (obj instanceof Obra) )
			throw new ModelException("Voc� solicitou a altera��o de um objeto que n�o � Obra");
		int pos = DaoObra.listaObra.posicaoDe(obj);
		if(pos == Lista.NAO_ACHEI)
			throw new ModelException("Voc� solicitou a altera��o de um objeto que n�o existia. Chame o m�todo incluir primeiro!");		
	}
	
	public void excluir(Comparable obj) throws ModelException {
		if(! (obj instanceof Obra) )
			throw new ModelException("Voc� solicitou a exclus�o de um objeto que n�o � Aluno");

		if(!DaoObra.listaObra.removerElemento(obj))
			throw new ModelException("Voc� solicitou a exclus�o de um objeto que n�o faz parte da lista de obras");		
	}
	
	public Obra[] consultarTodos() throws ModelException {
		
		Obra[] retorno=new Obra[DaoObra.listaObra.getNumElementos()];
		for(int i=0;i<retorno.length;i++)
			retorno[i]=(Obra)DaoObra.listaObra.obterElemento(i);
		
		return retorno;
	}
	
	public Obra consultarPeloCpf(String titulo) throws ModelException {
		for(int i = 0; i < DaoObra.listaObra.getNumElementos(); i++) {						
			Obra o = (Obra)DaoObra.listaObra.obterElemento(i);				
			if(o.getTitulo().equals(titulo)) {
				return o;
			}				
		}
		
		return null;		
	}
	
}