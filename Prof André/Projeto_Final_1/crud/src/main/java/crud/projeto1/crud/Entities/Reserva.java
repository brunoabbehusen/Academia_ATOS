package crud.projeto1.crud.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "Reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Double valor_reserva; //Qnt diaria * R$ 45,00;

    @Transient
    Integer qnt_diarias;

    @Transient
    Double cama_valor;

    Double valor_total;

    @OneToMany (mappedBy = "reserva")
    Set<ItensConsumidos> itens_consumidos;

    @OneToOne
    @JoinColumn(name = "Hospede_Id", referencedColumnName = "id")
    Hospede hospede;

    public Reserva(){

    }
    public Reserva(Hospede hospede, Double cama_valor, Integer qnt_diarias) {

        this.cama_valor = cama_valor;
        this.qnt_diarias = qnt_diarias;
        this.hospede = hospede;
        this.valor_reserva = calc_valor_reserva();
        this.valor_total = this.valor_reserva;
    }

    public Double calc_valor_reserva(){

        return qnt_diarias * cama_valor;
    }

    public void calc_valor_total(){
        Double consumacao_total = 0.0;

        for (ItensConsumidos items : this.itens_consumidos){

            consumacao_total += items.getValor_total();
        }

        valor_total = valor_reserva + consumacao_total;
    }

    //GETTER and SETTER\\

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor_reserva() {
        return valor_reserva;
    }

    public void setValor_reserva(Double valor_reserva) {
        this.valor_reserva = valor_reserva;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Set<ItensConsumidos> getItens_consumidos() {
        return itens_consumidos;
    }

    public void setItens_consumidos(Set<ItensConsumidos> itens_consumidos) {
        this.itens_consumidos = itens_consumidos;
    }
}
