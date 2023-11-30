package com.algaworks.erp.controller;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.RamoAtividade;
import com.algaworks.erp.model.TipoEmpresa;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.repository.RamoAtividades;
import com.algaworks.erp.service.CadastroEmpresaService;
import com.algaworks.erp.util.FacesMessages;
import jakarta.faces.convert.Converter;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.SelectEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {


    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;

    @Inject
    private CadastroEmpresaService cadastroEmpresaService;

    @Inject
    private FacesMessages messages;


    public Empresa getSelectEmpresa() {
        return selectEmpresa;
    }

    public void setSelectEmpresa(Empresa selectEmpresa) {
        this.selectEmpresa = selectEmpresa;
    }

    private Empresa selectEmpresa;

    @Inject
    private RamoAtividades ramoAtividades;

    private List<Empresa> listaEmpresas;

    private String termoPesquisa;

    private Converter ramoAtividadeConverter;


    private Empresa empresa = new Empresa();

    public void prepararNovaEmpresa() {
        empresa = new Empresa();
    }

    public void prepararEdicao(){
        RamoAtividadeConverter ramoAtividadeConverter = new RamoAtividadeConverter(Arrays.asList(empresa.getRamoAtividade()));
    }

    public void salvar() {

        cadastroEmpresaService.salvar(empresa);

        if (jaHouvePesquisa()) {
            pesquisar();
        } else {
            todasEmpresas();
        }
        messages.CadastroRealizadoComSucesso();
    }

    public Empresa getEmpresa() {
            return this.empresa = empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    public boolean jaHouvePesquisa() {
        return termoPesquisa != null && !"".equals(termoPesquisa);
    }


    public void pesquisar() {
        listaEmpresas = empresas.pesquisar(termoPesquisa);

        if (listaEmpresas.isEmpty()) {
            messages.infoNaoRetornouRegistros();
        }
    }


    public void listaEmpresaPesquisada() {
        listaEmpresas = empresas.pesquisar(termoPesquisa);

        if (listaEmpresas.isEmpty()) {
            messages.infoNaoRetornouRegistros();
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

    public TipoEmpresa[] getTipoEmpresa() {
        return TipoEmpresa.values();
    }

    public List<RamoAtividade> completarRamoAtividade(String termo) {
        List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
        ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
        return listaRamoAtividades;
    }


    public boolean onRowSelect(SelectEvent<Empresa> event) {
        Empresa selecionado = (Empresa) event.getObject();

        if (selecionado.getId() != null){
            return  isEmpresaSeleciona();
        } else {
            return isEmpresaDeseleciona();
        }

    }

    public Converter getRamoAtividadeConverter() {
        return ramoAtividadeConverter;
    }


    public boolean isEmpresaSeleciona(){
        if(empresa != null && empresa.getId() != null) {
            return true;
        }

        return false;

    }

    public boolean isEmpresaDeseleciona(){
        if(empresa != null && empresa.getId() != null) {
            return false;
        }

        return true;

    }
}
