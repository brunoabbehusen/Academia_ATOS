package Herança.Atv1;

import java.util.Scanner;

public class Principal extends Usuario {
    
    public static void main(String[] args){

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um nome: ");
        String nome = leitura.nextLine();

        System.out.println("Digite o email: ");
        String email = leitura.nextLine();

        System.out.println("Digite o telefone: ");
        String telefone = leitura.nextLine();

        System.out.println("O nome digitado foi: " + nome);
        System.out.println("O email digitado foi: " + email);
        System.out.println("O telefone digitado foi: " + telefone);


        leitura.close();
    }
}
