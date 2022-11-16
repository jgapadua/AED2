import java.io.*;

class ArquivoTextoLeitura {

	private BufferedReader entrada;
	
	ArquivoTextoLeitura(String nomeArquivo) {	
		
		try {
			entrada = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo), "UTF-8"));
		} catch (UnsupportedEncodingException excecao) {
			System.out.println(excecao.getMessage());
		} catch (FileNotFoundException excecao) {
			System.out.println("Arquivo nao encontrado");
		}
	}
	
	public void fecharArquivo() {
		
		try {
			entrada.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	
		}
	}
	
	@SuppressWarnings("finally")
	public String ler() {
		
		String textoEntrada = null;
		
		try {
			textoEntrada = entrada.readLine();
		}
		catch (EOFException excecao) { //Excecao de final de arquivo.
			textoEntrada = null;
		}
		catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		}
		finally {
			return textoEntrada;
		}
	}
}
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
		
		if (!filaVazia()) {
			desenfileirado = frente.getProximo();
			proximaCelula = desenfileirado.getProximo();
			frente.setProximo(proximaCelula);
			if (desenfileirado == tras)
				tras = frente;
			return desenfileirado.getItem();
			
		} else
			throw new Exception ("Não foi possível desenfileirar nenhum elemento: a fila está vazia!");
	}

	public void mostrar(Serie desenfileirado) {

		System.out.print("(D) ");
		desenfileirado.imprimir();

	}

	public void mostrarSeries() throws Exception{
		
		Celula aux;
		int posicao = 0;
		
		if (!filaVazia()) {
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
		
		if (!filaVazia()) {
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


class Serie {
	//declaração dos atributos
	private int numeroDeTemporadas, numeroDeEpisodios;
	private String nome, duracao, formato, paisDeOrigem, idiomaDeOrigem, emissoraDeTelevisaoOriginal, dataDeInicioDaTransmissaoOriginal;
	
	//construtor primário
	public Serie() {}

	//construtor secundário
public Serie(String str){
  String[] stringArray = str.split(";");
  this.nome=stringArray[0];
  this.formato=stringArray[1];
	this.duracao=stringArray[2];
	this.paisDeOrigem=stringArray[3];
	this.idiomaDeOrigem=stringArray[4];
	this.emissoraDeTelevisaoOriginal=stringArray[5];
	this.dataDeInicioDaTransmissaoOriginal=stringArray[6];
  this.numeroDeTemporadas=Integer.parseInt(stringArray[7]);
  this.numeroDeEpisodios=Integer.parseInt(stringArray[8]);
}
//métodos para setar e retornar os atributo
	public void setNumeroDeTemporadas(int numeroDeTemporadas) {
	this.numeroDeTemporadas = numeroDeTemporadas;
	}
	public int getNumeroDeTemporadas() {
		return numeroDeTemporadas;
	}
	public void setNumeroDeEpisodios(int numeroDeEpisodios) {
		this.numeroDeEpisodios = numeroDeEpisodios;
	}
	public int getNumeroDeEpisodios() {
		return numeroDeEpisodios;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getFormato() {
		return formato;
	}
	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}
	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}
	public void setIdiomaDeOrigem(String idiomaDeOrigem) {
		this.idiomaDeOrigem = idiomaDeOrigem;
	}
	public String getIdiomaDeOrigem() {
		return idiomaDeOrigem;
	}
	public void setEmissoraDeTelevisaoOriginal(String emissoraDeTelevisaoOriginal) {
		this.emissoraDeTelevisaoOriginal = emissoraDeTelevisaoOriginal;
	}
	public String getEmissoraDeTelevisaoOriginal() {
		return emissoraDeTelevisaoOriginal;
	}
	public void setDataDeInicioDaTransmissaoOriginal(String dataDeInicioDaTransmissaoOriginal) {
		this.dataDeInicioDaTransmissaoOriginal = dataDeInicioDaTransmissaoOriginal;
	}
	public String getDataDeInicioDaTransmissaoOriginal() {
		return dataDeInicioDaTransmissaoOriginal;
	}

//método para clonar a classe
public Serie clone(){
	Serie cloneSerie = new Serie();
	cloneSerie.numeroDeTemporadas = this.numeroDeTemporadas;
	cloneSerie.numeroDeEpisodios = this.numeroDeEpisodios;
	cloneSerie.nome = this.nome;
	cloneSerie.duracao = this.duracao;
	cloneSerie.formato = this.formato;
	cloneSerie.paisDeOrigem = this.paisDeOrigem;
	cloneSerie.idiomaDeOrigem = this.idiomaDeOrigem;
	cloneSerie.emissoraDeTelevisaoOriginal = this.emissoraDeTelevisaoOriginal;
	cloneSerie.dataDeInicioDaTransmissaoOriginal = this.dataDeInicioDaTransmissaoOriginal;
	return cloneSerie;
	}


	// método para ler arquivo
public  static Serie[] lerArquivo() {
		String nomeArquivo="src/data.txt";
/* 		String nomeArquivo="/tmp/data.txt";  */
		ArquivoTextoLeitura arquivoLeitura = new ArquivoTextoLeitura(nomeArquivo);
		
		// Preenchendo um vetor de objetos com os dados do arquivo
		int quantidade = 61;
		Serie[] vetor = new Serie[quantidade];
		int i = 0;
		String str = arquivoLeitura.ler();
		while (str != null) {
			vetor[i++] = new Serie(str);
			str = arquivoLeitura.ler();
		}
		arquivoLeitura.fecharArquivo();
		return vetor;
		}

		//método imprimir
	public void imprimir() {
		System.out.println(" Nome:"+ this.nome + " Formato:" + this.formato + " Duração:" + this.duracao + " Nacionalidade:" + this.paisDeOrigem + " Idioma original:" + this.idiomaDeOrigem + " Emissora:" 
				+ this.emissoraDeTelevisaoOriginal + 
				" Data transmissão:" + this.dataDeInicioDaTransmissaoOriginal + " Temporadas:" + this.numeroDeTemporadas + " Episodios:" + this.numeroDeEpisodios);	
	}
}

	public class Aplicacao{
		public static void main(String[] args) throws Exception {
			MyIO.setCharset("UTF-8");
			Serie[] vetor = Serie.lerArquivo();
			Serie desenfileirado = new Serie();
			String nomeSerie = MyIO.readLine();
			Fila fila = new Fila();
			
			while(!nomeSerie.equals("FIM")) {
				for(int i = 0; i < vetor.length; i++) {
					if(vetor[i].getNome().equals(nomeSerie)) {
						fila.enfileirar((vetor[i]));
					}
					
				}
				nomeSerie = MyIO.readLine();
			}
			
			int numFila = Integer.parseInt(MyIO.readLine());
			
			for(int i = 0; i < numFila; i++) {
				String EouD = MyIO.readLine();
				desenfileirado = new Serie();
	
				if (EouD.equals("D")) {
					desenfileirado = fila.desenfileirar();
					fila.mostrar(desenfileirado);
				}else {
					EouD = EouD.replace("E ", "");
					String nameSerie = EouD.split(";")[0];
					
					for (int z = 0; z < vetor.length; z++) {
						if (vetor[z].getNome().equals(nameSerie)) {
							desenfileirado = vetor[z];
							fila.enfileirar(desenfileirado);
						}
					}
				}
			}
			fila.mostrarSeries();
		}
		}