package Interface.Atv1;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite uma mensagem para preservação do meio ambiente: ");
        Mensagem.texto = leitor.nextLine();

        System.out.println("Mensagem A:");
        Mensagem.exibemensagemA();
        
        System.out.println("\nMensagem B:");
        Mensagem.exibemensagemB();

        leitor.close();
    }
}
