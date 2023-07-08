import java.util.Random;
import java.util.Scanner;

public class PrincipalLimao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de pessoas na roda: ");
        int quantidadePessoas = scanner.nextInt();
        
        // Criando a roda com a quantidade de pessoas escolhida pelo usuário
        LimaoEntrouNaRoda roda = new LimaoEntrouNaRoda(quantidadePessoas);
        System.out.println("Roda inicial:");
        System.out.println(roda);
        
        Random random = new Random();
        int numeroVoltas = random.nextInt(quantidadePessoas) + 1; // Gerando um número aleatório de voltas (entre 1 e a quantidade de pessoas)
        System.out.println("Número de voltas: " + numeroVoltas);
        
        int posicaoFinal = roda.passaObjeto(numeroVoltas);
        
        Pessoa pessoaRemovida = null;
        while (roda.getQuantidadePessoas() > 1) {
            pessoaRemovida = roda.removePosicao(posicaoFinal);
            if (pessoaRemovida != null) {
                System.out.println("Pessoa removida: " + pessoaRemovida);
            } else {
                System.out.println("Não foi possível remover a posição.");
            }
            
            if (roda.getQuantidadePessoas() > 1) {
                posicaoFinal = roda.passaObjeto(numeroVoltas);
                System.out.println("Objeto parou na posição: " + posicaoFinal);
            }
        }
        
        System.out.println("O ganhador é: " + roda);
    }
}
