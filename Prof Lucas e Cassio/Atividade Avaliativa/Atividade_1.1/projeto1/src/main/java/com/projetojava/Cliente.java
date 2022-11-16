package com.projetojava;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "Nome")
    private String nome;

    @Column (name = "Sobrenome")
    private String sobrenome;
    
    @Column (name = "Convidados")
    private Integer convidados = 0;

    @Column (name = "Sobremesa")
    public Boolean sobremesa;

    @OneToOne
    @JoinColumn (name = "OrcamentoId")
    public Orcamento orcamento;

    public Cliente(String nome, String sobrenome, Integer convidados, Boolean temSobremesa){

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.convidados = convidados;
        this.sobremesa = temSobremesa;

        this.orcamento = new Orcamento(convidados, temSobremesa);
    }

    public Cliente() {
    }

    public Double valorOrcamento(){
        return this.orcamento.valorTotal();
    }

    
    //GETTER & SETTER

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public Integer getConvidados(){
        return convidados;
    }

    public void setConvidados(Integer convidados){
        this.convidados = convidados;
    }

    public Boolean getSobremesa(){
        return sobremesa;
    }

    public void setSobremesa(Boolean sobremesa){
        this.sobremesa = sobremesa;
    }
}
