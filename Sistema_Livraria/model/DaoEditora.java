package model;

import util.Lista;
import util.MeuArrayList;

public class DaoEditora extends AbstractDao{
	
	final public static int NUM_EDITORA=10; 
	
	private static Lista listaEditora = new MeuArrayList();
	
	public void setLista(Comparable[] novaLista) throws ModelException {
		for(int i = 0; i < novaLista.length; i++)
			this.listaEditora.adicionar(novaLista[i]);
	}
	
	public static int getNumEditora() {
		return DaoEditora.listaEditora.getNumElementos();
	}
	
	public void incluir(Comparable novo) throws ModelException {
		if(! (novo instanceof Editora) )
			throw new ModelException("Você solicitou a persistência de um objeto que não é Editora");
		DaoEditora.listaEditora.adicionar(novo);
	}
	
	public void alterar(Comparable obj) throws ModelException {
		if(! (obj instanceof Editora) )
			throw new ModelException("Você solicitou a alteração de um objeto que não é Editora");
		int pos = DaoEditora.listaEditora.posicaoDe(obj);
		if(pos == Lista.NAO_ACHEI)
			throw new ModelException("Você solicitou a alteração de um objeto que não existia. Chame o método incluir primeiro!");		
	}
	
	public void excluir(Comparable obj) throws ModelException {
		if(! (obj instanceof Editora) )
			throw new ModelException("Você solicitou a exclusão de um objeto que não é Aluno");

		if(!DaoEditora.listaEditora.removerElemento(obj))
			throw new ModelException("Você solicitou a exclusão de um objeto que não faz parte da lista de editora");		
	}
	
	public Editora[] consultarTodos() throws ModelException {
	
		Editora[] retorno=new Editora[DaoEditora.listaEditora.getNumElementos()];
		for(int i=0;i<retorno.length;i++)
			retorno[i]=(Editora)DaoEditora.listaEditora.obterElemento(i);
		
		return retorno;
	}
	
	public Editora consultarPeloCnpj(String cnpj) throws ModelException {
		for(int i = 0; i < DaoEditora.listaEditora.getNumElementos(); i++)  {						
			Editora ed = (Editora)DaoEditora.listaEditora.obterElemento(i);			
			if(ed.getCnpj().equals(cnpj)) {
				return ed;
			}				
		}
	return null;		
	}

}
