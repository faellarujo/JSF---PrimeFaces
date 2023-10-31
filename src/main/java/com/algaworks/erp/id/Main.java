package com.algaworks.erp.id;

import com.algaworks.erp.model.Empresa;

public class Main {

    public static void main(String[] args) {


        Empresa empresa = new Empresa();

        String nomeFantasia = empresa.getNomeFantasia();
        System.out.println(nomeFantasia);


    }
}
