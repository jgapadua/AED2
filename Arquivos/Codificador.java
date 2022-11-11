public class Codificador {

  public String codifica(String textoCodificado) {
    StringBuilder aux = new StringBuilder();
    for(int i = 0; i < textoCodificado.length(); i++){
        char c = textoCodificado.charAt(i);
        if(c == 'z'){ 
            c = 'a';
        }else {
           c++;
        }
        aux.append(c);
    }
    return aux.toString();
}
}