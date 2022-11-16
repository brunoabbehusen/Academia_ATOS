package com.projetojava;

import java.text.DecimalFormat;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetorestaurante");
        EntityManager em = emf.createEntityManager();
        
        Cliente cliente = new Cliente();

        DecimalFormat df = new DecimalFormat("#.00");

        Scanner leitor = new Scanner(System.in);

        System.out.println("\n=========THE BIG COFFE=========\n");
        
        System.out.println("\nPreencha as informacoes abaixo para gerar um orçamento do buffet:\n");

        System.out.println("Digite o nome do cliente:");
        String nome = leitor.next();
        cliente.setNome(nome);
        
        System.out.println("\nDigite o sobrenome do cliente:");
        String sobrenome = leitor.next();
        cliente.setSobrenome(sobrenome);

        System.out.println("\nQuantos convidados haverao no evento?:");
        Integer convidados = leitor.nextInt();
        cliente.setConvidados(convidados);

        System.out.println("Havera sobremesa?\nNAO - 0\nSIM - 1");
        Integer temSobremesaInt = leitor.nextInt();
        
        
        if (temSobremesaInt != 1 && temSobremesaInt != 0){
            System.out.println("Valor digitado nao confere");
            leitor.close();
            return;
        }

        Boolean temSobremesa = temSobremesaInt != 0;
        cliente.setSobremesa(temSobremesa);

        
        cliente = new Cliente(nome, sobrenome, convidados, temSobremesa);
        
        System.out.println("\nNome: " + cliente.getNome());

        System.out.println("\nSobrenome: " + cliente.getSobrenome());

        System.out.println("\nO valor total a ser pago é de: R$ " + cliente.valorOrcamento());
        
        System.out.println("\nValor total por convidado: R$ " + df.format(cliente.orcamento.totalPorConvidado));
        
        System.out.println("\nValor total dos convidados: R$ " + df.format(cliente.orcamento.totalConvidados));

        System.out.println("\nTaxa de sobremesa: " + Orcamento.TAXA_SOBREMESA * 100 + "%");

        System.out.println("\nQuantidade de garcons: " + cliente.orcamento.qntGarcons);

        System.out.println("\nTaxa por garcom: R$ " + Orcamento.TAXA_POR_GARCOM + "\n");
        
        leitor.close();

        System.out.println("STATUS 200");

        //Transação com o banco
        em.getTransaction().begin();

        em.persist(cliente.getNome());
        em.persist(cliente.getSobrenome());
        em.persist(cliente.getConvidados());
        em.persist(cliente.getSobremesa());
        
        em.getTransaction().commit();

        em.close();
        emf.close();

        
    }
}