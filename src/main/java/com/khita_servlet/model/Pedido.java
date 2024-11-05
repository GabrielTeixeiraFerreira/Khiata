package com.khita_servlet.model;
;

public class Pedido {

//    ========================================================
//    Atributos
    private double total_a_pagar;
    private String dt_pedido;
    private String dt_entrega;
    private Usuario comprador;
    private Usuario costureiro;
    private NotaFiscal notaFiscal;

//    ========================================================
//    Construtor

    public Pedido(double total_a_pagar, String dt_pedido, String dt_entrega, Usuario comprador, Usuario costureiro, NotaFiscal notaFiscal) {
        this.total_a_pagar = total_a_pagar;
        this.dt_pedido = dt_pedido;
        this.dt_entrega = dt_entrega;
        this.comprador = comprador;
        this.costureiro = costureiro;
        this.notaFiscal = notaFiscal;
    }

    public Pedido(double total_a_pagar, String dt_pedido, String dt_entrega, Usuario comprador, Usuario costureiro, int num_nota, String tp_pagto, String status, double valor_imposto, double valor_frete, String dt_emissao) {
        this.total_a_pagar = total_a_pagar;
        this.dt_pedido = dt_pedido;
        this.dt_entrega = dt_entrega;
        this.comprador = comprador;
        this.costureiro = costureiro;
        this.notaFiscal = new NotaFiscal(num_nota, tp_pagto, status, valor_imposto, valor_frete, dt_emissao);
    }

//    ========================================================
//    Getters

    public double getTotal_a_pagar() {
        return total_a_pagar;
    }

    public String getDt_pedido() {
        return dt_pedido;
    }

    public String getDt_entrega() {
        return dt_entrega;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public Usuario getCostureiro() {
        return costureiro;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }


//    ========================================================
//    Setters

    public void setTotal_a_pagar(double total_a_pagar) {
        this.total_a_pagar = total_a_pagar;
    }

    public void setDt_entrega(String dt_entrega) {
        this.dt_entrega = dt_entrega;
    }


//    ========================================================
//    Métodos adicionais

//    ========================================================
//    toString

    public String toString() {
        return "Pedido realizado "+dt_pedido+" por "+comprador.getNome()+
                "\n Costureiro: "+costureiro.getNome()+
                "\n Preço total: R$"+total_a_pagar+
                "\n Data de entrega: "+dt_entrega+
                "\n "+notaFiscal.toString();
    }
}
