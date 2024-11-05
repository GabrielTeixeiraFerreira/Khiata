package com.khita_servlet.model;

public class Categoria {

//    ========================================================
//    Atributos
    private int id;
    private String categoria;
    private Administrador adm_criador;

//    ========================================================
//    Construtor
    public Categoria(String categoria, Administrador adm_criador) {
        this.categoria = categoria;
        this.adm_criador = adm_criador;
    }

    public Categoria(int id, String categoria, Administrador adm_criador) {
        this.id = id;
        this.categoria = categoria;
        this.adm_criador = adm_criador;
    }

    //    ========================================================
//    Getters

    public String getCategoria() {
        return categoria;
    }

    public Administrador getAdm_criador() {
        return adm_criador;
    }

    public int getId() {
        return id;
    }

    //    ========================================================
//    Setters

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


//    ========================================================
//    Métodos adicionais

//    ========================================================
//    toString

    public String toString() {
        return "Categoria: "+categoria+
                "\n Criador: "+adm_criador.getNome_completo();
    }
}
