package model;

public class DaoAluno extends AbstractDao {

	private static Lista listaAlunos = new MeuArrayList();
	
	public void setLista(Comparable[] novaLista) throws ModelException {
		for(int i = 0; i < novaLista.length; i++)
			this.listaAlunos.adicionar(novaLista[i]);
	}
	
	public static int getNumAlunos() {
		return DaoAluno.listaAlunos.getNumElementos();
	}

	public void incluir(Comparable novo) throws ModelException {
		if(! (novo instanceof Aluno) )
			throw new ModelException("Você solicitou a persistência de um objeto que não é Aluno");
		DaoAluno.listaAlunos.adicionar(novo);
	}

	public void alterar(Comparable obj) throws ModelException {
		
		if(! (obj instanceof Aluno) )
			throw new ModelException("Você solicitou a alteração de um objeto que não é Aluno");
		int pos = DaoAluno.listaAlunos.posicaoDe(obj);
		if(pos == Lista.NAO_ACHEI)
			throw new ModelException("Você solicitou a alteração de um objeto que não existia. Chame o método incluir primeiro!");		
	}
	
	public void excluir(Comparable obj) throws ModelException {
		
		if(! (obj instanceof Aluno) )
			throw new ModelException("Você solicitou a exclusão de um objeto que não é Aluno");

		if(!DaoAluno.listaAlunos.removerElemento(obj))
			throw new ModelException("Você solicitou a exclusão de um objeto que não faz parte da lista de alunos");		
	}

	public Comparable[] consultarTodos() throws ModelException {		
		return DaoAluno.listaAlunos.obterElementos();		
	}

	public Aluno consultarPelaMatr(String matr) throws ModelException {
		for(int i = 0; i < DaoAluno.listaAlunos.getNumElementos(); i++) {						
			Aluno a = (Aluno)DaoAluno.listaAlunos.obterElemento(i);			
			if(a.getMatr().equals(matr)) {
				return a;
			}				
		}	
		return null;		
	}
	
}
