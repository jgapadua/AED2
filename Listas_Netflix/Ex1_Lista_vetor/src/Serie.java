import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Lista {

	private Serie lista[];
	private int primeiro;
	private int ultimo;
	private int tamanho;
	
	public Lista(int M) {
		
		lista = new Serie[M];
		tamanho = 0;
		primeiro = 0;
		ultimo = 0;
	}
	
	public Lista() {
		
	}
	
	public boolean listaVazia() {
		
		boolean resp;
		
		if (primeiro == ultimo)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public boolean listaCheia() {
		
		boolean resp;
		
		if (ultimo == lista.length) 
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public void inserirInicio(Serie novo) throws Exception {

		int index = primeiro;

		if (!listaCheia()) {
			for (int i = ultimo; i > index; i--)
				lista[i] = lista[i - 1];

			lista[index] = novo;

			ultimo++;
			tamanho++;
		} else
			throw new Exception("Nao foi possivel inserir o item na lista: lista cheia!");

	}
	
	public void inserir(Serie novo, int posicao) throws Exception {
		
		if (! listaCheia()) {
			if ((posicao >= 0) && (posicao <= tamanho)) {
				for (int i = ultimo; i > posicao; i--)
					lista[i] = lista[i-1];
				
				lista[posicao] = novo;
				
				ultimo++;
				tamanho++;
			} else
				throw new Exception("Não foi possível inserir o item na lista: posição informada é inválida!");
		} else
			throw new Exception("Não foi possível inserir o item na lista: a lista está cheia!");
	}
	
	public void inserirFim(Serie novo) throws Exception {

		int index = ultimo;

		if (! listaCheia()) {
			for (int i = ultimo; i > index; i--)
				lista[i] = lista[i - 1];

			lista[index] = novo;

			ultimo++;
			tamanho++;

		} else
			throw new Exception("Nao foi possivel inserir o item na lista: a lista está cheia!");

	}
	
	public Serie remover(int posicao) throws Exception {
		
		Serie removido;
		
		if (! listaVazia()) {
			if ((posicao >= 0) && (posicao < tamanho)) {
				
				removido = lista[posicao];
				tamanho--;
				
				for (int i = posicao; i < tamanho; i++) {
					lista[i] = lista[i+1];
				}
				
				ultimo--;
				
				return removido;
			} else
				throw new Exception("Não foi possível remover o item da lista: posição informada é inválida!");
		} else
			throw new Exception("Não foi possível remover o item da lista: a lista está vazia!");
	}
	
public Serie removerInicio() throws Exception {
		
		Serie removido;
		
		if (! listaVazia()) {
				
				removido = lista[0];
				tamanho--;
				
				for (int i = 0; i < tamanho; i++) {
					lista[i] = lista[i+1];
				}
				
				ultimo--;
				
				return removido;
			} else
			throw new Exception("Não foi possível remover o item da lista: a lista está vazia!");
	}


public Serie removerFim() throws Exception {
	
	Serie removido;
	
	if (! listaVazia()) {
			
			removido = lista[tamanho - 1];
			tamanho--;
			
			for (int i = lista.length - 1; i < tamanho; i++) {
				lista[i] = lista[i-1];
			}
			
			ultimo--;
			
		   return removido;
		   
		} else
		throw new Exception("Não foi possível remover o item da lista: a lista está vazia!");
}
	
	public void mostrar() throws Exception {
		
		if (! listaVazia()) {
			
			for (int i = primeiro; i < ultimo; i++) {
				MyIO.print("[" + i + "]");
				lista[i].imprimir();
			}
		} else
			throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
	}

	
	public void imprimir() throws Exception {
		
		if (! listaVazia()) {
			
			for (int i = primeiro; i < ultimo; i++) {
				System.out.print("Posição: " + i + ": ");
				lista[i].imprimir();
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
		Lista lista = new Lista(50);
		
		
		
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