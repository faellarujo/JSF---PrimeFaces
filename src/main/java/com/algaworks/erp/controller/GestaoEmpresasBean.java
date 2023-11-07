package com.algaworks.erp.controller;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.repository.Empresas;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {


    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;


    private List<Empresa> listaEmpresas;

    public void todasEmpresas() {
       listaEmpresas = empresas.todas();
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }



}
