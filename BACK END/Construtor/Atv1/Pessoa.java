package Construtor.Atv1;

import java.util.Scanner;

public class Pessoa {

    public static String name;
    public static  Integer age;
    
    public Pessoa(String nome, Integer idade){
        Pessoa.name = nome;
        Pessoa.age = idade;
    }

    public Pessoa(Integer idade){
        Pessoa.age = idade;
    }

    public static void exibeDados1(){

        System.out.println("O nome da pessoa é: " + name);
        System.out.println("A ideiade da pessoa é: " + age);
    }

    public static void exibeDados2(){

        System.out.println("A idade da pessoa é: " + age);
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Prezado(a), informe qual construtor você gostaria de utilizar:\n");
        System.out.println("1 - Será necessário informar o nome e a idade");
        System.out.println("2 - Será necessário informar a idade\n");
        System.out.println("Escolha a sua opção! ");
        Integer i = input.nextInt();

        if (i == 1){

            System.out.println("Digite a idade: ");
            Pessoa.age = input.nextInt();

            System.out.println("Digite o nome: ");
            Pessoa.name = input.next();

            System.out.println("Você escolheu a primeira opção!\n");
            exibeDados1();

        } else if (i == 2){

            System.out.println("Digite a idade: ");
            Pessoa.age = input.nextInt();

            System.out.println("Você escolheu a segunda opção!\n");
            exibeDados2();

        } else{

            System.out.println("Opção invalida");
        }

        input.close();
    }
}
