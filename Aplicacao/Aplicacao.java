public class Aplicacao{

public static void metodo1(int n)throws Exception {
  if ((n%2)==0){
    System.out.println(n+"eh par!");
  }else{
    throw new Exception("O numero eh impar!");
  }
/* 
  n = Integer.parseInt(args[0]);
  System.out.println("O numero inteiro: " + n); */
}

  public static void main(String[] args){
   try {
    metodo1(5);
   } 
/*    catch (NumberFormatException excecao) {
    System.out.println("Nao informe uma string como argumento para o programa");
    System.out.println("Deve ser informado um numero inteiro.");
   } 
   catch(ArrayIndexOutOfBoundsException excecao){
    System.out.println("Nao informe uma string como argumento para o programa");
    System.out.println("Deve ser informado um numero inteiro como argumento.");
   } */
   catch(Exception excecao){
    System.out.println(excecao.getMessage());
    System.out.println(excecao.getLocalizedMessage());
   }
  }
}