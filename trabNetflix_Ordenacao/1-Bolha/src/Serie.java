import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class BubbleSort
{
    void bubbleSort(Serie[] series) throws IOException
    {
    	int comp = 0;
    	int mov = 0;
    	long start = System.currentTimeMillis();
        for (int a = 1; a < series.length; a++) {
            for (int b = 0; b < series.length - a; b++) {
            	comp++;
            	if(series[b].getDuracao().compareTo(series[b + 1].getDuracao()) == 0) {
            		if (series[b].getNome().compareTo(series[b + 1].getNome()) > 0) {
                        // swap movies[b] with movies[b+1]
            			Serie temp = series[b];
            			series[b] = series[b + 1];
            			series[b + 1] = temp;
                        mov++;
                    }
            	} else {
            		if (series[b].getDuracao().compareTo(series[b + 1].getDuracao()) > 0) {
                        // swap movies[b] with movies[b+1]
            			Serie temp = series[b];
            			series[b] = series[b + 1];
            			series[b + 1] = temp;
                        mov++;
                    }
            	}
                
            }
        }
        
        long time = System.currentTimeMillis() - start;
        
        File file = new File("matricula_bolha.txt");
        PrintWriter writer = new PrintWriter("matricula_bolha.txt", "UTF-8");
        writer.println("729961" + "\t" + time + "\t" + comp + "\t" + mov);
        writer.close();
    }
 
    void printArray(Serie arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            arr[i].imprimir();
    }
}



public class Serie {

	private int numeroDeTemporadas, numeroDeEpisodios;
	private String nome, duracao, formato, paisDeOrigem, idiomaDeOrigem, emissoraDeTelevisaoOriginal, dataDeInicioDaTransmissaoOriginal;
	
	public Serie() {

	}

	public int getNumeroDeTemporadas() {
		return numeroDeTemporadas;
	}

	public void setNumeroDeTemporadas(int numeroDeTemporadas) {
		this.numeroDeTemporadas = numeroDeTemporadas;
	}

	public int getNumeroDeEpisodios() {
		return numeroDeEpisodios;
	}

	public void setNumeroDeEpisodios(int numeroDeEpisodios) {
		this.numeroDeEpisodios = numeroDeEpisodios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}

	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}

	public String getIdiomaDeOrigem() {
		return idiomaDeOrigem;
	}

	public void setIdiomaDeOrigem(String idiomaDeOrigem) {
		this.idiomaDeOrigem = idiomaDeOrigem;
	}

	public String getEmissoraDeTelevisaoOriginal() {
		return emissoraDeTelevisaoOriginal;
	}

	public void setEmissoraDeTelevisaoOriginal(String emissoraDeTelevisaoOriginal) {
		this.emissoraDeTelevisaoOriginal = emissoraDeTelevisaoOriginal;
	}

	public String getDataDeInicioDaTransmissaoOriginal() {
		return dataDeInicioDaTransmissaoOriginal;
	}

	public void setDataDeInicioDaTransmissaoOriginal(String dataDeInicioDaTransmissaoOriginal) {
		this.dataDeInicioDaTransmissaoOriginal = dataDeInicioDaTransmissaoOriginal;
	}

	public Serie(int numeroDeTemporadas, int numeroDeEpisodios, String nome, String formato, String paisDeOrigem,
			String idiomaDeOrigem, String emissoraDeTelevisaoOriginal, String dataDeInicioDaTransmissaoOriginal) {
		super();
		this.numeroDeTemporadas = numeroDeTemporadas;
		this.numeroDeEpisodios = numeroDeEpisodios;
		this.nome = nome;
		this.formato = formato;
		this.paisDeOrigem = paisDeOrigem;
		this.idiomaDeOrigem = idiomaDeOrigem;
		this.emissoraDeTelevisaoOriginal = emissoraDeTelevisaoOriginal;
		this.dataDeInicioDaTransmissaoOriginal = dataDeInicioDaTransmissaoOriginal;
	}

	public static List<String> ler() throws IOException {
		Serie a = new Serie();
//     	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/data.txt"), "ISO-8859-1"));
     	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/data.txt"), "ISO-8859-1"));
        br.readLine();
        String line;
        List<String> list = new ArrayList<String>();
        while ((line = br.readLine()) != null){
        	list.add(line);
        }
        
        return list;
	}
	
	public void imprimir() {
		MyIO.println(nome + " ## " + formato + " ## " + duracao + " ## " + paisDeOrigem + " ## " + idiomaDeOrigem + " ## " 
				+ emissoraDeTelevisaoOriginal + 
				" ## " + dataDeInicioDaTransmissaoOriginal + " ## " + numeroDeTemporadas + " ## " + numeroDeEpisodios);	
	}

	public static void main(String[] args) throws Exception {
		String[] n = ler().stream().toArray(String[]::new);
		Serie[] a = new Serie[n.length];
		BubbleSort bubbleSort = new BubbleSort();
		
		
		
		
		for(int i = 0; i < n.length; i++) {
			 a[i] = new Serie();
			 String[] r = n[i].split(";");
			 a[i].setNome(r[0]);
             a[i].setFormato(r[1]);
             a[i].setDuracao(r[2]);
             a[i].setPaisDeOrigem(r[3]);
             a[i].setIdiomaDeOrigem(r[4]);
             a[i].setEmissoraDeTelevisaoOriginal(r[5]);
             a[i].setDataDeInicioDaTransmissaoOriginal(r[6]);
             a[i].setNumeroDeTemporadas(Integer.parseInt(r[7]));
             a[i].setNumeroDeEpisodios(Integer.parseInt(r[8]));
				
		}
		
//		while(!linha.equals("FIM")) {
//			for(int i = 0; i < a.length; i++) {
//				if(linha.equals(a[i].nome)) {
//					fila.enfileirar((a[i]));
//				}
//				
//			}
//			linha = MyIO.readLine();
//		}
		
		int numFila = Integer.parseInt(MyIO.readLine());
		Serie[] b = new Serie[numFila];
		for(int i = 0; i < numFila; i++) {
			String serie = MyIO.readLine();
			
				for(int j = 0; j < a.length; j++) {
					if(serie.equals(a[j].nome)) {
						b[i] = new Serie();
						b[i] = a[j];
					}
						
				}
		}
		
		bubbleSort.bubbleSort(b);
		bubbleSort.printArray(b);
	}
}