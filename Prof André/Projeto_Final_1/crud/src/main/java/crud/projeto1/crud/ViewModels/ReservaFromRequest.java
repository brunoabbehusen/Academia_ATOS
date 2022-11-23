package crud.projeto1.crud.ViewModels;

public class ReservaFromRequest {

    Integer id_hospede;

    String tipo_cama;

    Integer qnt_diarias;

        //GT and ST\\
    public Integer getId_hospede() {
        return id_hospede;
    }

    public void setId_hospede(Integer id_hospede) {
        this.id_hospede = id_hospede;
    }

    public String getTipo_cama() {
        return tipo_cama;
    }

    public void setTipo_cama(String tipo_cama) {
        this.tipo_cama = tipo_cama;
    }

    public Integer getQnt_diarias() {
        return qnt_diarias;
    }

    public void setQnt_diarias(Integer qnt_diarias) {
        this.qnt_diarias = qnt_diarias;
    }
}
