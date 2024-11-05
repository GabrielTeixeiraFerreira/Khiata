package com.khita_servlet.model;

public class Administrador {

//    ========================================================
//    Atributos
    private int id;
    private String email;
    private String senha;
    private String nome_completo;

//    ========================================================
//    Construtor
    public Administrador(String email, String senha, String nome_completo) {
        this.email = email;
        this.senha = senha;
        this.nome_completo = nome_completo;
    }

    public Administrador(int id, String email, String senha, String nome_completo) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome_completo = nome_completo;
    }

//    ========================================================
//    Getters

    public String getNome_completo() {
        return nome_completo;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getId() {
        return id;
    }

    //    ========================================================
//    Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public void setId(int id) {
        this.id = id;
    }

    //    ========================================================
//    Métodos adicionais
    public boolean cadastrar(String emailFornecido, String senhaFornecida){
        return this.email.equals(emailFornecido) && this.senha.equals(senhaFornecida);
    }

//    ========================================================
//    toString

    public String toString() {
        return "Administrador "+nome_completo+
                "\n Email: "+email;
    }
}
