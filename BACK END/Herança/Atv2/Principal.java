package Herança.Atv2;

public class Principal extends Pessoa {
    
    public static void main(String[] args){

        System.out.println("O tipo do animal é: " + tipo);

        System.out.println(andar());

        System.out.println("O nome é " + nome + " e a idade é " + idade);
        
        System.out.println(falar());
    }
}
