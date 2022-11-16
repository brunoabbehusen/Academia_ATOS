package com.projetojava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orcamento")
public class Orcamento{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    Integer convidados;

    Boolean temSobremesa;

    public Double totalConvidados;

    public Double totalPorConvidado;

    public Integer qntGarcons;

    public Double taxaGarcons;

    public static final Double TAXA_SOBREMESA = 0.10;

    public static final Double TAXA_POR_GARCOM = 250.00;

    private static final Double VALOR_DO_PRATO_QUENTE = 22.90;

    private static final Integer MAX_CONVIDADO_POR_GARCOM = 15;
    
    public Orcamento(Integer convidados, Boolean temSobremesa){
        
        this.convidados = convidados;

        this.temSobremesa = temSobremesa;

        this.totalPorConvidado = Orcamento.VALOR_DO_PRATO_QUENTE;
        
        if(temSobremesa == true){
            totalPorConvidado += totalPorConvidado * Orcamento.TAXA_SOBREMESA;
        }

        this.totalConvidados = convidados * totalPorConvidado;


        this.qntGarcons = convidados / Orcamento.MAX_CONVIDADO_POR_GARCOM;
        
        if (convidados % Orcamento.MAX_CONVIDADO_POR_GARCOM != 0){
            this.qntGarcons++;
        }

        this.taxaGarcons = this.qntGarcons * Orcamento.TAXA_POR_GARCOM;
    }
    
    public Double valorTotal(){
        
        Double total;

        // 15 = 1
        // 16 = 2

        total = this.totalConvidados + this.taxaGarcons;

        return total;
    }
    
}


