package com.algaworks.erp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;




@Entity
@Table(name = "ramo_atividade")
public class RamoAtividade implements Serializable {

    @Id
    private long id;
}
