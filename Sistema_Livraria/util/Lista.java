package util;

public interface Lista {
	
	public final static int NAO_ACHEI = -1;
	public abstract void adicionar(Comparable novo);
	public abstract int getNumElementos();
	public abstract Comparable obterElemento(int pos) throws ArrayIndexOutOfBoundsException;
	public abstract boolean removerElemento(int pos);
	public abstract int posicaoDe(Comparable elem);
	public abstract boolean removerElemento(Comparable elem);
	public abstract Comparable[] obterElementos();
	public abstract void ordenar();

}
