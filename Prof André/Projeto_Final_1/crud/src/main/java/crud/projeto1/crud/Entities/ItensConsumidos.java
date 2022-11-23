package crud.projeto1.crud.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ItensConsumidos {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="reserva_id")
    Reserva reserva;

    @ManyToOne
    @JoinColumn(name="item_id")
    Item item;

    Integer quantidade;

    Double valor_total;

    public ItensConsumidos(){
        this.quantidade = 0;
    }

    public ItensConsumidos(Reserva reserva, Item item, Integer quantidade) {
        this.reserva = reserva;
        this.item = item;
        this.quantidade = quantidade;
        this.valor_total = this.calc_valor_total();
    }

    public Double calc_valor_total(){

         return this.item.getValor() * this.quantidade;
    }

    //G and T\\
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        this.valor_total = this.calc_valor_total();
    }
}
