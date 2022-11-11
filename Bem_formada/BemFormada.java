import java.io.IOException;

public class BemFormada {

    static class Char {

        private char valor;

        Char(char valor) {
            this.valor = valor;
        }

        Char() {
            this.valor = '\u0000';
        }

        public char getValor() {
            return this.valor;
        }

        public void setValor(char valor) {
            this.valor = valor;
        }

        public void imprimir() {
            System.out.println(valor);
        }
    }

    static class Celula {

        private Char item;
        private Celula proximo;
        
        public Celula(Char novo) {
            item = novo;
            proximo = null;
        }
        
        public Celula() {
            
            item = new Char();
            proximo = null;
        }
        
        public Char getItem() {
            return item;
        }
        public void setItem(Char item) {
            this.item = item;
        }
        
        public Celula getProximo() {
            return proximo;
        }
        public void setProximo(Celula proximo) {
            this.proximo = proximo;
        }
    }

    static class Pilha {

        private Celula fundo;
        private Celula topo;

        public Pilha() {
		
            Celula sentinela;
            
            sentinela = new Celula();
            fundo = sentinela;
            topo = sentinela;
        }

        public boolean pilhaVazia() {

            if (fundo == topo)
			return true;
		else
			return false;
	}

        public void empilhar(Char novo) {

            Celula novaCelula;

            novaCelula = new Celula(novo);
            novaCelula.setProximo(topo);
            topo = novaCelula;
        }

        public Char desempilhar() throws Exception {

            Char desempilhado;

            if (!pilhaVazia()) {
                desempilhado = topo.getItem();
                topo = topo.getProximo();
                return desempilhado;
            } else
                throw new Exception("Não foi possível desempilhar: a pilha está vazia!");
        }

        public Char consultarTopo() throws Exception {

            if (!pilhaVazia()) {
                return(topo.getItem());
            } else
                throw new Exception("Não foi possível consultar o topo da pilha: a pilha está vazia!");
        }
    }

    public static void palavraBemFormada(String entrada) {
        Pilha pilha = new Pilha();
        boolean bemformada = true;
        char[] entradaCharArray = entrada.toCharArray();
        for (char c : entradaCharArray) {
            switch (c) {
                case '(':
                case '[':
                    try {
                        Char d = new Char(c);
                        pilha.empilhar(d);
                    } catch (Exception ignored) {
                    }
                    break;
                case ')':
                    try {
                        if (pilha.consultarTopo().getValor() != '(') {
                            bemformada = false;
                        } else
                            pilha.desempilhar();
                    } catch (Exception e) {
                        bemformada = false;
                    }
                    break;
                case ']':
                    try {
                        if (pilha.consultarTopo().getValor() != '[') {
                            bemformada = false;
                        } else pilha.desempilhar();
                    } catch (Exception e) {
                        bemformada = false;
                    }
                    break;
            }
        }
        if (pilha.pilhaVazia() && bemformada)
            System.out.println("correto");
        else
            System.out.println("incorreto");
    }

    public static void main(String[] args) throws IOException {
        String entrada;
        while (!(entrada = MyIO.readLine()).equals("FIM")) {
            palavraBemFormada(entrada);
        }
    }
}