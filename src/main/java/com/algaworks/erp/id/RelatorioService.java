package com.algaworks.erp.id;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.math.BigDecimal;

@Named
@SessionScoped
public class RelatorioService implements Serializable {



    @Inject
    private Pedidos pedidos;

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public RelatorioService() {

    }

    public BigDecimal totalPedidoMesAtual() {
        return pedidos.totalPedidoMesAtaual();

    }

}
