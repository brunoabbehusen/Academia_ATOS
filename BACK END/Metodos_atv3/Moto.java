package Metodos_atv3;
public class Moto {
    
    String marca;
    String modelo;
    String cilindradas;

    public void atribuir_valor(String marcaMoto, String modeloMoto, String cinlindradasMoto) {

        marca = marcaMoto;
        modelo = modeloMoto;
        cilindradas = cinlindradasMoto;
    }

    public void retornar_valor() {
        System.out.println("Marca da moto: " + marca + " |" + "Modelo: " + modelo + " |" + "Cilindradas" + cilindradas);
        
    }
}
