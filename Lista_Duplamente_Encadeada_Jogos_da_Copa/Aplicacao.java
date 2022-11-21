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

	private Jogo item;
	private Celula anterior;
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

	public Celula getAnterior() {
		return anterior;
	}
	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
}

class Lista {

private Celula primeiro;
private Celula ultimo;
private int tamanho;

public Lista() {
	
	Celula sentinela;
	
	sentinela = new Celula();
	
	primeiro = sentinela;
	ultimo = sentinela;
	
	tamanho = 0;
}

public boolean listaVazia() {
	
	boolean resp;
	
	if (primeiro == ultimo)
		resp = true;
	else
		resp = false;
	
	return resp;
}

public void inserirInicio(Jogo novo) {
	
	Celula novaCelula;
	
	novaCelula = new Celula(novo);
	
	primeiro.setAnterior(novaCelula);
	novaCelula.setProximo(primeiro);
	
	primeiro = novaCelula;
	
	tamanho++;
	
}

public void inserir(Jogo objeto, int posicao){
    if(objeto == null || posicao < 0 || posicao > (tamanho+1)){
    	
    }
    if(posicao == 0) {
        inserirInicio(objeto);
    }else if(posicao == tamanho) {
        inserirFim(objeto);
    }else{
        int meio = (int) Math.round((double) posicao/2);
        Celula aux;
        Celula obj = new Celula(objeto);

        if(posicao <= meio){
            aux = primeiro;
            for(int i = 0; i < posicao; i++){
                aux = aux.getProximo();
            }
        }else{
            aux = this.ultimo;
            for(int i = tamanho; i > posicao; i--){
                aux = aux.getAnterior();
            }
        }
        obj.setAnterior(aux.getAnterior());
        obj.setProximo(aux);
        obj.getAnterior().setProximo(obj);
        aux.setAnterior(obj);
        tamanho++;
    }
}

public void inserirFim(Jogo novo) {
		
	Celula novaCelula;
	
	novaCelula = new Celula(novo);
	
	ultimo.setProximo(novaCelula);
	novaCelula.setAnterior(ultimo);
	
	ultimo = novaCelula;
	
	tamanho++;
	
}

public Jogo removerInicio(){
	Celula removida, proxima;
    if(!listaVazia()){
    	removida = primeiro;
    	proxima = primeiro.getProximo();
    	proxima.setAnterior(null);
    	removida.setProximo(null);
        primeiro = proxima;
        tamanho--;
        return (removida.getItem());
    } else
    	return null;
    
}



public Jogo removerFim()  {
	
	Celula removida, penultima;
	
	if (!listaVazia()) {
		
		removida = ultimo;
		
		penultima = ultimo.getAnterior();
		penultima.setProximo(null);
		removida.setAnterior(null);
		
		ultimo = penultima;
		
		tamanho--;
		
		return (removida.getItem());
	} 
	else
		return null;
}

public Jogo remover(int posicao){
    if(tamanho == 0 || posicao >= tamanho || posicao < 0){
        return null;
    }
    if(tamanho == 1){
        primeiro = ultimo = null;
    }else if(tamanho > 1){

        if(posicao == 0){
            return removerInicio();
        }else if(posicao == tamanho-1){
            return removerFim();
        }

        int meio = (int) Math.round((double) posicao/2);
        Celula aux;

        if(posicao <= meio){
            aux = primeiro;
            for(int i = 0; i < posicao; i++){
                aux = aux.getProximo();
            }
        }else{
            aux = ultimo;
            for(int i = tamanho-1; i > posicao; i--){
                aux = aux.getAnterior();
            }
        }

        aux.getProximo().setAnterior(aux.getAnterior());
        aux.getAnterior().setProximo(aux.getProximo());
        tamanho--;
        return (aux.getItem());
    }
    return null;
}

public void mostrar() {
	
	Celula aux;
	
	if (!listaVazia()) {
		aux = primeiro.getProximo();
		int count = 0;
		while (aux != null) {
			MyIO.print("[" + count + "]");
			aux.getItem().imprimir();
			aux = aux.getProximo();
			count++;
		}	
	} 
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
		String pesquisa = MyIO.readLine();
		Lista lista = new Lista();
    Jogo removido = new Jogo();
		
		
		while(!pesquisa.equals("FIM")) {
			String data = pesquisa.split(";")[0];
			String selecao1 = pesquisa.split(";")[1];
			int dia = Integer.parseInt(data.split("/")[0]);
			int mes = Integer.parseInt(data.split("/")[1]);
			int ano = Integer.parseInt(data.split("/")[2]);

			for(int i = 0; i < vetor.length; i++) {
				if(dia == vetor[i].getDia() && mes == vetor[i].getMes() && ano == vetor[i].getAno()
				&& selecao1.equals(vetor[i].getSelecao1())) {
					lista.inserirFim((vetor[i]));
				}
				
			}
			pesquisa = MyIO.readLine();
		}
		
		int qntd = MyIO.readInt();
		
		for (int i = 0; i < qntd; i++) {
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
