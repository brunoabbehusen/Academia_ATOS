package crud.projeto1.crud.ViewModels;

import crud.projeto1.crud.Entities.Cama;

public class CamaToResponse {


    private Integer id;

    private Double valor;

    private String tipo;

    private Integer quarto_id;

    private Integer reserva_id;

    public CamaToResponse(Integer id, Double valor, String tipo, Integer quarto_id, Integer reserva_id) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.quarto_id = quarto_id;
        this.reserva_id = reserva_id;
    }

    public static CamaToResponse mapCamaToCamaList(Cama cama){

        Integer reserva_id = null;

        Integer quarto_id = null;

        if(cama.getQuarto() != null){

            quarto_id = cama.getQuarto().getId();
        }

        if(cama.getReserva() != null){

            quarto_id = cama.getReserva().getId();
        }

        return new CamaToResponse(cama.getId(), cama.getValor(), cama.getTipo(), quarto_id, reserva_id);
    }


    //GT\\

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

    public Integer getQuarto_id() {
        return quarto_id;
    }

    public void setQuarto_id(Integer quarto_id) {
        this.quarto_id = quarto_id;
    }

    public Integer getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(Integer reserva_id) {
        this.reserva_id = reserva_id;
    }
}
