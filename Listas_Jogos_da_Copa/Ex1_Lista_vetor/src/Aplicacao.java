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
class Lista {

	private Jogo lista[];
	private int primeiro;
	private int ultimo;
	private int tamanho;
	
	public Lista(int M) {
		
		lista = new Jogo[M];
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
	
	public void inserirInicio(Jogo novo) throws Exception {

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
	
	public void inserir(Jogo novo, int posicao) throws Exception {
		
		if (!listaCheia()) {
			if ((posicao >= 0) && (posicao <= tamanho)) {
				for (int i = ultimo; i > posicao; i--)
					lista[i] = lista[i-1];
				
				lista[posicao] = novo;
				
				ultimo++;
				tamanho++;
			} else
				throw new Exception("Nao foi possivel inserir o item na lista: posicao informada � invalida!");
		} else
			throw new Exception("Nao foi possivel inserir o item na lista: a lista esta cheia!");
	}
	
	public void inserirFim(Jogo novo) throws Exception {

		int index = ultimo;

		if (!listaCheia()) {
			for (int i = ultimo; i > index; i--)
				lista[i] = lista[i - 1];

			lista[index] = novo;

			ultimo++;
			tamanho++;

		} else
			throw new Exception("Nao foi possivel inserir o item na lista: a lista esta cheia!");

	}
	
	public Jogo remover(int posicao) throws Exception {
		
		Jogo removido;
		
		if (!listaVazia()) {
			if ((posicao >= 0) && (posicao < tamanho)) {
				
				removido = lista[posicao];
				tamanho--;
				
				for (int i = posicao; i < tamanho; i++) {
					lista[i] = lista[i+1];
				}
				
				ultimo--;
				
				return removido;
			} else
				throw new Exception("Nao foi possivel remover o item da lista: posicao informada � invalida!");
		} else
			throw new Exception("Nao foi possivel remover o item da lista: a lista esta vazia!");
	}
	
public Jogo removerInicio() throws Exception {
		
		Jogo removido;
		
		if (!listaVazia()) {
				
				removido = lista[0];
				tamanho--;
				
				for (int i = 0; i < tamanho; i++) {
					lista[i] = lista[i+1];
				}
				
				ultimo--;
				
				return removido;
			} else
			throw new Exception("Nao foi possivel remover o item da lista: a lista esta vazia!");
	}


public Jogo removerFim() throws Exception {
	
	Jogo removido;
	
	if (!listaVazia()) {
			
			removido = lista[tamanho - 1];
			tamanho--;
			
			for (int i = lista.length - 1; i < tamanho; i++) {
				lista[i] = lista[i-1];
			}
			
			ultimo--;
			
		   return removido;
		   
		} else
		throw new Exception("Nao foi possivel remover o item da lista: a lista esta vazia!");
}
	
	public void mostrar() throws Exception {
		
		if (!listaVazia()) {
			
			for (int i = primeiro; i < ultimo; i++) {
				MyIO.print("[" + i + "]");
				lista[i].imprimir();
			}
		} else
			throw new Exception("Nao foi possivel imprimir o conte�do da lista: a lista esta vazia!");
	}

	
	public void imprimir() throws Exception {
		
		if (!listaVazia()) {
			
			for (int i = primeiro; i < ultimo; i++) {
				System.out.print("Posição: " + i + ": ");
				lista[i].imprimir();
			}
		} else
			throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
	}
	public void mostrar2(Jogo removido) {

		System.out.print("(R) ");
		removido.imprimir();

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
		Jogo removido = new Jogo();
		Lista lista = new Lista(900);


		for (int a = 0; a < 642; a++) {

			String pesquisa = MyIO.readLine();
			if (pesquisa.equals("FIM")) {
				break;
			}
			String data = pesquisa.split(";")[0];
			String selecao1 = pesquisa.split(";")[1];
			int dia = Integer.parseInt(data.split("/")[0]);
			int mes = Integer.parseInt(data.split("/")[1]);
			int ano = Integer.parseInt(data.split("/")[2]);

			for (int j = 0; j < vetor.length; j++) {
				if (dia == vetor[j].getDia() && mes == vetor[j].getMes() && ano == vetor[j].getAno()
						&& selecao1.equals(vetor[j].getSelecao1())) {
					removido = vetor[j];
					lista.inserirFim(removido);
				}
			}
		}
		//lista.imprimir();

		// System.out.println("qntd");

		int qntd = MyIO.readInt();
		// System.out.println(qntd);

		for (int i = 0; i < qntd; i++) {
			// System.out.println("escolha");
			String escolha = MyIO.readLine();
			removido = new Jogo();

			if (escolha.equals("II")) {
				escolha = escolha.replace("II ", "");
				String date = escolha.split(";")[0];
				String Selecao1 = escolha.split(";")[1];
				int day = Integer.parseInt(date.split("/")[0]);
				int month = Integer.parseInt(date.split("/")[1]);
				int year = Integer.parseInt(date.split("/")[2]);

				for (int z = 0; z < vetor.length; z++) {

					if (day == vetor[z].getDia() && month == vetor[z].getMes()
							&& year == vetor[z].getAno() && Selecao1.equals(vetor[z].getSelecao1())) {

						removido = vetor[z];

						lista.inserirInicio(removido);
					}
				}
			} else if (escolha.equals("I*")) {
				int pos = MyIO.readInt();

				escolha = escolha.replace("I* ", "");
				String date = escolha.split(";")[0];
				String Selecao1 = escolha.split(";")[1];
				int day = Integer.parseInt(date.split("/")[0]);
				int month = Integer.parseInt(date.split("/")[1]);
				int year = Integer.parseInt(date.split("/")[2]);

				for (int z = 0; z < vetor.length; z++) {

					if (day == vetor[z].getDia() && month == vetor[z].getMes()
							&& year == vetor[z].getAno() && Selecao1.equals(vetor[z].getSelecao1())) {

						removido = vetor[z];

						lista.inserir(removido, pos);
					}
				}
			}

			else if (escolha.equals("IF")) {

				escolha = escolha.replace("IF ", "");
				String date = escolha.split(";")[0];
				String Selecao1 = escolha.split(";")[1];
				int day = Integer.parseInt(date.split("/")[0]);
				int month = Integer.parseInt(date.split("/")[1]);
				int year = Integer.parseInt(date.split("/")[2]);

				for (int z = 0; z < vetor.length; z++) {

					if (day == vetor[z].getDia() && month == vetor[z].getMes()
							&& year == vetor[z].getAno() && Selecao1.equals(vetor[z].getSelecao1())) {

						removido = vetor[z];

						lista.inserirFim(removido);
					}
				}
			}

			else if (escolha.equals("RI")) {
						removido=lista.removerInicio();
						lista.mostrar2(removido);
					}
				
			 else if (escolha.equals("R*")) {
				int pos = MyIO.readInt();

				removido = lista.remover(pos);
				lista.mostrar2(removido);
			}
			 else if (escolha.equals("RF")) {
				 
					removido = lista.removerFim();
					lista.mostrar2(removido);
				}
			
		}
		lista.mostrar();
	}

}
