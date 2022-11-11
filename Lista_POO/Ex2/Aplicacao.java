
public class Aplicacao {
  public static void main(String[] args) {
    CartaoValeTransporte cartao,cartao2,copia;
  
      cartao= new CartaoValeTransporte(21074,	50.00);
      copia=new CartaoValeTransporte();
      cartao2= new CartaoValeTransporte(390176,	25.00);
  
      copia.clone(cartao);
  

      cartao.imprimir(1);
      copia.imprimir(3);
      cartao2.imprimir(2);

      cartao.pagar(2.80);
      cartao.imprimir(1);
      cartao.pagar(1.40);
      cartao.imprimir(1);
      cartao.carregar(5.00);
      cartao.imprimir(1);
      cartao.bloquear(cartao2);
      cartao.imprimir(1);
      cartao2.imprimir(2);
    }
  }

