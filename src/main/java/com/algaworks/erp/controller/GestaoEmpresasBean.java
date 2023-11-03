package com.algaworks.erp.controller;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;


@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private int numero = 0;


    private Empresa empresa = new Empresa();


    private TipoEmpresa tipoEmpresa;

    public TipoEmpresa[] getTipoEmpresa() {
        return TipoEmpresa.values();
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    private GestaoEmpresasBean(){
        numero++;
    }

    public int getNumero() {
        return numero;
    }

    public String ajuda(){
        return "Ajuda";
    }


    public void salvar(){
        System.out.println("Razao Social: " + empresa.getRazaoSocial()
        + "  - Nome Fantasia: " + empresa.getNomeFantasia()
        + "  - Tipo Empresa:  " + empresa.getTipo());
    }


}
