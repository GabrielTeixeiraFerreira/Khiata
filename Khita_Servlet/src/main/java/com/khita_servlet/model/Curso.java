package com.khita_servlet.model;

public class Curso {

//    ========================================================
//    Atributos
    private int id;
    private String thumbnail;
    private int duracao_segundos;
    private String titulo;
    private String link_video;
    private String[] comentarios;
    private TipoCurso tipoCurso;

//    ========================================================
//    Construtores
    public Curso(String thumbnail, int duracao_sec, String titulo, String link_video, String[] comentarios, TipoCurso tipoCurso) {
        this.thumbnail = thumbnail;
        this.duracao_segundos = duracao_sec;
        this.titulo = titulo;
        this.link_video = link_video;
        this.comentarios=comentarios;
        this.tipoCurso = tipoCurso;
    }

    public Curso(int id, String thumbnail, int duracao_segundos, String titulo, String link_video, TipoCurso tipoCurso) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.duracao_segundos = duracao_segundos;
        this.titulo = titulo;
        this.link_video = link_video;
        this.tipoCurso = tipoCurso;
        this.comentarios = new String[0];
    }


    //    ========================================================
//    Getters

    public int getId() {
        return id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getDuracao_segundos() {
        return duracao_segundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getLink_video() {
        return link_video;
    }

    public TipoCurso getTipo_curso() {
        return tipoCurso;
    }

    public String[] getComentarios() {return comentarios;}

//    ========================================================
//    Setters

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


//    ========================================================
//    Métodos adicionais

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
        return " Curso: "+titulo+
                "\n Thumbnail: "+thumbnail+
                "\n Link para o curso: "+link_video+
                "\n Duração de "+ duracao_segundos +"sec";
    }
}
