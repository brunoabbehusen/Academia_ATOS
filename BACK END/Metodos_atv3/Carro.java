package Metodos_atv3;
public class Carro {
    String fabricante = "VW";
    String modelo = "Jetta";

    public void ligar(){
        System.out.println("Carro ligado!!");
    }

    public void desligar(){
        System.out.println("Carro desligado");
    }

    public void configuraDados(String fabricanteCarro, String modeloCarro){

        this.fabricante = fabricanteCarro;
        this.modelo = modeloCarro;
    }

    
    public void exibirDados(){

        System.out.println("Dados do carro: " + fabricante + " | " + modelo);
    }
}
