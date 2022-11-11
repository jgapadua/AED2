import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Celula {

	private Serie item;
	private Celula proximo;
	
	public Celula(Serie novo) {
		item = novo;
		proximo = null;
	}
	
	public Celula() {
		
		item = new Serie();
		proximo = null;
	}
	
	public Serie getItem() {
		return item;
	}
	public void setItem(Serie item) {
		this.item = item;
	}
	
	public Celula getProximo() {
		return proximo;
	}
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
}

class ListaEncadeada {

	private Celula primeiro;
	private Celula ultimo;
	private int tamanho;
	
	public ListaEncadeada() {
		
		Celula sentinela;
		
		sentinela = new Celula();
		primeiro = sentinela;
		ultimo = sentinela;
		tamanho = 0;
	}
	
	public boolean listaVazia() {
	
		if (primeiro == ultimo)
			return true;
		else
			return false;
	}
	
	public void inserir(Serie novo, int posicao) throws Exception {
		
		Celula anterior, novaCelula, proximaCelula;
		
		if ((posicao >= 0) && (posicao <= tamanho)) {
			anterior = primeiro;
			for (int i = 0; i < posicao; i++) 
				anterior = anterior.getProximo();
			
			novaCelula = new Celula(novo);
			
			proximaCelula = anterior.getProximo();
			
			anterior.setProximo(novaCelula);
			novaCelula.setProximo(proximaCelula);
			
			if (posicao == tamanho)
				ultimo = novaCelula;
			
			tamanho++;
			
		} else
			throw new Exception("Não foi possível inserir o item na lista: posição de inserção inválida!");
	}
	
	public void inserirInicio(Serie novo) {
		
		Celula novaCelula;
		
		novaCelula = new Celula(novo);
		
		novaCelula.setProximo(primeiro);
		
		primeiro = novaCelula;
		
		tamanho++;
		
	}
	
	public void inserirFim(Serie novo) {
		
		Celula novaCelula;
		
		novaCelula = new Celula(novo);
		
		
		ultimo.setProximo(novaCelula);
		
		ultimo = novaCelula;
		
		tamanho++;
		
	}
	
	public Serie remover(int posicao) throws Exception{
	
		Celula anterior;
		Celula removida, proximaCelula;
		
		if (! listaVazia()) {
			if ((posicao >= 0) && (posicao < tamanho)) {
				anterior = primeiro;
				for (int i = 0; i < posicao; i++)
					anterior = anterior.getProximo();
					
				removida = anterior.getProximo();
				
				proximaCelula = removida.getProximo();
				
				anterior.setProximo(proximaCelula);
				
				if (removida == ultimo)
					ultimo = anterior;
				
				tamanho--;
				
				return (removida.getItem());
				
			} else
				throw new Exception("Não foi possível remover o item da lista: posição de remoção inválida!");
		} else
			throw new Exception("Não foi possível remover o item da lista: a lista está vazia!");
	}
	
	public Serie removerInicio(){
		Celula removida, proxima;
	    if(! listaVazia()){
	    	removida = primeiro;
	    	proxima = primeiro.getProximo();
	        primeiro = proxima;
	        tamanho--;
	        return (removida.getItem());
	    } else
	    	return null;
	    
	}
	
	public Serie removerFim()  {
		
		Celula removida, aux, anterior;
		
		aux = primeiro;
		anterior = primeiro;
		
		if (! listaVazia()) {
			
			while(aux.getProximo() != null) {
				anterior = aux;
				aux = aux.getProximo();
			}
			anterior.setProximo(null);
			ultimo = anterior;
			
			removida = ultimo;
			
			tamanho--;
			
			return (removida.getItem());
		} 
		else
			return null;
	}
	
	public void mostrar() throws Exception {
		
		if (! listaVazia()) {
			
			Celula aux;
			int count = 0;
			aux = primeiro.getProximo();
			while (aux != null) {
				MyIO.print("[" + count + "]");
				aux.getItem().imprimir();
				aux = aux.getProximo();
				count++;
			}	
		} else
			throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
	}
}


public class Serie {

	private int numeroDeTemporadas, numeroDeEpisodios;
	private String nome, duracao, formato, paisDeOrigem, idiomaDeOrigem, emissoraDeTelevisaoOriginal, dataDeInicioDaTransmissaoOriginal;
	
	public Serie() {

	}

	public int getNumeroDeTemporadas() {
		return numeroDeTemporadas;
	}

	public void setNumeroDeTemporadas(int numeroDeTemporadas) {
		this.numeroDeTemporadas = numeroDeTemporadas;
	}

	public int getNumeroDeEpisodios() {
		return numeroDeEpisodios;
	}

