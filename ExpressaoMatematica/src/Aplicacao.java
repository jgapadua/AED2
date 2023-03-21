import java.lang.*;
import java.io.*;
 
class Aplicacao {

    static class Celula {

        private Character charr;
        private Celula proximo;

        Celula(Character charr) {
            this.charr = charr;
            this.proximo = null;
        }

        Celula() {
            this.charr = null;
            this.proximo = null;
        }

        public Character getPalavra() {
            return this.charr;
        }

        public void setPalavra(Character charr) {
            this.charr = charr;
        }

        public Celula getProximo() {
            return this.proximo;
        }

        public void setProximo(Celula proximo) {
            this.proximo = proximo;
        }
    }

    static class Pilha {

        private Celula fundo;
        private Celula topo;

        Pilha() {
            Celula sentinela;

            sentinela = new Celula();
            fundo = sentinela;
            topo = sentinela;
        }

        public boolean pilhaVazia() {

            boolean resp;

            resp = fundo == topo;

            return resp;
        }

        public void empilhar(Character charr) {

            Celula nova;

            nova = new Celula(charr);
            nova.setProximo(topo);
            topo = nova;
        }

        public Character desempilhar() throws Exception {

        	Character desempilhado;

            if (!pilhaVazia()) {
                desempilhado = topo.getPalavra();
                topo = topo.getProximo();
            } else
                throw new Exception("Não foi possível desempilhar: a pilha está vazia!");

            return desempilhado;
        }

        public Character consultarTopo() throws Exception {

        	Character top;

            if (!pilhaVazia()) {
                top = topo.getPalavra();
            } else
                throw new Exception("Não há char no topo da pilha: a pilha está vazia!");
            return top;
        }
    }
	
    private static boolean ehLetra(char c)
    {
        if (Character.isLetterOrDigit(c))
            return true;
        else
            return false;
    }
 
    static int getOrder(char ch)
    {
 
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }
 
    static String converterExpressao(String expressao) throws Exception
    {
        Pilha pilha = new Pilha();
 
        String result = new String("");
 
        for (int i = 0; i < expressao.length(); ++i) {
            char c = expressao.charAt(i);
 
            if (ehLetra(c))
                result += c + " ";
 
            else if (c == '(')
            	pilha.empilhar(c);
 
            else if (c == ')') {
                while (!pilha.pilhaVazia()
                       && pilha.consultarTopo() != '(')
                    result += pilha.desempilhar() + " ";
 
                pilha.desempilhar();
            }
 
            else {
                while (
                    !pilha.pilhaVazia()
                    && getOrder(c)
                           <= getOrder(pilha.consultarTopo())) {
 
                    result += pilha.desempilhar() + " ";
                }
                pilha.empilhar(c);
            }
        }
 
        while (!pilha.pilhaVazia()) {
            if (pilha.consultarTopo() == '(')
                return "Essa expressão é inválida";
            result += pilha.desempilhar() + " ";
        }
        return result;
    }
 
    public static void main(String[] args) throws Exception
    {
    	String expressao = MyIO.readLine().replaceAll("\\s","");
    	
    	while(!expressao.contains("FIM")) {
    		MyIO.println(converterExpressao(expressao));
    		expressao = MyIO.readLine().replaceAll("\\s","");
    	}
    	
    	
        
    }
}