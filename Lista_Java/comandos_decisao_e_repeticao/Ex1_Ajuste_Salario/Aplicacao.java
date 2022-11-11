public class Aplicacao {
  public static void main(String[] args){
       double salario;
       System.out.print("Digite o salario atual: ");
       salario = MyIO.readDouble();
       if(salario <= 1200.00){
         salario= salario * 1.10;
         System.out.println("O novo salario do funcionario e de: R$ " + String.format("%.2f",salario) + " com aumento de 10%.");
       }
       else{
         salario= salario * 1.05;
           System.out.println("O novo salario do funcionario e de: R$ " + String.format("%.2f",salario) + " com aumento de 5%.");
       }  
     }
}
