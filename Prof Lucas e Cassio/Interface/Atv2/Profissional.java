package Interface.Atv2;

public interface Profissional {
    
    public static void exibeCompromissoProfissional(){

        Compromisso comp = new Compromisso();

        System.out.println("O nome é: " + comp.nome);
        System.out.println("A data é: " + comp.data);
        System.out.println("O horário é: " + comp.hora);
    }
}
