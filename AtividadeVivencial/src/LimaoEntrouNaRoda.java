public class LimaoEntrouNaRoda {
    private Node inicio;
    private int quantidadeElementos;
    
    private class Node {
        private Pessoa pessoa;
        private Node proximo;
        
        public Node(Pessoa pessoa) {
            this.pessoa = pessoa;
            this.proximo = null;
        }
        
        public Pessoa getPessoa() {
            return pessoa;
        }
        
        public Node getProximo() {
            return proximo;
        }
        
        public void setProximo(Node proximo) {
            this.proximo = proximo;
        }
    }
    
    public LimaoEntrouNaRoda(int quantidadePessoas) {
        inicio = null;
        quantidadeElementos = 0;
        
        if (quantidadePessoas > 0) {
            Pessoa pessoa1 = new Pessoa("Pessoa 1", 1, null);
            inicio = new Node(pessoa1);
            quantidadeElementos++;
            
            Node aux = inicio;
            for (int i = 2; i <= quantidadePessoas; i++) {
                Pessoa pessoa = new Pessoa("Pessoa " + i, i, null);
                Node novoNode = new Node(pessoa);
                aux.setProximo(novoNode);
                aux = novoNode;
                quantidadeElementos++;
            }
            
            aux.setProximo(inicio); // Encadeando o último nó com o início para formar uma roda circular
        }
    }
    
    public int getQuantidadePessoas() {
        return quantidadeElementos;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node aux = inicio;
        
        do {
            sb.append(aux.getPessoa().toString()).append("\n");
            aux = aux.getProximo();
        } while (aux != inicio);
        
        return sb.toString();
    }

    public int passaObjeto(int vezes) {
        if (inicio == null || vezes <= 0) {
            return -1; // Retorna -1 para indicar que não foi possível passar o objeto
        }
        
        Node atual = inicio;
        
        for (int i = 0; i < vezes; i++) {
            atual = atual.getProximo();
        }
        
        return encontrarPosicao(atual);
    }
    
    private int encontrarPosicao(Node no) {
        int posicao = 0;
        Node aux = inicio;
        
        while (aux != no) {
            aux = aux.getProximo();
            posicao++;
        }
        
        return posicao;
    }

    public Pessoa removePosicao(int posicao) {
        if (inicio == null || posicao < 0 || posicao >= quantidadeElementos) {
            return null; // Retorna null se a posição for inválida ou se a roda estiver vazia
        }
        
        Node removido;
        
        if (posicao == 0) {
            removido = inicio;
            inicio = inicio.getProximo();
            
            // Caso a roda possua apenas uma pessoa, retorna essa pessoa
            if (quantidadeElementos == 1) {
                quantidadeElementos--;
                inicio = null;
                return removido.getPessoa();
            }
            
            // Encontra o último nó da roda
            Node ultimo = encontrarNo(quantidadeElementos - 1);
            
            // Atualiza a referência do último nó para o novo início
            ultimo.setProximo(inicio);
        } else {
            Node anterior = encontrarNo(posicao - 1);
            removido = anterior.getProximo();
            anterior.setProximo(removido.getProximo());
        }
        
        quantidadeElementos--;
        return removido.getPessoa();
    }
    
    
    private Node encontrarNo(int posicao) {
        Node aux = inicio;
        
        for (int i = 0; i < posicao; i++) {
            aux = aux.getProximo();
        }
        
        return aux;
    }
    
    
}