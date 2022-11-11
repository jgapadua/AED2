public class Decodificador {

  public String decodifica(String textoCodificado) {
    StringBuilder aux = new StringBuilder();
    for(int i = 0; i < textoCodificado.length(); i++){
        char c = textoCodificado.charAt(i);
        if(c == 'a'){ 
            c = 'z';
        }else {
           c--;
        }
        aux.append(c);
    }
    return aux.toString();
}
}