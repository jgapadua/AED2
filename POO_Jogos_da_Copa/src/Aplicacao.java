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
 Jogo(int dia, int mes, int ano, int placarSelecao1, int placarSelecao2, String selecao1, String selecao2,String etapa,String local ){
this.dia=dia;
this.mes=mes;
this.ano=ano;
this.placarSelecao1=placarSelecao1;
this.placarSelecao2=placarSelecao2;
this.etapa=etapa;
this.selecao1=selecao1;
this.selecao2=selecao2;
this.local=local;
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

// método para ler os valores dos atributos de um objeto
public Jogo ler(String str) {
	String[] stringArray = str.split("#");
	Jogo jogo = new Jogo();
	jogo.setAno(Integer.parseInt(stringArray[0]));
	jogo.setEtapa(stringArray[1]);
	jogo.setDia(Integer.parseInt(stringArray[2]));
	jogo.setMes(Integer.parseInt(stringArray[3]));
	jogo.setSelecao1(stringArray[4]);
	jogo.setPlacarSelecao1(Integer.parseInt(stringArray[5]));
	jogo.setPlacarSelecao2(Integer.parseInt(stringArray[6]));
	jogo.setSelecao2(stringArray[7]);
	jogo.setLocal(stringArray[8]);
	return jogo;
}

//método imprimir
public void imprimir() {
System.out.println("[COPA " + this.ano + "] [" + this.etapa + "] [" + this.dia + "/" + this.mes + "] ["+ this.selecao1 + " (" + this.placarSelecao1 + ") x (" + this.placarSelecao2 + ") " + this.selecao2 + "] [" + this.local + "]");
}
}

public class Aplicacao {
	public static boolean isFim(String str){
		return (str.length() == 3 && 
		str.charAt(0) == 'F' && 
		str.charAt(1) == 'I' && 
		str.charAt(2) == 'M');
  }
	public  static void lerJogos(Jogo[] vetor){
		// Lendo a primeira parte da entrada padrao
		String str = MyIO.readLine();
		int i = 0;
		while (isFim(str)==false) {
			Jogo jogo = new Jogo();
			vetor[i++] = jogo.ler(str);
			str = MyIO.readLine();
		}
	}
	  public static void main(String[] args) {
			MyIO.setCharset("UTF-8");
			// LEITURA JOGOS
			Jogo vetor[] = new Jogo[5000];
			lerJogos(vetor);
					// Lendo a segunda parte da entrada padrao
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
					pesquisa[a].imprimir();
				}
			}
		}