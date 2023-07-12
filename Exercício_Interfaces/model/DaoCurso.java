package model;

public class DaoCurso extends AbstractDao {
	
	package model;

	import util.Lista;
	import util.MeuArrayList;

	public class DaoCurso extends AbstractDao {
	
		final public static int NUM_MAX_CURSOS = 10;
		private static Lista listaCursos = new MeuArrayList();
		private static int numCursos = 0;

		public void setLista(Comparable[] novaLista) throws ModelException {
			for (int i = 0; i < novaLista.length; i++)
				this.listaCursos.adicionar(novaLista[i]);
		}

		public static int getNumCursos() {
			return DaoCurso.numCursos;
		}

		public void incluir(Comparable novo) throws ModelException {
			if (!(novo instanceof Curso))
				throw new ModelException("Você solicitou a persistência de um objeto que não é Aluno");
			DaoCurso.listaCursos.adicionar(novo);
		}

		public void alterar(Comparable obj) throws ModelException {
			if (!(obj instanceof Curso))
				throw new ModelException("Você solicitou a alteração de um objeto que não é Aluno");
			int pos = DaoCurso.listaCursos.posicaoDe(obj);
			if (pos == Lista.NAO_ACHEI)
				throw new ModelException(
						"Você solicitou a alteração de um objeto que não existia. Chame o método incluir primeiro!");
		}

		public void excluir(Comparable obj) throws ModelException {
			
			if (!(obj instanceof Curso))
				throw new ModelException("Você solicitou a exclusão de um objeto que não é Curso");

			if (!DaoCurso.listaCursos.removerElemento(obj))
				throw new ModelException("Você solicitou a exclusão de um objeto que não faz parte da lista de cursos");
		}

		public Comparable[] consultarTodos() throws ModelException {
			return DaoCurso.listaCursos.obterElementos();
		}

		public Curso consultarPelaSigla(String sigla) throws ModelException {
			for(int i = 0; i < DaoCurso.listaCursos.getNumElementos(); i++) {						
				Curso c = (Curso)DaoCurso.listaCursos.obterElemento(i);			
				if(c.getSigla().equals(sigla)) {
					return c;
				}				
			}	
			return null;
		}
		
		
}



