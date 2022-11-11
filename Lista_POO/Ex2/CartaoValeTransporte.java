

public class CartaoValeTransporte{

  private int numero;
  private double saldo;
  private boolean bloqueado;

  CartaoValeTransporte(){
    this.numero=0;
    this.saldo=0.00;
    this.bloqueado=false;
  }

  CartaoValeTransporte(int numero,double saldo,boolean bloqueado){
  this.numero=numero;
  this.saldo=saldo;
  this.bloqueado=bloqueado;
  }

  CartaoValeTransporte(int numero,double saldo){
    this.numero=numero;
    this.saldo=saldo;
    }

  public int getNumero(){
    return numero;
  }
  public void setNumero(int numero){
    this.numero=numero;
  }

  public double getSaldo(){
    return saldo;
  }
  public void setSaldo(double saldo){
    this.saldo=saldo;
  }
  public boolean getBloqueado(){
    return bloqueado;
  }
  public void setBloqueado( boolean bloqueado){
    this.bloqueado=bloqueado;
  }

  public void clone(CartaoValeTransporte cartao){
  this.numero=cartao.getNumero();
  this.saldo=cartao.getSaldo();
  this.bloqueado=cartao.getBloqueado();
  }

  public void imprimir(int i){
    System.out.println("Dados do cartao"+i+": ");
    System.out.println("Numero:"+this.numero+" Saldo:"+ String.format("%.2f",this.saldo)+" Bloqueado:"+this.bloqueado);
  }

  public void carregar(double credito){
   if (this.bloqueado==false && credito>0){
    this.saldo=getSaldo()+credito;
   }else
   System.out.println("Não pode carregar");
  }

  public void pagar(double tarifa){
    if (this.bloqueado==false && tarifa>0 && this.saldo>=tarifa){
     this.saldo=getSaldo()-tarifa;
    }else
    System.out.println("Não pode pagar");
   }

   public void bloquear(CartaoValeTransporte destino){
    this.setBloqueado(true);
		destino.setSaldo(this.getSaldo() + destino.getSaldo());
		this.setSaldo(0);
   }
}