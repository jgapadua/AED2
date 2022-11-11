import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1 {
    public static void main(String[] args) {

        String nomeArquivo = readLine("Digite o nome do arquivo a ser criado:");
        String conteudo = readLine("Digite o conteúdo do arquivo");

        ArquivoTextoEscrita arquivoEscrita = new ArquivoTextoEscrita(nomeArquivo);
        arquivoEscrita.escrever(conteudo);

        arquivoEscrita.fecharArquivo();

        ArquivoTextoLeitura arquivoLeitura = new ArquivoTextoLeitura(nomeArquivo);
        System.out.println("Conteúdo escrito:");
        String texto = arquivoLeitura.ler();
        while (texto != null) {
            System.out.println(texto);
            texto = arquivoLeitura.ler();
        }
        arquivoLeitura.fecharArquivo();
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