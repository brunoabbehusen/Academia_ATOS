package crud.projeto1.crud.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "Quartos")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome_quarto;

    @OneToMany(mappedBy ="quarto")
    private Set<Cama> camas;


    public Quarto() {

    }

    public Quarto(Integer id, String nome_quarto){

        this.id = id;
        this.nome_quarto = nome_quarto;
    }


    //GETTER and SETTER\\
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_quarto() {
        return nome_quarto;
    }

    public void setNome_quarto(String nome_quarto) {
        this.nome_quarto = nome_quarto;
    }

    public Set<Cama> getCamas() {
        return camas;
    }

    public void setCamas(Set<Cama> camas) {
        this.camas = camas;
    }
}
