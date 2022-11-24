package crud.projeto1.crud.ViewModels;

public class ConsumacaoFromRequest {

    Integer id_item;

    Integer quantidade;


    public ConsumacaoFromRequest(Integer id_item, Integer quantidade){
        this.id_item = id_item;
        this.quantidade = quantidade;
    }

    public ConsumacaoFromRequest(){

    }

                                             //G and S//
    public Integer getId_item() {
        return id_item;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
