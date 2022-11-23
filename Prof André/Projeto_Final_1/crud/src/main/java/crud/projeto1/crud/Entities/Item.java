package crud.projeto1.crud.Entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Double valor;

    //consumacao = Quais reservas consomem este item
    @OneToMany (mappedBy = "item")
    @JsonIgnore
    Set<ItensConsumidos> consumacao;


    public Item(){

    }
    public Item(String nome, Double valor) {
        this.nome = nome;
        this.valor= valor;
    }

    //GETTER and SETTER\\

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Set<ItensConsumidos> getConsumacao() {
        return consumacao;
    }

    public void setConsumacao(Set<ItensConsumidos> consumacao) {
        this.consumacao = consumacao;
    }
}
