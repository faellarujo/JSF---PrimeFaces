package com.algaworks.erp.util;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class FacesMessages implements Serializable {

    private static final long serialVersionUID = 1L;

    private void add(String msg, FacesMessage.Severity severity){
        FacesMessage facesMessage = new FacesMessage(msg);
        facesMessage.setSeverity(severity);

        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

   /* public void info(String msg){
        add(msg, FacesMessage.SEVERITY_INFO);
    }*/

    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Sua consulta não retornou registros"));
    }
}
