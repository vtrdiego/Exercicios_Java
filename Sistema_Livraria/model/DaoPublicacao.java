package model;

import util.Lista;
import util.MeuArrayList;

public class DaoPublicacao extends AbstractDao {

	final public static int NUM_PUBLICACAO=10;
	
	private static Lista listaPublicacao = new MeuArrayList();
	
	public void setLista(Comparable[] novaLista) throws ModelException {
		for(int i = 0; i < novaLista.length; i++)
			this.listaPublicacao.adicionar(novaLista[i]);
	}
	
	public static int getNumPublicacao() {
		return DaoPublicacao.listaPublicacao.getNumElementos();
	}
	
	public void incluir(Comparable novo) throws ModelException {
		if(! (novo instanceof Publicacao) )
			throw new ModelException("Você solicitou a persistência de um objeto que não é Publicação");
		DaoPublicacao.listaPublicacao.adicionar(novo);
	}
	
	public void alterar(Comparable obj) throws ModelException {
		if(! (obj instanceof Publicacao) )
			throw new ModelException("Você solicitou a alteração de um objeto que não é Publicação");
		int pos = DaoPublicacao.listaPublicacao.posicaoDe(obj);
		if(pos == Lista.NAO_ACHEI)
			throw new ModelException("Você solicitou a alteração de um objeto que não existia. Chame o método incluir primeiro!");		
	}
	
	public void excluir(Comparable obj) throws ModelException {
		if(! (obj instanceof Publicacao) )
			throw new ModelException("Você solicitou a exclusão de um objeto que não é Publicação");

		if(!DaoPublicacao.listaPublicacao.removerElemento(obj))
			throw new ModelException("Você solicitou a exclusão de um objeto que não faz parte da lista de publicações");		
	}
	
	public Publicacao[] consultarTodos() throws ModelException {		
		Publicacao[] retorno=new Publicacao[DaoPublicacao.listaPublicacao.getNumElementos()];
		for(int i=0;i<retorno.length;i++)
			retorno[i]=(Publicacao)DaoPublicacao.listaPublicacao.obterElemento(i);
		
		return retorno;
	}
	
	public Publicacao consultarPeloIsbn(String isbn) throws ModelException {
		for(int i = 0; i < DaoPublicacao.listaPublicacao.getNumElementos(); i++) {						
			Publicacao pu = (Publicacao)DaoPublicacao.listaPublicacao.obterElemento(i);			
			if(pu.getIsbn().equals(isbn)) {
				return pu;
			}				
		}
		return null;		
	}
	
}
