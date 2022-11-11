public class Aplicacao {
  public static void main(String[] args){
    int n1,n2,sum;
    String resposta;
    System.out.print("Digite um numero inteiro: ");
    n1 = MyIO.readInt();
    System.out.print("Digite outro numero inteiro: ");
    n2 = MyIO.readInt();
    sum=n2+n1;
    resposta=("A soma dos numeros "+n1+"+"+n2+":");
    if(sum % 2==0){
      System.out.println(resposta+" PAR");
    }
    else{
      System.out.println(resposta+" IMPAR");
    }  
  }
}
