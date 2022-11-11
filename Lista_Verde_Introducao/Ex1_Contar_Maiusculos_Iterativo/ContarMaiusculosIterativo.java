public class ContarMaiusculosIterativo {

//metodo MAIUCULAS
	public static boolean maiusculas(char c){
		return (c >= 'A' && c <= 'Z');
 	}

//metodo FIM
 	public static boolean fim(String str){
		return (str.length() == 3 && 
		str.charAt(0) == 'F' && 
		str.charAt(1) == 'I' && 
		str.charAt(2) == 'M');
 	}

/*Crie um método iterativo em Java que receba como parâmetro uma string e 
retorne o número de caracteres maiúsculos presentes nessa string*/

 public static int contarMaiusculas (String str){
	int resp = 0;
	for(int i = 0; i < str.length(); i++){
		 if(maiusculas(str.charAt(i)) == true){
				resp++; 
		 }
	}
	return resp;
}
	public static void main(String[] args) {
		String[] entrada = new String[1000];
		int numEntrada = 0;
		do{
			 entrada[numEntrada] = MyIO.readLine();
		}while (fim(entrada[numEntrada++]) == false);
		numEntrada--; 
		for(int i = 0; i < numEntrada; i++){
     		int resp= contarMaiusculas(entrada[i]);
		MyIO.println(resp);
		}
	}
}