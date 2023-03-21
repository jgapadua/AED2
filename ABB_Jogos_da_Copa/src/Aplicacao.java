import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

class Jogo {
	private int dia, mes, ano, placarSelecao1, placarSelecao2;
	private String etapa, selecao1, selecao2, local;

	Jogo(int ano, String etapa, int dia, int mes, String selecao1, int placarSelecao1, int placarSelecao2,
			String selecao2, String local) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.placarSelecao1 = placarSelecao1;
		this.placarSelecao2 = placarSelecao2;
		this.etapa = etapa;
		this.selecao1 = selecao1;
		this.selecao2 = selecao2;
		this.local = local;
	}

	public Jogo() {

	}

	public Jogo cloneJogo() {
		Jogo novoJogo = new Jogo();
		novoJogo.dia = this.dia;
		novoJogo.mes = this.mes;
		novoJogo.ano = this.ano;
		novoJogo.placarSelecao1 = this.placarSelecao1;
		novoJogo.placarSelecao2 = this.placarSelecao2;
		novoJogo.etapa = this.etapa;
		novoJogo.selecao1 = this.selecao1;
		novoJogo.selecao2 = this.selecao2;
		novoJogo.local = this.local;

		return novoJogo;
	}

	public int getDia() {
		return this.dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return this.mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPlacarSelecao1() {
		return this.placarSelecao1;
	}

	public void setPlacarSelecao1(int placarSelecao1) {
		this.placarSelecao1 = placarSelecao1;
	}

	public int getPlacarSelecao2() {
		return this.placarSelecao2;
	}

	public void setPlacarSelecao2(int placarSelecao2) {
		this.placarSelecao2 = placarSelecao2;
	}

	public String getEtapa() {
		return this.etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public String getSelecao1() {
		return this.selecao1;
	}

	public void setSelecao1(String selecao1) {
		this.selecao1 = selecao1;
	}

	public String getSelecao2() {
		return this.selecao2;
	}

	public void setSelecao2(String selecao2) {
		this.selecao2 = selecao2;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Jogo SplitLinhas(String read) {

		String linhas[] = read.split("#");
		Jogo jogo = new Jogo(Integer.parseInt(linhas[0]), linhas[1], Integer.parseInt(linhas[2]),
				Integer.parseInt(linhas[3]), linhas[4], Integer.parseInt(linhas[5]), Integer.parseInt(linhas[6]),
				linhas[7], linhas[8]);

		return jogo;
	}

	public void imprimir() {
		System.out.println("[COPA " + this.ano + "] [" + this.etapa + "] [" + this.dia + "/" + this.mes + "] ["
				+ this.selecao1 + " (" + this.placarSelecao1 + ") x (" + this.placarSelecao2 + ") " + this.selecao2
				+ "] [" + this.local + "]");
	}

}

class No {

	private Jogo item;
	private No esquerda;
	private No direita;

	public No() {

		item = new Jogo();
		esquerda = null;
		direita = null;
	}

	public No(Jogo registro) {

		item = registro;
		esquerda = null;
		direita = null;
	}

	public Jogo getItem() {
		return item;
	}

	public void setItem(Jogo item) {
		this.item = item;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}
}

class ABB {

	private No raiz;

	public ABB() {

		raiz = null;
	}

	// chave: 19
	public Jogo pesquisar(Jogo listado) {
		return pesquisar(this.raiz, listado);
	}

	// 1.a execução:
	// raizSubarvore: 16
	// chave: 19
	// retorna o resultado da 2.a execução do método pesquisar: 19
	// 2.a execução:
	// raizSubarvore: 23
	// chave: 19
	// retorna o resultado da 3.a execução do método pesquisar: 19
	// 3.a execução:
	// raizSubarvore: 19
	// chave: 19
	// retorna: 19

	private Jogo pesquisar(No raizSubarvore, Jogo chave) {

		if (raizSubarvore == null)
			return null;
		else if (chave.getDia() == raizSubarvore.getItem().getDia()
				&& chave.getMes() == raizSubarvore.getItem().getMes()
				&& chave.getAno() == raizSubarvore.getItem().getAno()
				&& chave.getSelecao1() == raizSubarvore.getItem().getSelecao1())
			return raizSubarvore.getItem();
		else if (chave.getDia() > raizSubarvore.getItem().getDia()
				|| chave.getMes() > raizSubarvore.getItem().getMes()
				|| chave.getAno() > raizSubarvore.getItem().getAno()
				|| chave.getSelecao1().length() > raizSubarvore.getItem().getSelecao1().length())
			return pesquisar(raizSubarvore.getDireita(), chave);
		else
			return pesquisar(raizSubarvore.getEsquerda(), chave);
	}

	// novo: 11
	// atribuir à raiz da árvore o retorno da 1.a execução do método inserir: 16
	public void inserir(Jogo novo) throws Exception {
		this.raiz = inserir(this.raiz, novo);
	}

	// 1.a execução:
	// raizSubarvore: 16
	// novo: 11
	// atribuir à subárvore esquerda do 16 o retorno da 2.a execução do método
	// inserir: 8
	// retorno: 16
	// 2.a execução:
	// raizSubarvore: 8
	// novo: 11
	// atribuir à subárvore direita do 8 o retorno da 3.a execução do método
	// inserir: 11
	// retorno: 8
	// 3.a execução:
	// raizSubarvore: null
	// novo: 11
	// retorno: 11
	private No inserir(No raizSubarvore, Jogo novo) throws Exception {
		if (raizSubarvore == null)
			raizSubarvore = new No(novo);
		else if (novo.getAno() == raizSubarvore.getItem().getAno())
			throw new Exception("Não foi possível inserir o item na árvore: chave já inseriada anteriormente!");
		else if (novo.getMes() == raizSubarvore.getItem().getMes())
			throw new Exception("Não foi possível inserir o item na árvore: chave já inseriada anteriormente!");
		else if (novo.getDia() == raizSubarvore.getItem().getDia())
			throw new Exception("Não foi possível inserir o item na árvore: chave já inseriada anteriormente!");
		else if (novo.getSelecao1() == raizSubarvore.getItem().getSelecao1())
			throw new Exception("Não foi possível inserir o item na árvore: chave já inseriada anteriormente!");

		else if (novo.getAno() < raizSubarvore.getItem().getAno())
			raizSubarvore.setEsquerda(inserir(raizSubarvore.getEsquerda(), novo));

		else if (novo.getMes() < raizSubarvore.getItem().getMes())
			raizSubarvore.setEsquerda(inserir(raizSubarvore.getEsquerda(), novo));

		else if (novo.getDia() < raizSubarvore.getItem().getDia())
			raizSubarvore.setEsquerda(inserir(raizSubarvore.getEsquerda(), novo));

		else if (novo.getSelecao1().length() < raizSubarvore.getItem().getSelecao1().length())
			raizSubarvore.setEsquerda(inserir(raizSubarvore.getEsquerda(), novo));

		else
			raizSubarvore.setDireita(inserir(raizSubarvore.getDireita(), novo));

		return raizSubarvore;
	}

	// chaveRemover: 19
	// raiz = retorno da 1.a execução do método remover --> 16
	public void remover(Jogo chaveRemover) throws Exception {
		this.raiz = remover(this.raiz, chaveRemover);
	}

	// 1.a execução:
	// raizSubarvore: 16
	// chaveRemover: 19
	// subárvore à direita do 16 = retorno da 2.a execução do método remover --> 23
	// retorna: 16
	// 2.a execução:
	// raizSubarvore: 23
	// chaveRemover: 19
	// subárvore à esquerda do 23 = retorno da 3.a execução do método remover -->
	// null
	// retorna: 23
	// 3.a execução:
	// raizSubarvore: 19
	// chaveRemover: 19
	// retorna: null
	private No remover(No raizSubarvore, Jogo chaveRemover) throws Exception {

		if (raizSubarvore == null)
			throw new Exception("Não foi possível remover o item da árvore: chave não encontrada!");
		else if (chaveRemover.getDia() == raizSubarvore.getItem().getDia()
				&& chaveRemover.getMes() == raizSubarvore.getItem().getMes()
				&& chaveRemover.getAno() == raizSubarvore.getItem().getAno()
				&& chaveRemover.getSelecao1() == raizSubarvore.getItem().getSelecao1()) {
			if (raizSubarvore.getEsquerda() == null)
				raizSubarvore = raizSubarvore.getDireita();
			else if (raizSubarvore.getDireita() == null)
				raizSubarvore = raizSubarvore.getEsquerda();
			else
				raizSubarvore.setEsquerda(antecessor(raizSubarvore, raizSubarvore.getEsquerda()));
		} else if (chaveRemover.getDia() > raizSubarvore.getItem().getDia()
				&& chaveRemover.getMes() > raizSubarvore.getItem().getMes()
				&& chaveRemover.getAno() > raizSubarvore.getItem().getAno()
				&& chaveRemover.getSelecao1().length() > raizSubarvore.getItem().getSelecao1().length())
			raizSubarvore.setDireita(remover(raizSubarvore.getDireita(), chaveRemover));
		else
			raizSubarvore.setEsquerda(remover(raizSubarvore.getEsquerda(), chaveRemover));

		return raizSubarvore;
	}

	private No antecessor(No noRetirar, No raizSubarvore) {

		if (raizSubarvore.getDireita() != null)
			raizSubarvore.setDireita(antecessor(noRetirar, raizSubarvore.getDireita()));
		else {
			noRetirar.setItem(raizSubarvore.getItem());
			raizSubarvore = raizSubarvore.getEsquerda();
		}

		return raizSubarvore;
	}

	public void caminhamentoEmOrdem() {
		caminhamentoEmOrdem(this.raiz);
	}

	// 1.a execução: raizSubarvore: 16
	// parou imprimindo a subárvore esquerda
	// 2.a execução: raizSubarvore: 8
	// parou imprimindo a subárvore direita
	// 3.a execução: raizSubarvore: 4
	// parou imprimindo a subárvore direita --> finalizada
	// 4.a execução: raizSubarvore: null --> finalizada
	// 5.a execução: raizSubarvore: 5
	// parou imprimindo a subárvore direita --> finalizada
	// 6.a execução: raizSubarvore: null --> finalizada
	// 7.a execução: raizSubarvore: null --> finalizada
	// 8.a execução: raizSubarvore: 11
	private void caminhamentoEmOrdem(No raizSubarvore) {

		if (raizSubarvore != null) {
			caminhamentoEmOrdem(raizSubarvore.getEsquerda());
			raizSubarvore.getItem().imprimir();
			caminhamentoEmOrdem(raizSubarvore.getDireita());
		}
	}
}

public class Aplicacao {

	public static int LerArquivo(Jogo[] vetorJogos) {
		ArquivoTextoLeitura arquivoEntrada;
		String entrada = new String();
		entrada = "src/partidas.txt";
		arquivoEntrada = new ArquivoTextoLeitura(entrada);

		String linhasArquivo = arquivoEntrada.ler();

		int i = 0;
		int contador = 0;
		while (linhasArquivo != null && linhasArquivo != "FIM") {

			Jogo jogoNovo = new Jogo();
			vetorJogos[i] = jogoNovo.SplitLinhas(linhasArquivo);
			jogoNovo = jogoNovo.SplitLinhas(linhasArquivo);
			contador = i++;
			vetorJogos[i] = jogoNovo;
			linhasArquivo = arquivoEntrada.ler();
		}
		arquivoEntrada.fecharArquivo();

		return contador;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		MyIO.setCharset("UTF-8");
		Jogo vetorJogos[] = new Jogo[5000];
		Jogo vetorSort[] = new Jogo[5000];
		Jogo pesquisado = new Jogo();
		Jogo listado = new Jogo();
		// LEITURA JOGOS
		int tam = LerArquivo(vetorJogos);

		// ENTRADA
		ABB minhaArvore = new ABB();

		int cont = 0;

		int b = 0;
		String pesquisa = MyIO.readLine();

		while (!pesquisa.equals("FIM")) {

			String data = pesquisa.split(";")[0];
			String selecao1 = pesquisa.split(";")[1];
			int dia = Integer.parseInt(data.split("/")[0]);
			int mes = Integer.parseInt(data.split("/")[1]);
			int ano = Integer.parseInt(data.split("/")[2]);

			for (int j = 0; j < tam; j++) {

				if (dia == vetorJogos[j].getDia() && mes == vetorJogos[j].getMes() && ano == vetorJogos[j].getAno()
						&& selecao1.equals(vetorJogos[j].getSelecao1())) {

					listado = vetorJogos[j];
			
					minhaArvore.inserir(listado);

					j = tam;
				}

			}
			pesquisa = MyIO.readLine();
			
			
			
		}
		
		// minhaLista.imprimir();

		// System.out.println("qntd");
		

		for (int w = 0; w < tam; w++) {

			pesquisado = minhaArvore.pesquisar(listado);
			if (pesquisado != null) {
				System.out.println(pesquisa);
				System.out.print("SIM");
			}

			else {
				System.out.println("NÃO");
			}

		}

	}

}

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
