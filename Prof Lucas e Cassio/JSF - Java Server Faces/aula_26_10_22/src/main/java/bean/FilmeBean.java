package bean;

import entity.Filme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import repository.FilmeRepository;
import resources.PaginationHelper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.List;

@ManagedBean(name="filmeBean")
@RequestScoped
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmeBean {

    FilmeRepository filmeRepository = new FilmeRepository();

    private int id;
    private String titulo;
    private String descricao;
    private int anoLancamento;
    private int duracaoAluguel;
    private double custoAluguel;
    private int duracao;
    private double precoReposicao;
    private String classificacao;
    private String[] conteudoEspecial;

    public List<Filme> listaFilmes;
    public int totalFilmes;

    //Métodos para paginação
    private PaginationHelper paginationHelper;
    private int selectedItemIndex;
    private DataModel dataModel = null;

    @PostConstruct
    public void init() {
        filmeRepository.setup();
        listaFilmes = filmeRepository.buscarTodos();
        this.getPagination();
    }

    public String precoMedioLocacao() {
        double valorTotalFilmes = 0;
        if(listaFilmes.size() > 0) {
            for(Filme filme : listaFilmes) {
                valorTotalFilmes += filme.getCustoAluguel();
            }
            return String.format("%.2f", (valorTotalFilmes/totalFilmes));
        } else {
            return "0";
        }
    }

    public int totalDeFilmes() {
        totalFilmes = listaFilmes.size();
        return totalFilmes;
    }

    public String salvar(FilmeBean filmeBean) {
        return filmeRepository.salvar(filmeBean);
    }

    public String editar(int id) {
        return filmeRepository.editar(id);
    }

    public String atualizar(FilmeBean filmeBean) {
        return filmeRepository.atualizar(filmeBean);
    }

    public String deletar(int id) {
        return filmeRepository.deletar(id);
    }

    //Métodos do pagination helper
    public PaginationHelper getPagination() {
        if(paginationHelper == null) {
            paginationHelper = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return filmeRepository.totalFilmes();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(filmeRepository.filtrarPorRange(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return paginationHelper;
    }

    public DataModel getDataModel() {
        if(dataModel == null) {
            dataModel = getPagination().createPageDataModel();
        }
        return dataModel;
    }

    private void recreateModel() {
        dataModel = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "filmes.xhtml";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "filmes.xhtml";
    }

}

