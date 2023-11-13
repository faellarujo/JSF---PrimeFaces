package com.algaworks.erp.controller;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.RamoAtividade;
import com.algaworks.erp.model.TipoEmpresa;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.repository.RamoAtividades;
import com.algaworks.erp.util.FacesMessages;
import jakarta.faces.convert.Converter;
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

    @Inject
    private FacesMessages messages;

    @Inject
    private RamoAtividades ramoAtividades;


    private List<Empresa> listaEmpresas;


    private String termoPesquisa;

    private Converter ramoAtividadeConverter;


    public void listaEmpresaPesquisada(){
        listaEmpresas = empresas.pesquisar(termoPesquisa);

        if (listaEmpresas.isEmpty()) {
            messages.info();
        }
    }

    public void todasEmpresas() {
       listaEmpresas = empresas.todas();
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }

    public TipoEmpresa[] getTipoEmpresa(){
        return TipoEmpresa.values();
    }

    public List<RamoAtividade> completarRamoAtividade(String termo){
        List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
        ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
        return listaRamoAtividades;
    }

    public Converter getRamoAtividadeConverter() {
        return ramoAtividadeConverter;
    }
}
