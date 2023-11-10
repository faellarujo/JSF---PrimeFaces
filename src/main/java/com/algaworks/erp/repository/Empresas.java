package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.*;
import org.hibernate.sql.Select;

import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class Empresas implements Serializable {


    private static final long serialVersionUID = 1L;


    @PersistenceContext(unitName = "AlgaWorksPU")
    private EntityManager manager;

    public Empresas(){
    }

    public Empresas(EntityManager manager) {
        this.manager = manager;
    }

    public EntityManager getManager() {
        return manager;
    }


    public Empresa porId(Long id){
        return manager.find(Empresa.class, id);
    }


    public List<Empresa> pesquisar(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");

        EntityManager em = emf.createEntityManager();

        String jpql = "select e from Empresa e where razaoSocial like :razaoSocial";

        TypedQuery<Empresa> query = em
                .createQuery(jpql, Empresa.class);

        query.setParameter("razaoSocial",  "%" + nome + "%");

        return query.getResultList();
    }

    public List<Empresa> todas() {

        /*return manager.createQuery("select e from Empresa e", Empresa.class).getResultList();*/

        /*String queryString = "from Empresa";
        TypedQuery<Empresa> query = (TypedQuery<Empresa>) manager.createQuery(queryString, Empresa.class).getResultList();
        return query.getResultList();
*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");

        EntityManager em = emf.createEntityManager();

        List<Empresa> lista = em.createQuery("from Empresa", Empresa.class).getResultList();

        return lista;
    }


    public Empresa guardar(Empresa empresa) {
        return manager.merge(empresa);
    }

    public void remover(Empresa empresa) {
        empresa = porId(empresa.getId());
        manager.remove(empresa);
    }

}
