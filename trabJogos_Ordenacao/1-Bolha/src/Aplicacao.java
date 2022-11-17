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

class ArquivoTextoEscrita {

	private BufferedWriter saida;
		
	ArquivoTextoEscrita(String nomeArquivo) {	
		
		try {
			saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nomeArquivo), "UTF-8"));
		} catch (UnsupportedEncodingException excecao) {
			System.out.println(excecao.getMessage());
		} catch (IOException excecao) {
			System.out.println("Erro na abertura do arquivo de escrita: " + excecao);
		}
	}
	
	public void fecharArquivo() {
		
		try {
			saida.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de escrita: " + excecao);	
		}
	}
	
	public void escrever(String textoEntrada) {
	
		try {
			saida.write(textoEntrada);
			saida.newLine();
		}
		catch (IOException excecao){
			System.out.println("Erro de entrada/saída " + excecao);
		}
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

public class Aplicacao {
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
		static void bubbleSort(Jogo[] vetor, int n) throws IOException
			 {
				 int comp = 0;
				 int mov = 0;
				 long start = System.currentTimeMillis();
					 for (int i  = (n - 1); i > 0; i--) {
							 for (int j = 0; j < i; j++) {
								 comp++;
								 if (vetor[j].getDia() > vetor[j + 1].getDia()) {			
									 Jogo temp = vetor[j];
									 vetor[j] = vetor[j+1];
									 vetor[j+1] = temp;  
									 mov++;    				
						 }
						 else if(vetor[j].getDia() == vetor[j + 1].getDia()) {
							 if (vetor[j].getMes() > vetor[j+1].getMes()) {
							 
									 Jogo temp = vetor[j];
										 vetor[j] = vetor[j+1];
										 vetor[j+1] = temp;
										 mov++;
						 }}
						 else if(vetor[j].getMes() == vetor[j+1].getMes()) {
							 
							 if(vetor[j].getAno() > vetor[j+1].getAno()) {
							 
							 Jogo temp = vetor[j];
									 vetor[j] = vetor[j+1];
									 vetor[j+1] = temp;
									 mov++;
						 }}
						 
						 else if(vetor[j].getAno() == vetor[j+1].getAno()) {
							 
							 if(vetor[j].getSelecao1().compareTo(vetor[j+1].getSelecao1())>0)  {
							 
							 Jogo temp = vetor[j];
									 vetor[j] = vetor[j+1];
									 vetor[j+1] = temp;
									 mov++;
								 }}
							 }
									 
							 }
					 
					 long time = System.currentTimeMillis() - start;
					 String nomeArquivoBolha = "730216_bolha.txt";
					 ArquivoTextoEscrita arquivoEscritaBolha= new ArquivoTextoEscrita(nomeArquivoBolha);
					 arquivoEscritaBolha.escrever("730216" + "\t" + time + "\t" + comp + "\t" + mov);
					 arquivoEscritaBolha.fecharArquivo();
				 }
		static void printArray(Jogo arr[])
			 {
					 int n = arr.length;
					 for (int i=0; i<n; i++)
							 arr[i].imprimir();
			 }
	public static void main(String[] args) throws Exception {
		MyIO.setCharset("UTF-8");
		int tamanho=900;
		Jogo vetor[] = new Jogo[tamanho];
		lerArquivo(vetor);
// Lendo a primeira parte da entrada padrao
String s = MyIO.readLine();
int quantidade = Integer.parseInt(s);
Jogo pesquisa[] = new Jogo[quantidade];
for (int a = 0; a < quantidade; a++) {
	s = MyIO.readLine();
	String data = s.split(";")[0];
	String selecao1 = s.split(";")[1];
	int dia = Integer.parseInt(data.split("/")[0]);
	int mes = Integer.parseInt(data.split("/")[1]);
	int ano = Integer.parseInt(data.split("/")[2]);

	for (int j = 0; j < vetor.length; j++) {
		if (vetor[j].getDia() == dia && vetor[j].getMes() == mes && vetor[j].getAno() == ano && vetor[j].getSelecao1().equals(selecao1)) {
			pesquisa[a] = vetor[j].clone();
			break;
		}
	}
}
bubbleSort(pesquisa,quantidade);
printArray(pesquisa);
}
}