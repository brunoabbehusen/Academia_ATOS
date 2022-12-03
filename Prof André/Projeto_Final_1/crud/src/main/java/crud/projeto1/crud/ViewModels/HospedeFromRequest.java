package crud.projeto1.crud.ViewModels;

import crud.projeto1.crud.Entities.Veiculo;

public class HospedeFromRequest {

    private Integer id;

    private String Nome_Completo;

    private String placa;

    public HospedeFromRequest(String nome_completo, String placa) {
    }

    public HospedeFromRequest(){
    }

    //GT and ST\\


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_Completo() {
        return Nome_Completo;
    }

    public void setNome_Completo(String nome_Completo) {
        Nome_Completo = nome_Completo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
