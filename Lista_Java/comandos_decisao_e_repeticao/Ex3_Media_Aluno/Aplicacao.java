public class Aplicacao {
  public static void main(String[] args){
  float n1,n2,n3,sum,avg;
  
  do {
  System.out.print("Digite a primeira nota: ");
  n1 = MyIO.readFloat();
  System.out.print("Digite a segunda nota: ");
  n2 = MyIO.readFloat();
  System.out.print("Digite a terceira nota: ");
  n3 = MyIO.readFloat();
  }while(n1<0 || n1>10 && n2<0 || n2>10 && n3<0 || n3>10);
    sum=n1+n2+n3;
    avg=sum/3;
    if(avg==0.0||avg<4.0) {
    System.out.println("Sua media: " + String.format("%.1f",avg) + " - Reprovado");
    }
    else if (avg==4.0||avg<6.0) {
      System.out.println("Sua media: " + String.format("%.1f",avg) + " - Exame Especial");
      }
    else if (avg==6.0||avg<=10.0) {
      System.out.println("Sua media: " + String.format("%.1f",avg) + " - Aprovado");
      }
  }
  }
