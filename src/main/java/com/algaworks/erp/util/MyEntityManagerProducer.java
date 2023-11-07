package com.algaworks.erp.util;


import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class MyEntityManagerProducer {

    @PersistenceContext(unitName = "AlgaWorksPU")
    private EntityManager entityManager;

    @Produces
    public EntityManager entityManager(){
        return entityManager;
    }

}

