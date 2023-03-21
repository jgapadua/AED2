
public class Deque {
	private CCelulaDup esquerda; // Referencia a ultima celula da esquerda (cabeça)
	private CCelulaDup direita; // Referencia a primeira celula da direita (rabo)
	private int q;
	
	/**
	 * Função construtora. Cria as células cabeça e rabo 
	 * e faz as referências direita e esquerda
	 * apontarem entre si.
	*/
	public Deque() {
		esquerda = new CCelulaDup();
		direita = new CCelulaDup();
		esquerda.prox = direita;
		direita.ant = esquerda;
	}
	
	/**
	 * Verifica se a Double-ended-queue está vazia.
	 * @return TRUE se a deque estiver vazia 
	 * e FALSE caso tenha elementos.
	*/
	public boolean isEmpty() {
		return esquerda.prox == direita & direita.ant == esquerda;
	}
		
	/**
	 * Metodo que retorna a quantidade de itens da dequea.
	 * 
	 * @return q - quantidade de itens da deque
	*/
	public int size() {
		return q;
	}
	
	/**
	 * Insere um novo Item no "começo" - lado esquerdo da Deque.
	 * @param item - elemento a ser inserido no começo - esquerda.
	*/
	public void pushLeft(Object item) {
		if (isEmpty())
			esquerda.prox = direita.ant = new CCelulaDup(item, esquerda, direita);
		else
			esquerda.prox = esquerda.prox.ant = new CCelulaDup(item, esquerda, esquerda.prox);
		q++;
	}
	
	/**
	 * Insere um novo Item no "fim" - lado direito da Deque.
	 * @param item - elemento a ser inserido no fim - direita.
	*/
	public void pushRight(Object item) {
		if (isEmpty())
			esquerda.prox = direita.ant = new CCelulaDup(item, esquerda, direita);
		else
			direita.ant = direita.ant.prox = new CCelulaDup(item, direita.ant, direita);
		q++;
	}
	
	/**
	 * Remove o Item no "começo" - lado esquerdo da Deque.
	 * @param item - elemento a ser removido do começo - esquerda.
	*/
	public Object popLeft() {
		if (!isEmpty()) {
			CCelulaDup aux = esquerda.prox;
			esquerda.prox = esquerda.prox.prox;
			esquerda.prox.prox.ant = esquerda.prox;
			q--;
			return aux.item;
		}
		return null;
	}
	
	/**
	 * Remove o Item no "fim" - lado direito da Deque.
	 * @param item - elemento a ser removido do fim - direita.
	*/
	public Object popRight() {
		if (!isEmpty()) {
			CCelulaDup aux = direita.ant;
			direita.ant.ant.prox = direita;
			direita.ant = direita.ant.ant;
			q--;
			return aux.item;
		}
		return null;
	}
	
	
	/**
	 * Imprime Deque.
	*/
	public void imprimeFormatoLista(String titulo) {
		System.out.println(titulo);
		System.out.print("[esq]<->");
		for (CCelulaDup aux = esquerda.prox; aux != null && aux != direita; aux = aux.prox)
			System.out.print("[" + aux.item + "]<->");
		System.out.println("[dir]");
	}

}