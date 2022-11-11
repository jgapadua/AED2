
public class Aplicacao {
public static void main(String[] args) {
  Retangulo ret,quadrado,copia;

    ret= new Retangulo(4.0,6.0);
    copia=new Retangulo();
    quadrado= new Retangulo(5.0);

    copia.clone(ret);

 
    quadrado.imprimir();
    ret.imprimir();
    copia.imprimir();
  }
}
