package com.algaworks.erp.service;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.repository.Empresas;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.io.Serializable;

@Named
@ViewScoped
public class CadastroEmpresaService implements Serializable {

    @Inject
    private Empresas empresas;


    @Transactional
    public void salvar(Empresa empresa){
        empresas.guardar(empresa);
    }

    @Transactional
    public void excluir(Empresa empresa){
        empresas.remover(empresa);
    }

}
