package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AbstractDao {
	
	public static boolean objetosRecuperados=false;
	
	public static void commit() {
		try {
			FileOutputStream arquivo = new FileOutputStream("C:\\Users\\aluno\\Desktop\\primeiraAv2\\av2\\Objetos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(arquivo);
			
			DaoObra daoObra = new DaoObra();
			oos.writeObject( daoObra.consultarTodos() );

			DaoEditora daoEditora = new DaoEditora();
			oos.writeObject( daoEditora.consultarTodos() );
			
			DaoPublicacao daoPublicacao = new DaoPublicacao();
			oos.writeObject( daoPublicacao.consultarTodos() );
			
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
			FileInputStream arquivo = new FileInputStream("C:\\Users\\aluno\\Desktop\\primeiraAv2\\av2\\Objetos.bin");
			ObjectInputStream ois = new ObjectInputStream(arquivo);
		
			DaoObra daoObra = new DaoObra();
			daoObra.setLista( (Obra[]) ois.readObject() );
			
			DaoEditora daoEditora = new DaoEditora();
			daoEditora.setLista( (Editora[]) ois.readObject() );
			
			DaoPublicacao daoPublicacao = new DaoPublicacao();
			Object obj = ois.readObject();
			daoPublicacao.setLista( (Publicacao[])obj );
			
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
