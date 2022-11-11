
public class Veiculo {
  private int id;
  private int velocidade;
  private double multa;

	Veiculo(int id,int velocidade,double multa){
		this.id = id;
		this.velocidade = velocidade;
    this.multa = multa;
	}
	
  public void imprimirVeiculo() {
    System.out.println("ID: "+ id);
		System.out.println("Velocidade: "+ velocidade);
    System.out.println("Multa: R$"+  String.format("%.2f",multa));
	}

  public int getID(){
    return id;
  } 

  public void setID(int id){
    this.id=id;
  }

  public int getVelocidade(){
    return velocidade;
  } 

  public void setVelocidade(int velocidade){
    this.velocidade=velocidade;
  }
  
  public Double getMulta(){
    return multa;
  } 

  public void setMulta(Double multa){
    this.multa=multa;
  }
}
//Esse radar deve receber a velocidade de cinco veículos
//calcular e exibir a quantidade de veículos com velocidade acima de 60 km/h
//radar também deve informar o total arrecadado com multas
//considerando que o valor de cada multa é de R$ 150,00 e que veículos com velocidade superior a 60 km/h serão multados