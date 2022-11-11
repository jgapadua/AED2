import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 {

    public static void main(String[] args) {
        
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("Codificação");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        String nomeArquivo = readLine("Digite o nome do arquivo a ser criptografado:");

        ArquivoTextoLeitura arquivoLeituraCod = new ArquivoTextoLeitura(nomeArquivo);

        String nomeArquivoCod = nomeArquivo +"_CRIPTO";
        
        ArquivoTextoEscrita arquivoEscritaCod = new ArquivoTextoEscrita(nomeArquivoCod);

        String texto = arquivoLeituraCod.ler();

        Codificador codificador = new Codificador();

        while (texto != null) {
            arquivoEscritaCod.escrever(codificador.codifica(texto));
            texto = arquivoLeituraCod.ler();
        }
        arquivoEscritaCod.fecharArquivo();

        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("Decodificação");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

        String nomeArquivoDecod = nomeArquivoCod;

        ArquivoTextoLeitura arquivoLeituraDecod = new ArquivoTextoLeitura(nomeArquivoDecod);

        String nomeArquivoDecodSalvo = nomeArquivo+"_DESCRIPTO";
        ArquivoTextoEscrita arquivoEscritaDecod = new ArquivoTextoEscrita(nomeArquivoDecodSalvo);

        String textoDecod = arquivoLeituraDecod.ler();

        Decodificador decodificador = new Decodificador();

        while (textoDecod != null) {
            arquivoEscritaDecod.escrever(decodificador.decodifica(textoDecod));
            textoDecod = arquivoLeituraDecod.ler();
        }

        arquivoLeituraDecod.fecharArquivo();
        arquivoEscritaDecod.fecharArquivo();
        arquivoLeituraCod.fecharArquivo();
    }

    public static String readLine(String msg) {
        System.out.println(msg);
        String i = null;
        try {
            i = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
}