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
		} catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
		}
	}

	@SuppressWarnings("finally")
	public String ler() {

		String textoEntrada = null;

		try {
			textoEntrada = entrada.readLine();
		} catch (EOFException excecao) { // Excecao de final de arquivo.
			textoEntrada = null;
		} catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		} finally {
			return textoEntrada;
		}
	}
}

class Fila {

	private Jogo[] fila;
	private int frente;
	private int tras;
	private int tamanho;
	
	public Fila(int tamanho) {
		
		fila = new Jogo[tamanho];
		frente = 0;
		tras = 0;
		this.tamanho = tamanho;
	}
	
	public Fila() {
		
		fila = new Jogo[101];
		frente = 0;
		tras = 0;
		this.tamanho = 101;
	}
	
	public boolean filaVazia() {
	
		boolean resp;
		
		if (frente == tras)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public boolean filaCheia() {
	
		boolean resp;
		
		if (((tras + 1) % tamanho) == (frente % tamanho))
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public void enfileirar(Jogo novo) throws Exception{
		
		int posicao;
		
		if (!filaCheia()) {
			posicao = tras % tamanho;
			fila[posicao] = novo;
			tras++;
			MyIO.println((int)obterMediaGols());
		} else {
			desenfileirar();
			enfileirar(novo);
		}

	}
	
	public Jogo desenfileirar() throws Exception{
		
		Jogo desenfileirado;
		int posicao;
		
		if (!filaVazia()) {
			posicao = frente % tamanho;
			desenfileirado = fila[posicao];
			frente++;
			return desenfileirado;
		} else
			throw new Exception("Não foi possível desenfileirar nenhum elemento: a fila está vazia!");
	}
	public void mostrar(Jogo desenfileirado) {

		System.out.print("(D) ");
		desenfileirado.imprimir();

	}
	
	public void mostrarJogos() throws Exception{
		
		int posicao;
		int sequencia = 0;
		if (!filaVazia()) {
			for (int i = frente; i < tras; i++) {
				posicao = i % tamanho;
				System.out.print("[" + sequencia + "]");
				fila[posicao].imprimir();
				sequencia++;
			}
		} else
			throw new Exception ("Não foi possível mostrar o conteúdo da fila: a fila está vazia!");
	}
	
	public double obterMediaGols() {
		double mediaTotal = 0;
		int posicao;
		int tamanhoArr = 0;
		
		if (!filaVazia()) {
			for (int i = frente; i < tras; i++) {
				tamanhoArr++;
				posicao = i % tamanho;
				mediaTotal += fila[posicao].getPlacarSelecao1() + fila[posicao].getPlacarSelecao2();
			}
			mediaTotal = mediaTotal / tamanhoArr;
		}
		return Math.round(mediaTotal);
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

//método imprimir
public void imprimir() {
	System.out.println("[COPA " + this.ano + "] [" + this.etapa + "] [" + this.dia + "/" + this.mes + "] ["+ this.selecao1 + " (" + this.placarSelecao1 + ") x (" + this.placarSelecao2 + ") " + this.selecao2 + "] [" + this.local + "]");
	}
	}
public class Aplicacao{
	// método para ler arquivo
	public  static void lerArquivo(Jogo[] vetor) {
/* 		String nomeArquivo="src/partidas.txt"; */
	 String nomeArquivo="/tmp/partidas.txt";
	 ArquivoTextoLeitura arquivoLeitura = new ArquivoTextoLeitura(nomeArquivo);

	 // Preenchendo um vetor de objetos com os dados do arquivo
	 int i = 0;
	 String str = arquivoLeitura.ler();
	 while (str != null) {
		 vetor[i++] = new Jogo(str);
		 str = arquivoLeitura.ler();
	 }
	 arquivoLeitura.fecharArquivo();
	 }
	public static void main(String[] args) throws Exception {
		MyIO.setCharset("UTF-8");
		int tamanho=900;
		Jogo vetor[] = new Jogo[tamanho];
		lerArquivo(vetor);
		Jogo desenfileirado = new Jogo();
		String pesquisa = MyIO.readLine();
		Fila fila = new Fila();
		
		while(!pesquisa.equals("FIM")) {
			String data = pesquisa.split(";")[0];
			String selecao1 = pesquisa.split(";")[1];
			int dia = Integer.parseInt(data.split("/")[0]);
			int mes = Integer.parseInt(data.split("/")[1]);
			int ano = Integer.parseInt(data.split("/")[2]);
			for(int i = 0; i < vetor.length; i++) {
				if(dia == vetor[i].getDia() && mes == vetor[i].getMes() && ano == vetor[i].getAno()
				&& selecao1.equals(vetor[i].getSelecao1())) {
					fila.enfileirar((vetor[i]));
				}
				
			}
			pesquisa = MyIO.readLine();
		}

		int numFila = Integer.parseInt(MyIO.readLine());

		for (int i = 0; i < numFila; i++) {
			String EouD = MyIO.readLine();
			desenfileirado = new Jogo();
			
			if (EouD.equals("D")) {
				desenfileirado = fila.desenfileirar();
				fila.mostrar(desenfileirado);
			}else {
				EouD = EouD.replace("E ", "");
				String date = EouD.split(";")[0];
				String Selecao1 = EouD.split(";")[1];
				int day = Integer.parseInt(date.split("/")[0]);
				int month = Integer.parseInt(date.split("/")[1]);
				int year = Integer.parseInt(date.split("/")[2]);

				for (int z = 0; z < vetor.length; z++) {
					if (day == vetor[z].getDia() && month == vetor[z].getMes()
							&& year == vetor[z].getAno() && Selecao1.equals(vetor[z].getSelecao1())) {
						desenfileirado = vetor[z];
						fila.enfileirar(desenfileirado);
					}
				}
			}
		}
		fila.mostrarJogos();
	}
}
