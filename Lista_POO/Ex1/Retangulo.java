
public class Retangulo{

  private double base;
  private double altura;

  Retangulo(){
    this.base=0.0;
    this.altura=0.0;
  }
  Retangulo(double lado){
  this.base=lado;
  this.altura=lado;
  }
  Retangulo(double base,double altura){
  this.base=base;
  this.altura=altura;
  }

  public double getBase(){
    return base;
  }
  public void setBase(double base){
    this.base=base;
  }

  public double getAltura(){
    return altura;
  }
  public void setAltura(double altura){
    this.altura=altura;
  }

  public void clone(Retangulo ret){
    this.altura= ret.getAltura();
		this.base= ret.getBase();
  }

  public void imprimir(){
    System.out.println("Dados do retangulo:");
    System.out.println("Base:"+this.base+" Altura:"+this.altura+" Area:"+this.getArea()+" Perimetro:"+this.getPerimetro());;
  }

  public double getPerimetro(){
    return (2*(this.base+this.altura));
  }
  public double getArea(){
    return (this.base*this.altura);
  }


}