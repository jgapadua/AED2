public class Aplicacao{
	public static void main(String[] args) throws Exception{
		Jogo[] vetor = Jogo.lerArquivo();
		String[] vetorPesquisa = Jogo.ler(vetor);
		Jogo[] vetorPesquisado= Jogo.fazerPesquisa(vetorPesquisa, vetor);

		Fila fila = new Fila();
		for(Jogo partida : vetorPesquisado) {
			fila.enfileirar(partida);
		}

/* 		// Lendo a segunda parte da entrada padrao
		int quantidade = MyIO.readInt();
		String linha; */

		fila.mostrar();
}
}
class Jogo{
  //declaração dos atributos
private int dia;
private int mes;
private int ano;
private int placarSelecao1;
private int placarSelecao2;
private String etapa;
private String selecao1;
private String selecao2;
private String local;

//construtor primário
public Jogo(){}

//construtor secundário
public Jogo(String str){
  String[] stringArray = str.split("#");
  this.ano=Integer.parseInt(stringArray[0]);
  this.etapa=stringArray[1];
  this.dia=Integer.parseInt(stringArray[2]);
  this.mes=Integer.parseInt(stringArray[3]);
  this.selecao1=stringArray[4];
  this.placarSelecao1=Integer.parseInt(stringArray[5]);
  this.placarSelecao2=Integer.parseInt(stringArray[6]);
  this.selecao2=stringArray[7];
  this.local=stringArray[8];
  }


//métodos para setar e retornar os atributo
public void setDia(int dia) {
this.dia = dia;
}
public int getDia() {
return dia;
}
public void setMes(int mes) {
this.mes = mes;
}
public int getMes() {
return mes;
}
public void setAno(int ano) {
this.ano = ano;
}
public int getAno() {
return ano;
}
public void setEtapa(String etapa) {
this.etapa = etapa;
}
public String getEtapa() {
return etapa;
}
public void setSelecao1(String selecao1) {
this.selecao1 = selecao1;
}
public String getSelecao1() {
return selecao1;
}
public void setSelecao2(String selecao2) {
this.selecao2 = selecao2;
}
public String getSelecao2() {
return selecao2;
}
public void setPlacarSelecao1(int placarSelecao1) {
this.placarSelecao1 = placarSelecao1;
}
public int getPlacarSelecao1() {
return placarSelecao1;
}
public void setPlacarSelecao2(int placarSelecao2) {
this.placarSelecao2 = placarSelecao2;
}
public int getPlacarSelecao2() {
return placarSelecao2;
}
public void setLocal(String local) {
this.local = local;
}
public String getLocal() {
return local;
}

//método para clonar a classe
public Jogo clone(){
Jogo cloneJogo = new Jogo();
cloneJogo.dia = this.dia;
cloneJogo.mes = this.mes;
cloneJogo.ano = this.ano;
cloneJogo.placarSelecao1 = this.placarSelecao1;
cloneJogo.placarSelecao2 = this.placarSelecao2;
cloneJogo.etapa = this.etapa;
cloneJogo.selecao1 = this.selecao1;
cloneJogo.selecao2 = this.selecao2;
cloneJogo.local = this.local;
return cloneJogo;
}

// método para ler arquivo
public  static Jogo[] lerArquivo() {
String nomeArquivo="tmp/partidas.txt";
ArquivoTextoLeitura arquivoLeitura = new ArquivoTextoLeitura(nomeArquivo);
ArquivoTextoLeitura contarLinhas = new ArquivoTextoLeitura(nomeArquivo);

int quantidade = 0;

String linhaContar = contarLinhas.ler();
while(linhaContar != null) {
  quantidade++;
  linhaContar = contarLinhas.ler();
}
contarLinhas.fecharArquivo();

// Preenchendo um vetor de objetos com os dados do arquivo
Jogo[] vetor = new Jogo[quantidade];
int i = 0;
String str = arquivoLeitura.ler();
while (str != null) {
  vetor[i++] = new Jogo(str);
  str = arquivoLeitura.ler();
}
arquivoLeitura.fecharArquivo();
return vetor;
}

public static String[] ler(Jogo[] vetor) {
  // Lendo a entrada padrao
  int quantidade =  vetor.length;
  String[] dadosPesquisa = new String[quantidade];
  String linhaPesquisa=MyIO.readLine();
  
	while(!linhaPesquisa.equals("FIM")){
    for(int j = 0; j < quantidade; j++) {
      linhaPesquisa = MyIO.readLine();
      dadosPesquisa[j] = linhaPesquisa;
    }
  }
  return dadosPesquisa;
  }

//método fazer pesquisa de jogos
public static Jogo[] fazerPesquisa(String[] vetorPesquisa, Jogo[] vetor) {
int a = 0;
String[] dadosPesquisa;
Jogo[] vetorPesquisado = new Jogo[vetorPesquisa.length];
int quantidade = vetorPesquisa.length;

while(a < quantidade) {
  dadosPesquisa = vetorPesquisa[a].split(";");

  String data = dadosPesquisa[0];
  String selecao1 = dadosPesquisa[1];
  int dia = Integer.parseInt(data.split("/")[0]);
  int mes = Integer.parseInt(data.split("/")[1]);
  int ano = Integer.parseInt(data.split("/")[2]);

  for(int j = 0; j < vetor.length; j++) {
    if(vetor[j].getDia() == dia && vetor[j].getMes() == mes && vetor[j].getAno() == ano && vetor[j].getSelecao1().equals(selecao1)) 
    {
      vetorPesquisado[a]=vetor[j];
    }
  }
  a++;
}
return vetorPesquisado;
}

//método imprimir
public void imprimir() {
MyIO.println("[COPA " + this.ano + "] [" + this.etapa + "] [" + this.dia + "/" + this.mes + "] ["+ this.selecao1 + " (" + this.placarSelecao1 + ") x (" + this.placarSelecao2 + ") " + this.selecao2 + "] [" + this.local + "]");
}

}
class Celula {

	private Jogo item;
	private Celula proximo;
	
	public Celula(Jogo item) {
		
		this.item = item;
		this.proximo = null;
	}
	
	public Celula() {
	
		this.item = new Jogo();
		this.proximo = null;
	}
	
	public Jogo getItem() {
		return item;
	}
	
	public void setItem(Jogo item) {
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
	
	public void enfileirar(Jogo novo) {
		
		Celula novaCelula;
		
		novaCelula = new Celula(novo);
		tras.setProximo(novaCelula);
		tras = novaCelula;
		
		MyIO.println((int)obterMediaGols());
		
	}
	
	public Jogo desenfileirar() throws Exception{
		
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
	
	public double obterMediaGols() {
		double mediaTotal = 0;
		int tamanhoArr = 0;
		int totalGols = 0;
		Celula aux;
		
		if (! filaVazia()) {
			aux = frente.getProximo();
			
			while (aux != null) {
				totalGols += aux.getItem().getPlacarSelecao1() + aux.getItem().getPlacarSelecao2();
				aux = aux.getProximo();
				tamanhoArr++;
			}
			mediaTotal = totalGols / tamanhoArr;
		}
		return Math.round(mediaTotal);
	}
}



