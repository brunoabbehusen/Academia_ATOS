package Metodos_atv3;
import java.util.Scanner;

public class LocadoraVeiculos {
    
    public static void main(String[] args){

        Scanner leitura = new Scanner(System.in);

        Carro carro = new Carro();
        
        carro.configuraDados("VW", "Gol");

        //carro.exibirDados();

        Moto moto1 = new Moto();
        Moto moto2 = new Moto();

        System.out.println("Digite a fabricante do carro: ");
        carro.fabricante = leitura.nextLine();
        System.out.println("Digite o modelo do carro: ");
        carro.modelo = leitura.nextLine();

        System.out.println("Digite a marca da primeira moto: ");
        moto1.marca = leitura.nextLine();
        System.out.println("Digite o modelo da primeira moto: ");
        moto1.modelo = leitura.nextLine();
        System.out.println("Digite a cilindrada da primeira moto: ");
        moto1.cilindradas = leitura.nextLine();
        System.out.println("Digite a marca da segunda moto: ");
        moto2.marca = leitura.nextLine();
        System.out.println("Digite o modelo da segunda moto: ");
        moto2.modelo = leitura.nextLine();
        System.out.println("Digite a cilindrada da segunda moto: ");
        moto2.cilindradas = leitura.nextLine();

        leitura.close();

        System.out.println("Info Carro ");
        carro.exibirDados();
        System.out.println("Primeira moto ");
        moto1.retornar_valor();
        System.out.println("Segunda moto ");
        moto2.retornar_valor();
        
    }
}
