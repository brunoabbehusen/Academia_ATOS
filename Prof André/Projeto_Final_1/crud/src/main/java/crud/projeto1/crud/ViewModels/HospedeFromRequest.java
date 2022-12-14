package crud.projeto1.crud.ViewModels;

public class HospedeFromRequest {

    private Integer id;

    private String nomeCompleto;

    private String placa;

    public HospedeFromRequest(String nomeCompleto, String placa) {
        this.nomeCompleto = nomeCompleto;
        this.placa = placa;
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

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
