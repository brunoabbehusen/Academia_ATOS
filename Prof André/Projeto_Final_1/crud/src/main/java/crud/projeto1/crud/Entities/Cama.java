package crud.projeto1.crud.Entities;


import javax.persistence.*;

@Entity
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

    public Cama(){

    }
    public Cama(Integer id, Double valor, String tipo) {

        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
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
}
