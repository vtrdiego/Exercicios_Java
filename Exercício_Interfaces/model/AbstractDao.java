package model;

import java.io.ObjectOutputStream;

public abstract class AbstractDao {

	public static boolean objetosRecuperados = false;

	public static void commit() {
		try {
			FileOutputStream arquivo = new FileOutputStream("C:\\Users\\diego\\Desktop\\Exercicio07\\Exercicio07\\src\\arquivos\\arquivos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(arquivo);
			
			DaoPessoa daoPessoa = new DaoPessoa();
			oos.writeObject( daoPessoa.consultarTodos() );

			DaoAluno daoAluno = new DaoAluno();
			oos.writeObject( daoAluno.consultarTodos() );
			
			DaoCurso daoCurso = new DaoCurso();
			oos.writeObject( daoCurso.consultarTodos() );
			
			DaoDisciplina daoDisciplina = new DaoDisciplina();
			oos.writeObject( daoDisciplina.consultarTodos() );
			
			DaoProfessor daoProfessor = new DaoProfessor();
			oos.writeObject( daoProfessor.consultarTodos() );
			
			oos.close();
		}
		catch (ModelException e) {
			System.out.println("Deu Ruim: " + e.getMessage());			
		} catch (FileNotFoundException e) {
			System.out.println("O arquivo de persistência não foi encontrado! " + e.getMessage());			
		} catch (IOException e) {
			System.out.println("Deu Ruim: " + e.getMessage());
		}
	}

	public static void recuperarObjetos() {
		if(AbstractDao.objetosRecuperados)
			return;
		try {
			FileInputStream arquivo = new FileInputStream("C:\\Users\\diego\\Desktop\\Exercicio07\\Exercicio07\\src\\arquivos\\arquivos.bin");
			ObjectInputStream ois = new ObjectInputStream(arquivo);
			// instanciamos um dao para cada classe para determinar a lista de objetos 
			// que eles irão gerenciar a partir da serialização.
			DaoPessoa daoPessoa = new DaoPessoa();
			daoPessoa.setLista( (Pessoa[]) ois.readObject() );
			
			DaoAluno daoAluno = new DaoAluno();
			daoAluno.setLista( (Aluno[]) ois.readObject() );
			
			DaoCurso daoCurso = new DaoCurso();
			Object obj = ois.readObject();
			daoCurso.setLista( (Curso[])ois.readObject() );
			
			DaoDisciplina daoDisciplina = new DaoDisciplina();
			daoDisciplina.setLista( (Disciplina[])ois.readObject() );
			
			DaoProfessor daoProfessor = new DaoProfessor();
			daoProfessor.setLista( (Professor[])ois.readObject() );
			
			ois.close();
			AbstractDao.objetosRecuperados = true;
		}
		catch (ModelException e) {
			System.out.println("Deu Ruim: " + e.getMessage());			
		} catch (FileNotFoundException e) {
			System.out.println("Deu Ruim: " + e.getMessage());			
		} catch (ClassNotFoundException e) {
			System.out.println("Deu Ruim: " + e.getMessage());			
		} catch (IOException e) {
			System.out.println("Deu Ruim: " + e.getMessage());			
		}
	}
	
	abstract public void setLista(Comparable[] lista) throws ModelException;

	abstract public void incluir(Comparable novo) throws ModelException;
	
	abstract public void alterar(Comparable obj) throws ModelException;

	abstract public void excluir(Comparable obj) throws ModelException;

	abstract public Comparable[] consultarTodos() throws ModelException;
}
