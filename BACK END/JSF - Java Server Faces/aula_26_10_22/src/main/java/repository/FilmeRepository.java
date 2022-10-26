package repository;

import bean.FilmeBean;
import entity.Filme;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

public class FilmeRepository {

    public SessionFactory sessionFactory;

    public void setup() {
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://HOST:3306/locadora?useSSL=true");
        config.setProperty("hibernate.connection.username", "XPTO");
        config.setProperty("hibernate.connection.password", "XPTO");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.addAnnotatedClass(Filme.class);
        sessionFactory = config.buildSessionFactory();
    }

    public void close() {
        sessionFactory.close();
    }

    public List<Filme> buscarTodos() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Filme> listaFilmes = session.createQuery("from Filme", Filme.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return listaFilmes;
    }

    public int totalFilmes() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Filme> listaFilmes = session.createQuery("from Filme", Filme.class).getResultList();

        session.getTransaction().commit();
        session.close();
        int quantidade = listaFilmes.size();
        return quantidade;
    }

    public List<Filme> filtrarPorRange(int[] range) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query filmeQuery = session.createQuery("from Filme", Filme.class)
                                                .setMaxResults(range[1]-range[0])
                                                .setFirstResult(range[0]);
        List<Filme> listaFilmes = filmeQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return listaFilmes;
    }

    public String salvar(FilmeBean filmeBean) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Filme filme = new Filme();
        filme.setId(filmeBean.getId());
        filme.setTitulo(filmeBean.getTitulo());
        filme.setDescricao(filmeBean.getDescricao());
        filme.setAnoLancamento(filmeBean.getAnoLancamento());
        filme.setDuracaoAluguel(filmeBean.getDuracaoAluguel());
        filme.setCustoAluguel(filmeBean.getCustoAluguel());
        filme.setDuracao(filmeBean.getDuracao());
        filme.setPrecoReposicao(filmeBean.getPrecoReposicao());
        filme.setClassificacao(filmeBean.getClassificacao());
        String conteudoEspecial = String.join(",", filmeBean.getConteudoEspecial());
        filme.setConteudoEspecial(conteudoEspecial);
        session.save(filme);
        session.close();

        return "/filmes.xhtml?faces-redirect=true";
    }

    public String editar(int id) {
        FilmeBean filmeBean = new FilmeBean(); ;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        Filme filme = session.find(Filme.class, id);
        session.getTransaction().commit();

        filmeBean.setId(filme.getId());
        filmeBean.setTitulo(filme.getTitulo());
        filmeBean.setDescricao(filme.getDescricao());
        filmeBean.setAnoLancamento(filme.getAnoLancamento());
        filmeBean.setDuracaoAluguel(filme.getDuracaoAluguel());
        filmeBean.setCustoAluguel(filme.getCustoAluguel());
        filmeBean.setDuracao(filme.getDuracao());
        filmeBean.setPrecoReposicao(filme.getPrecoReposicao());
        filmeBean.setClassificacao(filme.getClassificacao());

        String[] conteudoEspecial = filme.getConteudoEspecial().split(",");
        filmeBean.setConteudoEspecial(conteudoEspecial);

        session.close();
        sessionMap.put("filmeMap", filmeBean);
        return "/editarFilme.xhtml?faces-redirect=true";
    }

    public String atualizar(FilmeBean filmeBean) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Filme filme = new Filme();
        filme.setId(filmeBean.getId());
        filme.setTitulo(filmeBean.getTitulo());
        filme.setDescricao(filmeBean.getDescricao());
        filme.setAnoLancamento(filmeBean.getAnoLancamento());
        filme.setDuracaoAluguel(filmeBean.getDuracaoAluguel());
        filme.setCustoAluguel(filmeBean.getCustoAluguel());
        filme.setDuracao(filmeBean.getDuracao());
        filme.setPrecoReposicao(filmeBean.getPrecoReposicao());
        filme.setClassificacao(filmeBean.getClassificacao());
        String conteudoEspecial = String.join(",", filmeBean.getConteudoEspecial());
        filme.setConteudoEspecial(conteudoEspecial);
        session.update(filme);
        session.getTransaction().commit();
        session.close();
        return "/filmes.xhtml?faces-redirect=true";
    }

    public String deletar(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Filme filme = session.find(Filme.class, id);
        session.delete(filme);
        session.getTransaction().commit();
        session.close();
        return "/filmes.xhtml?faces-redirect=true";
    }
}
