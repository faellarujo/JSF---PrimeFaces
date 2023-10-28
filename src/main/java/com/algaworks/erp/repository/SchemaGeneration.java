package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class SchemaGeneration {




    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");

        EntityManager em = emf.createEntityManager();

        List<Empresa> lista = em.createQuery("from Empresa", Empresa.class).getResultList();
        //ery(Empresa, Empresa.class).getResultList();


        System.out.println("Lista de Empresas: " + lista);

        em.close();
        emf.close();
    }
}
