package Herança.Atv3;
import java.math.BigInteger;
import java.util.Scanner;

public class Executavel extends Funcionario {
    

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        

        System.out.println("Olá!");
        System.out.println("Digite o nome do(a) funcionario(a): ");
        String nome = leitura.nextLine();

        System.out.println("Digite a idade do(a) funcionario(a): ");
        Integer idade = leitura.nextInt();

        System.out.println("Digite o telefone do(a) funcionario(a): ");
        BigInteger telefone = leitura.nextBigInteger();

        System.out.println("\nDados pessoais cadastrados com sucesso!!\n");
        leitura.nextLine();
        
        System.out.println("Agora digite o setor do(a) funcionario(a): ");
        String setor = leitura.nextLine();

        System.out.println("Digite o cargo do(a) funcionario(a): ");
        String cargo = leitura.nextLine();

        System.out.println("Digite a função do(a) funcionario(a): ");
        String função = leitura.nextLine();

        System.out.println("Todos os dados foram preechindos com sucesso, confira abaixo:\n");

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Telefone: " + telefone);
        System.out.println("Setor: " + setor);
        System.out.println("Cargo: " + cargo);
        System.out.println("Função: " + função);

        leitura.close();
    }
}
