package com.khita_servlet.model;

public class Endereco {

//    ========================================================
//    Atributos
    private String cep;
    private String rua;
    private String estado;
    private String cidade;
    private String complemento;
    private int numero;


//    ========================================================
//    Construtor

    public Endereco(String cep, String rua, String estado, String cidade, String complemento, int numero) {
        this.cep = cep;
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.complemento = complemento;
        this.numero = numero;
    }



//    ========================================================
//    Getters

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public int getNumero() {
        return numero;
    }


//    ========================================================
//    Setters

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


//    ========================================================
//    Métodos adicionais

//    ========================================================
//    toString

    public String toString() {
        return "CEP: "+cep+
                "; Rua: "+rua+
                "; Estado: "+estado+
                "; Cidade: "+cidade+
                "; Complemento: "+complemento+
                "; Número: "+numero;
    }
}
