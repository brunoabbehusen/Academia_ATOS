package crud.projeto1.crud.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Hospedes")
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_completo")
    private String Nome_Completo;

    @OneToOne(mappedBy = "hospede")
    Veiculo veiculo;

    public Hospede(){

    }
    public Hospede(String nome){

        this.Nome_Completo = nome;
    }

    public Hospede(String nome, int id){
        this.id = id;
        this.Nome_Completo = nome;
    }

    public Hospede(String nome, Veiculo veiculo){

        this.Nome_Completo = nome;
        this.veiculo = veiculo;
    }

    //GETTER and SETTER\\

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_Completo() {
        return Nome_Completo;
    }

    public void setNome_Completo(String nome_Completo) {
        Nome_Completo = nome_Completo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    //Info ou Logging - Metodo JAVA
    public String toString() {

        return "idHospede = " + id + " Nome_Completo = " + Nome_Completo;
    }
}
