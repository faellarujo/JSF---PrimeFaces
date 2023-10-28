package com.algaworks.erp.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "ramo_atividade")
public class RamoAtividade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 80)
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RamoAtividade)) return false;
        RamoAtividade that = (RamoAtividade) o;
        return getId() == that.getId() && Objects.equals(getDescricao(), that.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
