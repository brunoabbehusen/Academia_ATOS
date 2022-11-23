package crud.projeto1.crud.ViewModels;

import crud.projeto1.crud.Entities.Reserva;

public class ReservaCamaId {

    Reserva reserva;

    Integer cama_id;

    public ReservaCamaId() {

    }

    public ReservaCamaId(Reserva reserva, Integer cama_id) {

        this.cama_id = cama_id;
        this.reserva = reserva;
    }
                                        //GETTER and SETTER\\

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Integer getCama_id() {
        return cama_id;
    }

    public void setCama_id(Integer cama_id) {
        this.cama_id = cama_id;
    }
}
