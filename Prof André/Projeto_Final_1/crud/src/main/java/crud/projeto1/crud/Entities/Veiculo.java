package crud.projeto1.crud.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String placa;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "Hospede_Id", referencedColumnName = "id")
    Hospede hospede;

    public Veiculo(Integer id, String placa) {

        this.id = id;
        this.placa = placa;
    }

    public Veiculo(){
    }

    public Veiculo(String placa, Hospede hospede) {

        this.placa = placa;
        this.hospede = hospede;
    }

    //GT-ST\\

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
}
