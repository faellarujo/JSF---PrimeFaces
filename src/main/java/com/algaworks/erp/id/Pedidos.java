package com.algaworks.erp.id;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.math.BigDecimal;

@Named
@SessionScoped
public class Pedidos implements Serializable {

    public BigDecimal totalPedidoMesAtaual(){
        return new BigDecimal("100");
    }
}
