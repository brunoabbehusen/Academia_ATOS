package Classe_Atv1;
public class Principal {
    

    public static void main(String[] args) {

        Pessoa p = new Pessoa();
        p.idade = 10;
        
        System.out.println("O nome da pessoa é: " + p.nome);
        System.out.println("A idadade de " + p.nome + " é: " + p.idade + "\n");

        Pessoa s = new Pessoa();
        s.idade = 12;
        s.nome = "Carlos";
        System.out.println("O nome da pessoa é: " + s.nome);
        System.out.println("A idade de " + s.nome + " é: " + s.idade + "\n");

        Pessoa x = new Pessoa();
        x.idade = 25;
        x.nome = "José";
        System.out.println("O nome da pessoa é: " + x.nome);
        System.out.println("A idade de " + x.nome + " é: " + x.idade + "\n");

        Pessoa y = new Pessoa();
        y.nome = "Bianca";
        y.idade = 44;
        System.out.println("O nome da pessoa é: " + y.nome);
        System.out.println("A idade de " + y.nome + " é: " + y.idade + "\n");
    }
}
