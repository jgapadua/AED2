//Comparação entre strings é realizada com o método equals. Leia os dados e já armazene em um vetor, ao invés de armazenar em uma string e depois dar split.

public class Aplicacao {

	public static void main(String args[]) {
		
        int qtdAlunos = 10;
        int numQuestoes = 8;
        int[] answers = new int[5];
        String objAlunos = "";
        String strGabarito = "";
        String strAcertos = "";
        int totalAcertos = 0;
        double qtdAprovados = 0;
        double porcAprv;
        
        
        MyIO.println("Digite o gabarito da prova:");
        for(int i = 0; i < numQuestoes; i++) {
        	strGabarito[] += MyIO.readLine() + ",";
        }
        
        String gabarito[] = strGabarito.split(", ");
        for(int i = 0; i < gabarito.length; i++) {
        	MyIO.println(gabarito[i]);
        }
        
        for(int i = 0; i < qtdAlunos; i++) {
        	MyIO.println("Digite seu numero:");
        	objAlunos += "Aluno " + MyIO.readLine() + ", ";  
        	MyIO.println("Digite suas respostas:");
        	for(int j = 0; j < numQuestoes; j++) {
            	if(MyIO.readLine().contains(gabarito[j])) {
            		totalAcertos++;
            	}
            }
        	strAcertos += totalAcertos + ", ";
        	totalAcertos = 0;
        }
        
        String acertos[] = strAcertos.split(", ");
        String alunos[] = objAlunos.split(", ");
        
        for(int i = 0; i < alunos.length; i++) {
        	MyIO.print(alunos[i] + " - Nota: ");
        	MyIO.println(acertos[i]);
        	if(Integer.parseInt(acertos[i]) >= 5) {
        		qtdAprovados++;
        	}
        }
        porcAprv = (qtdAprovados/10.00) * 100;
        MyIO.println(porcAprv);
        MyIO.println("Porcentagem de aprovação foi: " + porcAprv + "%");

}}