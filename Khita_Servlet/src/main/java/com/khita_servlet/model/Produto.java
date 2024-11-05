package com.khita_servlet.model;
;

public class Produto {

//    ========================================================
//    Atributos
    private String nome;
    private double preco;
    private Usuario costureiro;
    private String[] links_fotos;
    private Categoria[] categorias;
    private String descricao;
    private double avaliacao;
    private String[] comentarios;

//    ========================================================
//    Construtor

    public Produto(String nome, double preco, Usuario costureiro, String[] links_fotos, Categoria[] categorias, String descricao, double avaliacao, String[] comentarios) {
        this.nome = nome;
        this.preco = preco;
        this.costureiro = costureiro;
        this.links_fotos = links_fotos;
        this.categorias = categorias;
        this.descricao = descricao;
        this.avaliacao = avaliacao;
        this.comentarios = comentarios;
    }


//    ========================================================
//    Getters

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Usuario getCostureiro() {
        return costureiro;
    }

    public String[] getLinks_fotos() {
        return links_fotos;
    }

    public Categoria[] getCategorias() {
        return categorias;
    }

    public double getAvaliacao() {return avaliacao;}

    public String getDescricao() {return descricao;}

    public String[] getComentarios() {return comentarios;}

//    ========================================================
//    Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setLinks_fotos(String[] links_fotos) {
        this.links_fotos = links_fotos;
    }

    public void setCategorias(Categoria[] categorias) {
        this.categorias = categorias;
    }

    public void setAvaliacao(double avaliacao) {this.avaliacao = avaliacao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

//    ========================================================
//    Métodos adicionais

    public void adicionarLinkDeFoto(String linkNovo){

        // Inicializando o vetor onde terá as links_fotos novas
        String[] links_fotosNovas = new String[this.links_fotos.length+1];

        // Copiando o valor do antigo para o novo
        for (int i = 0; i < this.links_fotos.length; i++) {
            links_fotosNovas[i] = this.links_fotos[i];
        }

        // Colocando a links_fotos nova
        links_fotosNovas[this.links_fotos.length] = linkNovo;

        // Atribuindo o valor do atributo como o vetor novo de links_fotos
        this.links_fotos = links_fotosNovas;
    }



    public boolean removerLinkDeFoto(String linkRemover){

        // Verificando se há esta links_fotos dentro do vetor de links_fotos
        int qtdlinks_fotosDentro=0; // <-- esta variável irá armazenar a quantidade de vezes que a
        //     links_fotos recebida está presente no vetor de links_fotos
        for (int i = 0; i < this.links_fotos.length; i++) {
            if (this.links_fotos[i].equals(linkRemover.strip())){
                qtdlinks_fotosDentro++;
            }
        }

        // Retornando falso caso não exista esse valor no vetor
        if (qtdlinks_fotosDentro == 0){
            return false;
        }

        // Instanciando o vetor novo de links_fotos sem a antiga
        String[] links_fotosNovas = new String[this.links_fotos.length-qtdlinks_fotosDentro];

        int indexAtuallinks_fotos=0;
        //Colocando os valores sem o removido
        for (int i = 0; i < this.links_fotos.length; i++) {
            if ( ! this.links_fotos[i].equals(linkRemover.strip())){
                links_fotosNovas[indexAtuallinks_fotos] = this.links_fotos[i];
                indexAtuallinks_fotos++;
            }
        }

        // Atribuindo o valor do atributo como o vetor novo de links_fotos
        this.links_fotos = links_fotosNovas;

        return false;

    }



    public void adicionarComentario(String comentario){

        // Inicializando o vetor onde terão os comentarios novos
        String[] comentariosNovos = new String[this.comentarios.length+1];

        // Copiando o valor do antigo para o novo
        for (int i = 0; i < this.comentarios.length; i++) {
            comentariosNovos[i] = this.comentarios[i];
        }

        // Colocando a comentarios nova
        comentariosNovos[this.comentarios.length] = comentario;

        // Atribuindo o valor do atributo como o vetor novo de comentarios
        this.comentarios = comentariosNovos;
    }



    public boolean removerComentario(String comentarioRemover){

        // Verificando se há este comentario dentro do vetor de comentarios
        int qtdComentariosDentro=0; // <-- esta variável irá armazenar a quantidade de vezes que o
        //     comentario recebida está presente no vetor de comentarios
        for (int i = 0; i < this.comentarios.length; i++) {
            if (this.comentarios[i].equals(comentarioRemover.strip())){
                qtdComentariosDentro++;
            }
        }

        // Retornando falso caso não exista esse valor no vetor
        if (qtdComentariosDentro == 0){
            return false;
        }

        // Instanciando o vetor novo de comentarios sem a antiga
        String[] comentariosNovos = new String[this.comentarios.length-qtdComentariosDentro];

        int indexAtualComentarios=0;
        //Colocando os valores sem o removido
        for (int i = 0; i < this.comentarios.length; i++) {
            if ( ! this.comentarios[i].equals(comentarioRemover.strip())){
                comentariosNovos[indexAtualComentarios] = this.comentarios[i];
                indexAtualComentarios++;
            }
        }

        // Atribuindo o valor do atributo como o vetor novo de comentarios
        this.comentarios = comentariosNovos;

        return false;

    }


//    ========================================================
//    toString

    public String toString() {
        String categoriasTexto="";
        for (int i = 0; i < categorias.length; i++) {
            categoriasTexto+=categorias[i].getCategoria()+"; ";
        }

        return "Produto: "+nome+
                "\n Preço: R$"+preco+
                "\n Costureiro/a: "+costureiro.getNome()+
                "\n Nota Avaliação: "+avaliacao+
                "\n Categorias: "+categoriasTexto;
    }
}
