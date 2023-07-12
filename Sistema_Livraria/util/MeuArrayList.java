package util;

public class MeuArrayList implements Lista {

	final public static int FATOR_CRESCIMENTO = 3;
	private Comparable[] meuArray;
	private int      numElementos;
	
	public MeuArrayList() {
		this.meuArray = new Comparable[FATOR_CRESCIMENTO];
		this.numElementos = 0;
		int i = Lista.NAO_ACHEI;
	}
	
	public void adicionar(Comparable novo) {
		if(this.numElementos == this.meuArray.length) {
			Comparable[] novoArray = new Comparable[ this.numElementos + FATOR_CRESCIMENTO ];
			for(int i = 0; i < this.numElementos; i++)
				novoArray[i] = this.meuArray[i];
			this.meuArray = novoArray;			
		}
		this.meuArray[ this.numElementos ] = novo;
		this.numElementos++;
	}
	
	public int getNumElementos() {
		return this.numElementos;
	}
	
	public Comparable obterElemento(int pos) throws ArrayIndexOutOfBoundsException {
		if(pos >= this.numElementos)
			throw new ArrayIndexOutOfBoundsException(pos);
		return this.meuArray[pos];
	}
	
	public boolean removerElemento(int pos) {
		if(pos >= this.numElementos)
			return false;
		for(int i = pos; i < this.numElementos - 1; i++)
			this.meuArray[i] = this.meuArray[i+1];
		this.meuArray[this.numElementos - 1] = null;
		this.numElementos--;
		return true;
	}

	public int posicaoDe(Comparable elem) {
		for(int i = 0; i < this.numElementos; i++)
			if(this.meuArray[i] == elem)
				return i;
		return NAO_ACHEI;
	}
	
	public boolean removerElemento(Comparable elem) {
		int pos = this.posicaoDe(elem);
		if(pos != NAO_ACHEI) {
			this.removerElemento(pos);
			return true;
		}
		return false;
	}
	
	public Comparable[] obterElementos() {
		Comparable[] copia = new Comparable[this.numElementos];
		for(int i = 0; i < this.numElementos; i++)
			copia[i] = this.meuArray[i];
		return copia;
	}
	
	public void ordenar() {
		for(int i = 0; i < meuArray.length - 1; i++) {
			int posMenor = i;
			for(int j = i + 1; j < meuArray.length; j++) {
				if(meuArray[j].compareTo(meuArray[posMenor]) < 0)
					posMenor = j;
			}
			Comparable aux = meuArray[i];
			meuArray[i] = meuArray[posMenor];
			meuArray[posMenor] = aux;
		}
	}
	
}
