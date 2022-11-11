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

class Pilha {

	private Serie pilha[];
	private int topo;

	public Pilha(int tamanho) {

		pilha = new Serie[tamanho];
		topo = 0;
	}
	public Pilha() {

		pilha = new Serie[61];
		topo = 0;
	}

	public boolean pilhaCheia() {

		boolean resp;

		if (topo == pilha.length)
			resp = true;
		else
			resp = false;

		return resp;
	}

	public boolean pilhaVazia() {

		boolean resp;

		if (topo == 0)
			resp = true;
		else
			resp = false;

		return resp;
	}

	public Serie desempilhar() throws Exception {

		Serie desempilhado;

		if (!pilhaVazia()) {
			topo--;
			desempilhado = pilha[topo];
			return desempilhado;
		} else
			throw new Exception("Não foi possível desempilhar: a pilha está vazia!");
	}

	public void empilhar(Serie novo) throws Exception {

		if (!pilhaCheia()) {
			pilha[topo] = novo;
			topo++;
		} else
			throw new Exception("Não foi possível empilhar: a pilha está cheia!");
	}

	public Serie consultarTopo() throws Exception {

		if (!pilhaVazia()) {
			return (pilha[topo - 1]);
		} else
			throw new Exception("Não foi possível consultar o elemento do topo da pilha: a pilha está vazia!");
	}
	
	public void mostrar(Serie desempilhado) {

		System.out.print("(D) ");
		desempilhado.imprimir();

	}
	 public void mostrarSeries() {
	        int cont = 0;

	        for(int i = 0; i < topo; i++) {
	            System.out.print("[" +  cont + "] ");
	            pilha[i].imprimir();
	            cont++;
	        }
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
		Serie desempilhado = new Serie();
		Pilha pilha = new Pilha();
		
		for (int a = 0; a < 601; a++) {
			String nomeSerie = MyIO.readLine();
		if (nomeSerie.equals("FIM")) {
			break;
		}
			nomeSerie = MyIO.readLine();
			for(int i = 0; i < vetor.length; i++) {
				if(vetor[i].getNome().equals(nomeSerie)) {
					desempilhado = vetor[i];
					pilha.empilhar(desempilhado);
				}
			}
		}
		
	//System.out.println("qntd");

	int qntd = MyIO.readInt();
	//System.out.println(qntd);

	for (int j = 0; j < qntd; j++) {
		//System.out.println("EouD");
		String EouD = MyIO.readLine();
		desempilhado = new Serie();

		if (EouD.equals("D")) {
			desempilhado = pilha.desempilhar();
			pilha.mostrar(desempilhado);
		}
		else {
			EouD = EouD.replace("E ", "");
			String nameSerie = EouD.split(";")[0];
			for (int z = 0; z < vetor.length; z++) {
				if (vetor[z].getNome().equals(nameSerie)) {
					desempilhado = vetor[z];
					pilha.empilhar(desempilhado);
				}
			}
		}
	}
	pilha.mostrarSeries();

}
}