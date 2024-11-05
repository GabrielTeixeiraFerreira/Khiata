package com.khita_servlet.model;

public class TipoCurso {

//    ========================================================
//    Atributos
    private int id;
    private String tipo;


//    ========================================================
//    Construtor

    public TipoCurso(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public TipoCurso(String tipo){
        this.id = 0;
        this.tipo = tipo;
    }

    //    ========================================================
//    Getters
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

//    ========================================================
//    Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

//    ========================================================
//    toString()

    public String toString() {
        return "Tipo Curso: "+
                "\n Id: "+id+
                "\n Tipo: "+tipo;
    }
}
