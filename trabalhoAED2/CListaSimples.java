class CCelulaSimples {
	public Object item;
	public CCelulaSimples prox;
}

public class CListaSimples {
	private CCelulaSimples primeira, ultima;
	
	/**
	 * Função Construtora.
	*/
	public CListaSimples() {
		//Vazio
	}
	
	/**
	 * Método que verifica se a lista está vazia.
	 * @return true - caso lista vazia.
	 * @return false - se contem elementos.
	*/
	public boolean vazia() {
		return primeira == ultima;
	}
	
	/**
	 * Método que insere o elemento no começo.
	 * @param valorItem - item a ser inserido.
	*/
	public void insereComeco(Object valorItem) {		
		CCelulaSimples aux = new CCelulaSimples();
		aux.item = valorItem; 
		aux.prox = primeira;
		primeira = aux;
		if (primeira.prox == null)
			ultima = primeira;
	}
	
	/**
	 * Método que remove o elemento no começo.
	 * @return valorItem - item a ser removidoo.
	*/
	public Object removeComeco(){
		if (primeira != ultima) {
			CCelulaSimples aux = primeira;
			primeira = aux.prox;
			return aux.item;
		}
		return null;
	}
	
	/**
	 * Método que insere o elemento no fim.
	 * @param valorItem - item a ser inserido.
	*/
	public void insereFim(Object valorItem) {
		ultima.prox = new CCelulaSimples();
		ultima.prox.item = valorItem;
		ultima = ultima.prox;
	}
	
	/**
	 * Método que remove o elemento no fim.
	 * @return valorItem - item a ser removido.
	*/
	public Object removeFim() {
		if (primeira != ultima) {
			CCelulaSimples aux = primeira;
			while (aux.prox != ultima)
				aux = aux.prox;
			CCelulaSimples aux2 = aux.prox;
			ultima = aux;
			ultima.prox = null;
			return aux2.item;
		}
		return null;
	}
	
	/**
	 * Método que imprime a lista.
	*/
	public void imprime() {
		for (CCelulaSimples aux = primeira; aux != null; aux = aux.prox)
			System.out.print(aux.item + " ");
		System.out.println("");
	}
	
	/**
	 * Método que verifica se um elemento está contido na lista.
	 * @param elemento - item a ser procurado.
	 * @return true - lista contem elemento.
	 * @return false - lista não contem elemento.
	*/
	public boolean contem(Object elemento){
		boolean contem = false;
		for (CCelulaSimples aux = primeira; aux != null && !contem; aux = aux.prox)
			contem = elemento.equals(aux.item);
		return contem;
	}
}