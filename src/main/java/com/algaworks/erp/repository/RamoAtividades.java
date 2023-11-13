package com.algaworks.erp.repository;

import com.algaworks.erp.model.RamoAtividade;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class RamoAtividades implements Serializable {

    private static final long serialVersionUID = 1L;



    private EntityManager manager;

    public RamoAtividades() {

    }

    public RamoAtividades(EntityManager manager) {
        this.manager = manager;
    }

    public List<RamoAtividade> pesquisar(String descricao) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");

        EntityManager manager = emf.createEntityManager();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);
        Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));
        TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
