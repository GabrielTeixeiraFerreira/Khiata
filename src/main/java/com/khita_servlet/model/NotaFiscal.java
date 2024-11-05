package com.khita_servlet.model;

public class NotaFiscal {

//    ========================================================
//    Atributos
    private int num_nota;
    private String tp_pagto;
    private String status;
    private double valor_imposto;
    private double valor_frete;
    private String dt_emissao;


//    ========================================================
//    Construtor
    public NotaFiscal(int num_nota, String tp_pagto, String status, double valor_imposto, double valor_frete, String dt_emissao) {
        this.num_nota = num_nota;
        this.tp_pagto = tp_pagto;
        this.status = status;
        this.valor_imposto = valor_imposto;
        this.valor_frete = valor_frete;
        this.dt_emissao = dt_emissao;
    }


//    ========================================================
//    Getters

    public int getNum_nota() {
        return num_nota;
    }

    public String getTp_pagto() {
        return tp_pagto;
    }

    public String getStatus() {
        return status;
    }

    public double getValor_imposto() {
        return valor_imposto;
    }

    public double getValor_frete() {
        return valor_frete;
    }

    public String getDt_emissao() {
        return dt_emissao;
    }


//    ========================================================
//    Setters

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValor_frete(double valor_frete) {
        this.valor_frete = valor_frete;
    }


//    ========================================================
//    Métodos adicionais

//    ========================================================
//    toString
    public String toString(){
        return "Nota número: "+num_nota+
                "\n Tipo de pagamento: "+tp_pagto+
                "\n Status: "+status+
                "\n Valor do imposto: R$"+valor_imposto+
                "\n Valor de frete: R$"+valor_frete+
                "\n Data de emissão: "+dt_emissao;
    }

}
