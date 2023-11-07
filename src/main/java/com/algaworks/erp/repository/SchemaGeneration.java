package com.algaworks.erp.repository;

import com.algaworks.erp.controller.GestaoEmpresasBean;
import com.algaworks.erp.model.Empresa;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class SchemaGeneration {





    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");

        EntityManager em = emf.createEntityManager();

        List<Empresa> lista = em.createQuery("from Empresa", Empresa.class).getResultList();

        lista.stream().forEach(empresa -> System.out.println(empresa.getNomeFantasia()));

        System.out.println(lista);


        GestaoEmpresasBean gestaoEmpresasBean = new GestaoEmpresasBean();

        List<Empresa> empresaslist = new ArrayList<>();

        gestaoEmpresasBean.getListaEmpresas();



        em.close();
        emf.close();
    }
}
