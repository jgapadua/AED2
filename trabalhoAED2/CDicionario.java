public class CDicionario {
	private CCelulaDicionario primeira, ultima;
	
	/**
	 * Função Construtora.
	 * Aloca a célçula cabeça e aponta as referências à ela.
	*/
	public CDicionario() {
		primeira = ultima =new CCelulaDicionario();
	}
	
	/**
	 * Método que verifica se o dicionário está vazio.
	 * @return true - caso dicionário vazio.
	 * @return false - se contem elementos.
	*/
	public boolean vazio() {
		return primeira == ultima;
	}
	
	/**
	 * Método que adiciona o par chave/valor
	 * na última posição do dicionário.
	 * Não permite chaves duplicadas.
	 * @param chave e valor a serem adicionados.
	*/
	public void adiciona(Object chave, Object valor) {
		boolean existe= false;
		for (CCelulaDicionario aux = primeira.prox; aux != null && !existe; aux = aux.prox)
			existe = chave.equals(aux.key);
		if(!existe) {
			ultima.prox = new CCelulaDicionario(chave, valor);
			ultima = ultima.prox;
		}
	}
	
	/**
	 * Método que retorna o valor associado a chave.
	 * @param chave a ser pesquisada.
	 * @return valor associado.
	 * Caso não exista, retorna null;
	*/
	public Object recebeValor(Object chave) {
		for (CCelulaDicionario aux = primeira.prox; aux != null; aux = aux.prox)
			if(chave.equals(aux.key))
				return aux.value;
		return null;
	}
	
	/**
	 * Método que imprimir dicionário.
	*/
	public void imprimeFormatoDicio(String titulo) {
		System.out.println(titulo);
		for (CCelulaDicionario aux = primeira.prox; aux != null; aux = aux.prox)
			System.out.println("[" + aux.key + "]->[" + aux.value + "]");
	}
	
	/**
	 * Método que imprimir Codão exercício 30.
	*/
	public void imprimeFormatoCodao(String titulo) {
		System.out.println(titulo);
		int i = 1;
		int line = 1;
		for (CCelulaDicionario aux = primeira.prox; aux != null; aux = aux.prox, i++) {
			if(line == 4 || line ==5 || line == 15)
				System.out.print("[" + aux.key + "]->[" + aux.value + "] \t");
			else if(line == 12)
					System.out.print("[" + aux.key + "]->[" + aux.value + "]");
			else
				System.out.print("[" + aux.key + "]->[" + aux.value + "]\t");
			if(i%4==0) {
				System.out.print("\n");
				line++;
			}
			if(i==43)
				System.out.print("\t");
		}
	}
}