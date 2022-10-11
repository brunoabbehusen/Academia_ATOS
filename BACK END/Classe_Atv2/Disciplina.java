package Classe_Atv2;

public class Disciplina {
    
    public static void main(String[] args) {

        Professor p = new Professor();
        Laboratorio lab = new Laboratorio();

        p.nome = "Lucas";
        lab.local = "Sala 2";

        System.out.println("O nome do professor é: " + p.nome);
        System.out.println("O local da aula é: " + lab.local);
    }
}
