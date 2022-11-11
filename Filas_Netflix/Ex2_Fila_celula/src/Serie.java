import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Celula {

	private Serie item;
	private Celula proximo;
	
	public Celula(Serie item) {
		
		this.item = item;
		this.proximo = null;
	}
	
	public Celula() {
	
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

class Fila {

	private Celula frente;
	private Celula tras;
	
	public Fila() {
		
		Celula sentinela;
		
		sentinela = new Celula();
		frente = sentinela;
		tras = sentinela;
	}
	
	public boolean filaVazia() {
		
		if (frente == tras)
			return true;
		else
			return false;
	}
	
	public void enfileirar(Serie novo) {
		
		Celula novaCelula;
		
		novaCelula = new Celula(novo);
		tras.setProximo(novaCelula);
		tras = novaCelula;
		
		MyIO.println((int)obterMediaTemporadas());
		
	}
	
	public Serie desenfileirar() throws Exception{
		
		Celula desenfileirado = null;
		Celula proximaCelula;
		
		if (! filaVazia()) {
			desenfileirado = frente.getProximo();
			proximaCelula = desenfileirado.getProximo();
			frente.setProximo(proximaCelula);
			if (desenfileirado == tras)
				tras = frente;
			return desenfileirado.getItem();
			
		} else
			throw new Exception ("Não foi possível desenfileirar nenhum elemento: a fila está vazia!");
	}
	
	public void mostrar() throws Exception{
		
		Celula aux;
		int posicao = 0;
		
		if (! filaVazia()) {
			aux = frente.getProximo();
			
			while (aux != null) {
				MyIO.print("[" + posicao + "]");
				aux.getItem().imprimir();
				aux = aux.getProximo();
				posicao++;
			}
		} else
			throw new Exception("Não foi possível imprimir o conteúdo da fila: a fila está vazia!");
	}
	
	public double obterMediaTemporadas() {
		double mediaTotal = 0;
		int tamanhoArr = 0;
		
		Celula aux;
		
		if (! filaVazia()) {
			aux = frente.getProximo();
			
			while (aux != null) {
				tamanhoArr++;
				mediaTotal += aux.getItem().getNumeroDeTemporadas();
				aux = aux.getProximo();
				
			}
			mediaTotal = mediaTotal / tamanhoArr;
		}
		
		return Math.round(mediaTotal);
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
		Fila fila = new Fila();
		
		
		
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
					fila.enfileirar((a[i]));
				}
				
			}
			linha = MyIO.readLine();
		}
		
		int numFila = Integer.parseInt(MyIO.readLine());
		
		for(int i = 0; i < numFila; i++) {
			String[] tipoInsersacao = MyIO.readLine().split(" ", 2);
			
			if(tipoInsersacao[0].contains("R")) {
				MyIO.println("(R) " + fila.desenfileirar().getNome());
			} else if(tipoInsersacao[0].contains("I")) {
				for(int j = 0; j < a.length; j++) {
					if(tipoInsersacao[1].contains(a[j].nome)) {
						fila.enfileirar((a[j]));
					}
						
				}
			}
		}
		
		fila.mostrar();
		
	}
}