package com.khita_servlet.model;

public class Item {

//    ========================================================
//    Atributos
    private Produto produto;
    private int quantidade;
    private Pedido pedido;

//    ========================================================
//    Construtor

    public Item(Produto produto, int quantidade, Pedido pedido) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.pedido = pedido;
    }


//    ========================================================
//    Getters

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }


//    ========================================================
//    Setters

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


//    ========================================================
//    Métodos adicionais

//    ========================================================
//    toString

    public String toString() {
        return quantidade+" unidades de "+produto.getNome()+" associadas ao pedido com número de nota fiscal: "+pedido.getNotaFiscal().getNum_nota();
    }
}
