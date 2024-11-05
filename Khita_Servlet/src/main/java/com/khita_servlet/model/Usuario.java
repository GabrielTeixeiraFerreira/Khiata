package com.khita_servlet.model;


public class Usuario {

//    ========================================================
//    Atributos
    private int id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String senha;
    private String tp_cliente;
    private double nota_avaliacao;
    private boolean premium;
    private String data_nascimento;
    private String cep_endereco;
    private Categoria[] preferencias;
    private String genero;
    private String url_foto;

//    ========================================================
//    Construtor


    public Usuario(int id, String cpf, String nome, String sobrenome, String telefone, String email, String senha, String tp_cliente, double nota_avaliacao, boolean premium, String data_nascimento, String endereco, Categoria[] preferencias, String genero, String url_foto) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.tp_cliente = tp_cliente;
        this.nota_avaliacao = nota_avaliacao;
        this.premium = premium;
        this.data_nascimento = data_nascimento;
        this.cep_endereco = endereco;
        this.preferencias = preferencias;
        this.genero = genero;
        this.url_foto = url_foto;
    }

//    ========================================================
//    Getters
    public int getId() {return id;}

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getTp_cliente() {
        return tp_cliente;
    }

    public double getNota_avaliacao() {
        return nota_avaliacao;
    }

    public boolean isPremium() {
        return premium;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public String getCep_endereco() {
        return cep_endereco;
    }

    public Categoria[] getPreferencias() {
        return preferencias;
    }

    public String getGenero() {return genero;}

    public String getUrl_foto() {return url_foto;}


    //    ========================================================
//    Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNota_avaliacao(double nota_avaliacao) {
        this.nota_avaliacao = nota_avaliacao;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public void setCep_endereco(String cep_endereco) {
        this.cep_endereco = cep_endereco;
    }

    public void setUrl_foto(String url_foto) {this.url_foto = url_foto;}

    public void setGenero(String genero) {this.genero = genero;}

//    ========================================================
//    Métodos adicionais
    public void adicionarPreferencia(Categoria preferencia){

        // Inicializando o vetor onde terá as preferencias novas
        Categoria[] preferenciasNovas = new Categoria[this.preferencias.length+1];

        // Copiando o valor do antigo para o novo
        for (int i = 0; i < this.preferencias.length; i++) {
            preferenciasNovas[i] = this.preferencias[i];
        }

        // Colocando a preferencia nova
        preferenciasNovas[this.preferencias.length] = preferencia;

        // Atribuindo o valor do atributo como o vetor novo de preferencias
        this.preferencias = preferenciasNovas;
    }


    public boolean removerPreferencia(Categoria preferencia){

        // Verificando se há esta preferencia dentro do vetor de preferencias
        int qtdPreferenciasDentro=0; // <-- esta variável irá armazenar a quantidade de vezes que a
                                    //     preferencia recebida está presente no vetor de preferencias
        for (int i = 0; i < this.preferencias.length; i++) {
            if (this.preferencias[i]==preferencia){
                qtdPreferenciasDentro++;
            }
        }

        // Retornando falso caso não exista esse valor no vetor
        if (qtdPreferenciasDentro == 0){
            return false;
        }

        // Instanciando o vetor novo de preferencias sem a antiga
        Categoria[] preferenciasNovas = new Categoria[this.preferencias.length-qtdPreferenciasDentro];

        int indexAtualPreferencias=0;
        //Colocando os valores sem o removido
        for (int i = 0; i < this.preferencias.length; i++) {
            if ( ! (this.preferencias[i] == preferencia)){
                preferenciasNovas[indexAtualPreferencias] = this.preferencias[i];
                indexAtualPreferencias++;
            }
        }

        // Atribuindo o valor do atributo como o vetor novo de preferencias
        this.preferencias = preferenciasNovas;

        return true;

    }

//    ========================================================
//    toString

    public String toString() {
        String preferenciasTexto="";

        for (int i = 0; i < preferencias.length; i++) {
            preferenciasTexto += preferencias[i].getCategoria()+"; ";
        }

        return " Nome completo: "+nome+" "+sobrenome+
                "\n Cpf: "+cpf+
                "\n Telefone: "+telefone+
                "\n E-mail: "+email+
                "\n Senha: "+senha+
                "\n Tipo de usuário: "+tp_cliente+
                "\n Nota de avaliação: "+nota_avaliacao+
                "\n Premium: "+ premium +
                "\n Data de nascimento: "+data_nascimento+
                "\n Endereço: "+ cep_endereco +
                "\n Gênero: "+genero+
                "\n Preferencias: "+preferenciasTexto;
    }
}
