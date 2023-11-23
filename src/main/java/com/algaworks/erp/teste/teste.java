package com.algaworks.erp.teste;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.RamoAtividade;
import com.algaworks.erp.model.TipoEmpresa;
import com.algaworks.erp.repository.Empresas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class teste {


    public static void main(String[] args) {

        Empresa empresa = new Empresa();
        RamoAtividade ramoAtividade = new RamoAtividade();




        // Convertendo a String para um objeto Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateFundacao = dateFormat.parse("10/01/2023");
            empresa.setDateFundacao(dateFundacao);
        } catch (ParseException e) {
            e.printStackTrace(); // Lida com a exceção ou imprime para depuração
        }

        empresa.setId(null);
        empresa.setCnpj("11.111.111/1111-11");
        empresa.setRazaoSocial("Teste");
        empresa.setNomeFantasia("Teste");
        empresa.setTipo(TipoEmpresa.EIRELI);
        ramoAtividade.setId(1);
        empresa.setRamoAtividade(ramoAtividade);

        Empresas empresas = new Empresas();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(empresa);
        em.getTransaction().commit();
    }


    }



