//Lembre-se que em Java o número de linhas e colunas de uma matriz pode ser obtido por seus atributos.

public class Aplicacao {

	public static void main(String args[]) {
    int matriz[][] = new int[3][4];
	int maior = 0;
	String posicaoMaior = "";
	int menor = 0;
	String posicaoMenor = "";
	
	for(int linha=0 ; linha < 3 ; linha++){
        for(int coluna = 0; coluna < 4; coluna ++){
        	do {
        	MyIO.println("O número tem que ser inteiro e positivo.");
            MyIO.print("Insira o elemento M[" + (linha) + "][" + (coluna) + "]: ");
            matriz[linha][coluna] = MyIO.readInt();
        	}while(matriz[linha][coluna]<0);
        	}
    }
	
    for(int linha=0 ; linha < 3 ; linha++){
        for(int coluna = 0; coluna < 4; coluna ++){
        	if(matriz[linha][coluna] > maior) {
        		maior= matriz[linha][coluna];
        		posicaoMaior = "[" + linha + ", " + coluna + "]";
        	}
        }
    }
    
    menor = maior;
    for(int linha=0 ; linha < 3 ; linha++){
        for(int coluna = 0; coluna < 4; coluna ++){
        	if(matriz[linha][coluna] < menor) {
        		menor = matriz[linha][coluna];
        		posicaoMenor = "[" + linha + ", " + coluna + "]";
        	}
        }
    }
    
    MyIO.println("O maior elemento da matriz informada é: " + maior);
    MyIO.println("Sua posição é: " + posicaoMaior);
    
    MyIO.println("O menor elemento da matriz informada é: " + menor);
    MyIO.println("Sua posição é: " + posicaoMenor);
    }
    }