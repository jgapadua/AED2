import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

class Celula {
	
	private Serie item;
	private Celula proximo;
	
	Celula(Serie item) {
		this.item = item;
		this.proximo = null;
	}
	
	Celula() {
		this.item = new Serie();
		this.proximo = null;
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
	
	ListaEncadeada() {
	
		Celula sentinela;
		
		sentinela = new Celula();
		primeiro = sentinela;
		ultimo = sentinela;
		tamanho = 0;
	}
	
	public boolean listaVazia() {
		
		boolean resp;
		
		if (primeiro == ultimo)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public void inserir (Serie item, int posicao) throws Exception {
		
		Celula aux;
		Celula nova;
		Celula proxima;
		int i;
		
		if ((posicao >= 0) && (posicao <= tamanho)) {
			for (i = 0, aux = primeiro; i < posicao; i++)
				aux = aux.getProximo();
				
			nova = new Celula(item);
			
			proxima = aux.getProximo();
			aux.setProximo(nova);
			nova.setProximo(proxima);
				
			if (posicao == tamanho)
				ultimo = nova;
				
			tamanho++;
		} else
			throw new Exception ("Não foi possível inserir o item na lista: posição inválida!");
	}
	
	public Serie retirar (int posicao) throws Exception {
		
		Celula aux;
		Celula retirada;
		Celula proxima;
		Serie item = null;
		
		int i;
		
		if (! listaVazia() ) {
			if ((posicao >= 0) && (posicao < tamanho)) {
				for (i = 0, aux = primeiro; i < posicao; i++)
					aux = aux.getProximo();
				
				retirada = aux.getProximo();
				
				proxima = retirada.getProximo();
				
				aux.setProximo(proxima);
				
				if (ultimo == retirada)
					ultimo = aux;
				
				tamanho--;
				
				item = retirada.getItem();
				
			} else
				throw new Exception ("Não foi possível retirar o item da lista: posição inválida!");
		} else
			throw new Exception ("Não foi possível retirar o item da lista: a lista está vazia!");
	
		return item;
	}
	
	public Serie pesquisar(String dado) {
	    
    	Celula aux;
    	
    	aux = primeiro.getProximo();
    	
    	while (aux != null) {
    		if (aux.getItem().getNome().compareTo(dado) == 0) {
    			return aux.getItem();
    		}
    		aux = aux.getProximo();
    	}
    	return null;
    }
	
	public void imprimir() throws Exception {
		
		Celula aux;
		
		if (! listaVazia() ) {
			aux = primeiro.getProximo();
			while (aux != null) {
				aux.getItem().imprimir();
				aux = aux.getProximo();
			}
		} else
			throw new Exception ("A lista está vazia!");
	}
}

class TabelaHash {

	private int M;
	private ListaEncadeada tabelaHash[];
	public int count = 0;
	
	public TabelaHash(int tamanho) {
		
		this.M = tamanho;
		
		tabelaHash = new ListaEncadeada[this.M];
		for (int i = 0; i < M; i++)
			tabelaHash[i] = new ListaEncadeada();
	}
	
	private int funcaoHash(String chave) {
		
		int valueAsc = 0;
		
		for(int j = 0; j < chave.trim().getBytes(StandardCharsets.US_ASCII).length; j++) {
			valueAsc += chave.getBytes(StandardCharsets.US_ASCII)[j];
		}
		
		return ((valueAsc) % this.M);
	}
	
	public void inserir(Serie novo) throws Exception {
		
		int posicao;
		
		posicao = funcaoHash(novo.getNome());
		
		if (tabelaHash[posicao].pesquisar(novo.getNome()) == null)
			tabelaHash[posicao].inserir(novo, 0);
		else
			throw new Exception("Não foi possível inserir o novo elemento na tabela hash: o elemento já havia sido inserido anteriormente!");
	}
	
	public Serie pesquisar(String chave) {
		
		int posicao;
		
		posicao = funcaoHash(chave);
		
		
		if(tabelaHash[posicao].pesquisar(chave) != null) {
			count++;
			MyIO.print(posicao + " SIM" + "\n");
			return tabelaHash[posicao].pesquisar(chave);
		} else {
			count++;
			MyIO.print("NAO" + "\n");
			return tabelaHash[posicao].pesquisar(chave);
		}
		
		
	}
	
	public void imprimir() {
		for (int i = 0; i < M; i++) {
			System.out.print(i);
			try {
				tabelaHash[i].imprimir();
			} catch (Exception erro) {
				System.out.println(erro.getMessage());
			}
		}
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
		Serie pesquisado;
		
		TabelaHash T;
		
		T = new TabelaHash(31);
		
		long time;
		
		long start = System.currentTimeMillis();
		
		
		
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
		
		 while(! linha.equals("FIM")) {
				for(int i = 0; i < a.length; i++) {
					String roomId = a[i].getNome();
					if(linha.equals(roomId)){
						T.inserir(a[i]);
						break;
					}
				}
				linha = MyIO.readLine();
			} 
//			T.imprimir();
			String search = MyIO.readLine();
			while(! search.equals("FIM")) {
				pesquisado = T.pesquisar(search);
				search = MyIO.readLine();
			}
			
			time = System.currentTimeMillis() - start;
			
			new File("matrícula_hashSeparado.txt");
	        PrintWriter writer = new PrintWriter("matrícula_hashSeparado.txt", "UTF-8");
	        writer.print("729961" + "\t" + time + "\t" + T.count);
	        writer.close();
		
	}
}