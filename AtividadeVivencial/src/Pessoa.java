public class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa(String nome, int idade, String descricao) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    @Override
    public String toString() {
        return "Pessoa [Nome=" + nome + ", Idade=" + idade + "]";
    }
}