	public void setNumeroDeEpisodios(int numeroDeEpisodios) {
		this.numeroDeEpisodios = numeroDeEpisodios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}

	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}

	public String getIdiomaDeOrigem() {
		return idiomaDeOrigem;
	}

	public void setIdiomaDeOrigem(String idiomaDeOrigem) {
		this.idiomaDeOrigem = idiomaDeOrigem;
	}

	public String getEmissoraDeTelevisaoOriginal() {
		return emissoraDeTelevisaoOriginal;
	}

	public void setEmissoraDeTelevisaoOriginal(String emissoraDeTelevisaoOriginal) {
		this.emissoraDeTelevisaoOriginal = emissoraDeTelevisaoOriginal;
	}

	public String getDataDeInicioDaTransmissaoOriginal() {
		return dataDeInicioDaTransmissaoOriginal;
	}

	public void setDataDeInicioDaTransmissaoOriginal(String dataDeInicioDaTransmissaoOriginal) {
		this.dataDeInicioDaTransmissaoOriginal = dataDeInicioDaTransmissaoOriginal;
	}

	public Serie(int numeroDeTemporadas, int numeroDeEpisodios, String nome, String formato, String paisDeOrigem,
			String idiomaDeOrigem, String emissoraDeTelevisaoOriginal, String dataDeInicioDaTransmissaoOriginal) {
		super();
		this.numeroDeTemporadas = numeroDeTemporadas;
		this.numeroDeEpisodios = numeroDeEpisodios;
		this.nome = nome;
		this.formato = formato;
		this.paisDeOrigem = paisDeOrigem;
		this.idiomaDeOrigem = idiomaDeOrigem;
		this.emissoraDeTelevisaoOriginal = emissoraDeTelevisaoOriginal;
		this.dataDeInicioDaTransmissaoOriginal = dataDeInicioDaTransmissaoOriginal;
	}

	public static List<String> ler() throws IOException {
		Serie a = new Serie();
     	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/data.txt"), "ISO-8859-1"));
//     	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/data.txt"), "ISO-8859-1"));
        br.readLine();
        String line;
        List<String> list = new ArrayList<String>();
        while ((line = br.readLine()) != null){
        	list.add(line);
        }
        
        return list;
	}
	
	public void imprimir() {
		MyIO.println(nome + " ## " + formato + " ## " + duracao + " ## " + paisDeOrigem + " ## " + idiomaDeOrigem + " ## " 
				+ emissoraDeTelevisaoOriginal + 
				" ## " + dataDeInicioDaTransmissaoOriginal + " ## " + numeroDeTemporadas + " ## " + numeroDeEpisodios);	
	}

	public static void main(String[] args) throws Exception {
		String[] n = ler().stream().toArray(String[]::new);
		Serie[] a = new Serie[n.length];
		String linha = MyIO.readLine();
		ListaEncadeada lista = new ListaEncadeada();
		
		
		
		for(int i = 0; i < n.length; i++) {
			 a[i] = new Serie();
			 String[] r = n[i].split(";");
			 a[i].setNome(r[0]);
             a[i].setFormato(r[1]);
             a[i].setDuracao(r[2]);
             a[i].setPaisDeOrigem(r[3]);
             a[i].setIdiomaDeOrigem(r[4]);
             a[i].setEmissoraDeTelevisaoOriginal(r[5]);
             a[i].setDataDeInicioDaTransmissaoOriginal(r[6]);
             a[i].setNumeroDeTemporadas(Integer.parseInt(r[7]));
             a[i].setNumeroDeEpisodios(Integer.parseInt(r[8]));
				
		}
		
		while(!linha.equals("FIM")) {
			for(int i = 0; i < a.length; i++) {
				if(linha.equals(a[i].nome)) {
					lista.inserirFim((a[i]));
				}
				
			}
			linha = MyIO.readLine();
		}
		
		int numFila = Integer.parseInt(MyIO.readLine());
		
		for(int i = 0; i < numFila; i++) {
			String tipoInsersacao = MyIO.readLine();
			
			if(tipoInsersacao.contains("II")) {
				String[] linhaInsersacao = tipoInsersacao.split(" ", 2);
				 for(int j = 0; j < a.length; j++) {
						if(linhaInsersacao[1].contains(a[j].nome)){
							lista.inserirInicio(a[j]);
							break;
						}
					}
			 } else if(tipoInsersacao.contains("I*")) {
				 String[] linhaInsersacao = tipoInsersacao.split(" ", 3);
				 for(int j = 0; j < a.length; j++) {
						if(linhaInsersacao[2].contains(a[j].nome)){
							lista.inserir(a[j], Integer.parseInt(linhaInsersacao[1]));
							break;
						}
					}
			 } else if(tipoInsersacao.contains("IF")) {
				 String[] linhaInsersacao = tipoInsersacao.split(" ", 2);
				 for(int j = 0; j < a.length; j++) {
						if(linhaInsersacao[1].contains(a[j].nome)){
							lista.inserirFim(a[j]);
							break;
						}
					}
			 } else if(tipoInsersacao.contains("RI")) {
				 MyIO.println("(R) " + lista.removerInicio().getNome());
			 } else if(tipoInsersacao.contains("R*")) {
				 String[] linhaInsersacao = tipoInsersacao.split(" ");
				 MyIO.println("(R) " + lista.remover(Integer.parseInt(linhaInsersacao[1])).getNome());
						
			 } else if(tipoInsersacao.contains("RF")) {
				 MyIO.println("(R) " + lista.removerFim().getNome());
			 }
		}
		
		lista.mostrar();
		
	}
}