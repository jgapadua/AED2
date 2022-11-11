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
 String nomeArquivo="src/partidas.txt";
  /*String nomeArquivo="/tmp/partidas.txt";*/
  ArquivoTextoLeitura arquivoLeitura = new ArquivoTextoLeitura(nomeArquivo);
  
  // Preenchendo um vetor de objetos com os dados do arquivo
	int quantidade = 900;
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

//método imprimir
public void imprimir() {
	System.out.println("[COPA " + this.ano + "] [" + this.etapa + "] [" + this.dia + "/" + this.mes + "] ["+ this.selecao1 + " (" + this.placarSelecao1 + ") x (" + this.placarSelecao2 + ") " + this.selecao2 + "] [" + this.local + "]");
	}
	}

class Celula {

	private Jogo item;
	private Celula proximo;
	
	public Celula(Jogo novo) {
		item = novo;
		proximo = null;
	}
	
	public Celula() {
		
		item = new Jogo();
		proximo = null;
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

class Pilha {

	private Celula fundo;
	private Celula topo;
	
	public Pilha() {
		
		Celula sentinela;
		
		sentinela = new Celula();
		fundo = sentinela;
		topo = sentinela;
	}
	
	public boolean pilhaVazia() {
		
		if (fundo == topo)
			return true;
		else
			return false;
	}
	
	public void empilhar(Jogo novo) {
		
		Celula novaCelula;
		
		novaCelula = new Celula(novo);
		novaCelula.setProximo(topo);
		topo = novaCelula;
	}
	
	public Jogo desempilhar() throws Exception {
		
		Jogo desempilhado;
		
		if (!pilhaVazia()) {
			desempilhado =  topo.getItem();;
			topo = topo.getProximo();
			return desempilhado;
		} else
			throw new Exception("Não foi possível desempilhar: a pilha está vazia!");
	}
	
	public Jogo consultarTopo() throws Exception {
		
		if (!pilhaVazia()) {
			return(topo.getItem());
		} else
			throw new Exception("Não foi possível consultar o topo da pilha: a pilha está vazia!");
	}
	public void mostrar(Jogo desempilhado) {

		System.out.print("(D)");
		desempilhado.imprimir();

	}
	public void mostrarJogos() throws Exception{
	        Celula aux;
	        int posicao = 0;

					if (!pilhaVazia()) {
						aux = topo;
						
						while (aux.getItem() != null) {
							MyIO.print("[" + posicao + "]");
							aux.getItem().imprimir();
							aux = aux.getProximo();
							posicao++;
						}
	        }  else
					throw new Exception("Não foi possível imprimir o conteúdo da pilha: a pilha está vazia!");
	    }
	
}
public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		MyIO.setCharset("UTF-8");
		// LEITURA JOGOS
		Jogo vetor[] = Jogo.lerArquivo();
		Jogo desempilhado = new Jogo();
		// ENTRADA

		Pilha pilha = new Pilha();
		for (int a = 0; a < 601; a++) {

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
							desempilhado = vetor[j];
							pilha.empilhar(desempilhado);
				}
			}
		}

		System.out.println("qntd");
		int qntd = MyIO.readInt();

		for (int i = 0; i < qntd; i++) {
			String EouD = MyIO.readLine();
			desempilhado = new Jogo();

			if (EouD.equals("D")) {
				desempilhado = pilha.desempilhar();
				pilha.mostrar(desempilhado);
		
			}else if (EouD.equals("E")) {
				EouD = EouD.replace("E ", "");
				String date = EouD.split(";")[0];
				String Selecao1 = EouD.split(";")[1];
				int day = Integer.parseInt(date.split("/")[0]);
				int month = Integer.parseInt(date.split("/")[1]);
				int year = Integer.parseInt(date.split("/")[2]);

				for (int z = 0; z < vetor.length; z++) {
					if (day == vetor[z].getDia() && month == vetor[z].getMes()
							&& year == vetor[z].getAno() && Selecao1.equals(vetor[z].getSelecao1())) {
								desempilhado = vetor[z];
						pilha.empilhar(desempilhado);
					}
				}
			}
		}
		
		pilha.mostrarJogos();
}
}
	
	
