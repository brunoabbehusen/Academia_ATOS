package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="filmes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Filme {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="titulo", nullable = false)
    private String titulo;

    @Column(name="descricao", nullable = false)
    private String descricao;

    @Column(name="ano_lancamento")
    private int anoLancamento;

    @Column(name="duracao_aluguel")
    private int duracaoAluguel;

    @Column(name="custo_aluguel")
    private double custoAluguel;

    @Column(name="duracao")
    private int duracao;

    @Column(name="preco_reposicao")
    private double precoReposicao;

    @Column(name="classificacao")
    private String classificacao;

    @Column(name="conteudo_especial")
    private String conteudoEspecial;
}
