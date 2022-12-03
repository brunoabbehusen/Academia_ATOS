package crud.projeto1.crud.Entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table (name = "Camas")
public class Cama {

    @Id
    Integer id;

    @Column(name = "Valor")
    Double valor;

    @Column(name = "Tipo")
    String tipo;

    @OneToOne
    @JoinColumn(name = "Reserva_Id", referencedColumnName = "id")
    Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "Quarto_Id", referencedColumnName = "id")
    private Quarto quarto;

    public Cama(){

    }
    public Cama(Integer id, Double valor, String tipo, Quarto quarto) {

        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.quarto = quarto;
    }


    //GETTER and SETTER\\
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
