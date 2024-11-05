package com.khita_servlet.model;

public class Historico {

//    ========================================================
//    Atributos
    private Curso curso;
    private Usuario usuario;
    private boolean assistiu_completo;

//    ========================================================
//    Construtor

    public Historico(Curso curso, Usuario usuario, boolean assistiu_completo) {
        this.curso = curso;
        this.usuario = usuario;
        this.assistiu_completo = assistiu_completo;
    }


//    ========================================================
//    Getters

    public Curso getCurso() {
        return curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isAssistiu_completo() {
        return assistiu_completo;
    }


//    ========================================================
//    Setters

    public void setAssistiu_completo(boolean assistiu_completo) {
        this.assistiu_completo = assistiu_completo;
    }


//    ========================================================
//    Métodos adicionais

//    ========================================================
//    toString

    public String toString() {
        if (assistiu_completo){
            return usuario.getNome()+" assistiu tudo do curso "+curso.getTitulo();
        }else{
            return usuario.getNome()+" não assistiu tudo do curso "+curso.getTitulo();
        }
    }
}
