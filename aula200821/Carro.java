package aula200821;

public class Carro {

  private String marca;
  private String modelo;
  private String cor;
  private int marcha;
  public double velocidade;

  public void Acelerar(){
    velocidade += marcha * 10;
  } 
  public void Frear(){
    velocidade -= marcha * 10;
  }
  public double GetVelocidade(){
    return velocidade;
  } 
  public int GetMarcha(){
    return marcha;
  } 
  public void TrocarMarcha(int novaMarcha)
  {
    marcha= novaMarcha;
  } 
}