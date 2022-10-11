package Herança.Atv2;

public class SerHumano extends Animal{
    
    protected static String nome = "Roger";
    protected static Integer idade = 40;
    
    protected static String falar(){

        return "Nem todos falam";
    }

    public static void main(String[] args){

        System.out.println("O tipo do animal é: " + tipo);

        System.out.println(andar());
    }
}
