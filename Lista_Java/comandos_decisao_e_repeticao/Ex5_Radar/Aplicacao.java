import java.util.Random;

public class Aplicacao {
  public static void main(String[] args){
    Veiculo v1;
    Veiculo v2;
    Veiculo v3;
    Veiculo v4;
    Veiculo v5;
    Random random = new Random();
    int limite=60;
    int cont=0;
    double total,multa;
    multa=150.00;
    v1 = new Veiculo(1, random.nextInt(260),0);
	  v2 = new Veiculo(2, random.nextInt(260),0);
    v3 = new Veiculo(3, random.nextInt(260),0);
    v4 = new Veiculo(4, random.nextInt(260),0);
    v5 = new Veiculo(5, random.nextInt(260),0);

    if(v1.getVelocidade()>limite){
       cont++;
       v1.setMulta(multa);
    }
    if(v2.getVelocidade()>limite){
      cont++;
      v2.setMulta(multa);
   }
   if(v3.getVelocidade()>limite){
    cont++;
    v3.setMulta(multa);
 }
  if(v4.getVelocidade()>limite){
  cont++;
  v4.setMulta(multa);
}
  if(v5.getVelocidade()>limite){
  cont++;
  v5.setMulta(multa);
}
total=cont*multa;
v1.imprimirVeiculo();
v2.imprimirVeiculo();
v3.imprimirVeiculo();
v4.imprimirVeiculo();
v5.imprimirVeiculo();
System.out.println(cont+" acima de 60km/h.");
System.out.println("Total de multas: R$"+String.format("%.2f",total) +".");
  }
}
//Esse radar deve receber a velocidade de cinco veículos
//calcular e exibir a quantidade de veículos com velocidade acima de 60 km/h
//radar também deve informar o total arrecadado com multas
//considerando que o valor de cada multa é de R$ 150,00 e que veículos com velocidade superior a 60 km/h serão multados