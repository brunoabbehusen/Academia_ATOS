package Interface.Atv2;

public class Pessoal extends Compromisso {
    
    public static void exibeCompromissoPessoal() {

        Compromisso comp = new Compromisso();

        System.out.println("O nome é: " + comp.nome);
        System.out.println("A data é: " + comp.data);
        System.out.println("O horário é: " + comp.hora);
    }
}
