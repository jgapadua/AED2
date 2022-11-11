import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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

class Jogo {
	//declaração dos atributos
	private int dia, mes, ano, placarSelecao1, placarSelecao2;
	private String etapa, selecao1, selecao2, local;

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
/* 	  String nomeArquivo="src/partidas.txt"; */
		String nomeArquivo="/tmp/partidas.txt";	
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

	// IMPRIMIR
	public void imprimir() {
		System.out.println("[COPA " + this.ano + "] [" + this.etapa + "] [" + this.dia + "/" + this.mes + "] ["
				+ this.selecao1 + " (" + this.placarSelecao1 + ") x (" + this.placarSelecao2 + ") " + this.selecao2
				+ "] [" + this.local + "]");
	}

} 


public class Aplicacao {
		
	
/* 	  public static void bubbleSort(Jogo[] vetorGames,int n) throws IOException{
	  int comp = 0;
	  int mov = 0;
	  long start = System.currentTimeMillis();
	  
	  for (int i = (n - 1); i > 0; i--) { 
		  for (int j = 0; j < i; j++) { 
			  comp++; 
			  if(vetorGames[j].getDia() > vetorGames[j + 1].getDia()) {
	  
	  Jogo temp = vetorGames[j];
	  vetorGames[j] = vetorGames[j+1];
	  vetorGames[j+1] = temp; 
	  mov++; 
	  } else if(vetorGames[j].getDia() == vetorGames[j + 1].getDia()){ 
		  if(vetorGames[j].getMes() > vetorGames[j+1].getMes()) {
			  
	  Jogo temp = vetorGames[j];
	  vetorGames[j] = vetorGames[j+1];
	  vetorGames[j+1] =temp;
	  mov++; 
	  } 
	  } else if(vetorGames[j].getMes() == vetorGames[j+1].getMes()){ 
		  if(vetorGames[j].getAno() > vetorGames[j+1].getAno()) {
	  
	  Jogo temp = vetorGames[j];
	  vetorGames[j] = vetorGames[j+1]; 
	  vetorGames[j+1]=temp; 
	  mov++; 
	  } 
		  } else if(vetorGames[j].getAno() == vetorGames[j+1].getAno()){ 
			  if(vetorGames[j].getSelecao1().compareTo(vetorGames[j+1].getSelecao1())>0)
	  {
	  Jogo temp = vetorGames[j];
	  vetorGames[j] = vetorGames[j+1];
	  vetorGames[j+1]=temp;
	  mov++; 
	  } 
		  }
			}
		  }
	  
	  long time = System.currentTimeMillis() - start;
	  
	  File file = new File("matricula_bolha.txt"); 
	  PrintWriter writer = new PrintWriter("matricula_bolha.txt", "UTF-8"); 
	  writer.println("729961" + "\t" +time + "\t" + comp + "\t" + mov);
	  writer.close(); 
	  } */
	 
	  public static void insertionSort(Jogo[] vetorGames,int n)  throws IOException{
			int comp = 0;
			int mov = 0;
			long start = System.currentTimeMillis();
			
			for (int i = 1; i < n; i++) { 
				for (int j = 0; j < i; j++) { 
					comp++; 
					if(vetorGames[j].getAno() > vetorGames[j + 1].getAno()) {
			
			Jogo temp = vetorGames[j];
			vetorGames[j] = vetorGames[j+1];
			vetorGames[j+1] = temp; 
			mov++; 
			} else if(vetorGames[j].getAno() == vetorGames[j + 1].getAno()){ 
				if(vetorGames[j].getMes() > vetorGames[j+1].getMes()) {
					
			Jogo temp = vetorGames[j];
			vetorGames[j] = vetorGames[j+1];
			vetorGames[j+1] =temp;
			mov++; 
			} 
			} else if(vetorGames[j].getMes() == vetorGames[j+1].getMes()){ 
				if(vetorGames[j].getDia() > vetorGames[j+1].getDia()) {
			
			Jogo temp = vetorGames[j];
			vetorGames[j] = vetorGames[j+1]; 
			vetorGames[j+1]=temp; 
			mov++; 
			} 
				} else if(vetorGames[j].getDia() == vetorGames[j+1].getDia()){ 
					if(vetorGames[j].getSelecao1().compareTo(vetorGames[j+1].getSelecao1())>0)
			{
			Jogo temp = vetorGames[j];
			vetorGames[j] = vetorGames[j+1];
			vetorGames[j+1]=temp;
			mov++; 
			} 
				}
				}
				}
			
			long time = System.currentTimeMillis() - start;
			
			File file = new File("matrícula_insercao.txt"); 
			PrintWriter writer = new PrintWriter("matrícula_insercao.txt", "UTF-8"); 
			writer.println("729961" + "\t" +time + "\t" + comp + "\t" + mov);
			writer.close(); 
		}
public static void main(String[] args)  throws IOException {
	  
	MyIO.setCharset("UTF-8");
	//LEITURA JOGOS
	Jogo[] vetor = Jogo.lerArquivo();
	
	//ENTRADA 
	// Lendo a primeira parte da entrada padrao
	int a = 0;
	int qntd = MyIO.readInt();
	String pesquisa = new String();
	while (a < qntd) {
	    pesquisa = MyIO.readLine();
		String data = pesquisa.split(";")[0];
		String selecao1 = pesquisa.split(";")[1];
		int dia = Integer.parseInt(data.split("/")[0]);
		int mes = Integer.parseInt(data.split("/")[1]);
		int ano = Integer.parseInt(data.split("/")[2]);	
		for(int j=0;j<vetor.length;j++) {
			if (vetor[j].getDia() == dia && vetor[j].getMes() == mes && vetor[j].getAno() == ano && vetor[j].getSelecao1().equals(selecao1)) {
				vetor[a] = vetor[j];
	    }
			a++;
			}
	   }
	
		 insertionSort(vetor,qntd);
	 
	for(int i=0;i<qntd;i++) {
		vetor[i].imprimir();
	}
	
}
}