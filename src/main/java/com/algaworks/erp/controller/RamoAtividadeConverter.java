package com.algaworks.erp.controller;

import com.algaworks.erp.model.RamoAtividade;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.util.List;
import java.util.stream.Stream;


@Named
@ViewScoped
public class RamoAtividadeConverter implements Converter {

    private List<RamoAtividade> listaRamoAtividade;


    public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividade) {
        this.listaRamoAtividade = listaRamoAtividade;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null) {
            return null;
        }


        Long id = Long.valueOf(value);

        for (RamoAtividade ramoAtividade : listaRamoAtividade) {
            if (id.equals(ramoAtividade.getId())) {
                return ramoAtividade;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        RamoAtividade ramoAtividade = (RamoAtividade) value;
        return  Long.toString(ramoAtividade.getId());
    }
}