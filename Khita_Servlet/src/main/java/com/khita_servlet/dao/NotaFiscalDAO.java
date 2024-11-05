package com.khita_servlet.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotaFiscalDAO {

//    =================================================================================================
//    Método para adicionar nota fiscal
    public int inserirNotaFiscal(int num_nota, String tp_pagto, String status, double valor_imposto, Date dt_emissao, double valor_frete){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try{
            conexao.pstmt = conexao.conn.prepareStatement("insert into nota_fiscal " +
                    "(NUM_NOTA, TP_PAGTO, STATUS, VALOR_IMPOSTO, DT_EMISSAO, VALOR_FRETE) " + // <-- Colunas
                    "values (?,?,?,?,?,?)"); // <-- Parametros

//            Setando os parametros
            conexao.pstmt.setInt(1,num_nota);
            conexao.pstmt.setString(2,tp_pagto);
            conexao.pstmt.setString(3,status);
            conexao.pstmt.setDouble(4,valor_imposto);
            conexao.pstmt.setDate(5,dt_emissao);
            conexao.pstmt.setDouble(6,valor_frete);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando a conexao com o BD
        }
    }

//    =================================================================================================
//    Método para remover uma linha de acordo com o numero da nota fiscal
    public int removerNotaFiscal(int num_nota){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexao com o BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("delete from nota_fiscal where num_nota = ?"); //Preparando instrução SQL

//            Setando os parametros
            conexao.pstmt.setInt(1,num_nota);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando a conexao com BD
        }
    }


//    ==================================================================================================
//    Métodos para mudar valores por colunas pela nota fiscal

//    ---------------------------------------------------
//    Pra quando for texto (tp_pagto e status)
    public int alterarNotaFisal(int num_nota, String coluna, String textoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {

            conexao.pstmt = conexao.conn.prepareStatement("update nota_fical set "+coluna+" = ? where num_nota = ?"); //Preparando a instrução SQL

//            Setando os parametros
            conexao.pstmt.setString(1, textoNovo);
            conexao.pstmt.setInt(2,num_nota);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    ---------------------------------------------------
//    Pra quando for Double (valor_imposto e valor_frete)
    public int alterarNotaFiscal(int num_nota, String coluna, double precoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {

            conexao.pstmt = conexao.conn.prepareStatement("update pedido set "+coluna+" = ? where num_nota = ?"); //Preparando a instrução SQL

//            Setando os parametros
            conexao.pstmt.setDouble(1, precoNovo);
            conexao.pstmt.setInt(2,num_nota);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    ---------------------------------------------------
//    Pra quando for Date (dt_emissao)
    public int alterarNotaFiscal(int num_nota, String coluna, Date dataNova){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {

            conexao.pstmt = conexao.conn.prepareStatement("update pedido set "+coluna+" = ? where num_nota = ?"); //Preparando a instrução SQL

//            Setando os parametros
            conexao.pstmt.setDate(1, dataNova);
            conexao.pstmt.setInt(2,num_nota);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }


//    ---------------------------------------------------
//    Pra quando for Int (num_nota_fiscal)
    public int alterarNotaFiscal(int num_nota, String coluna, int numNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {

            conexao.pstmt = conexao.conn.prepareStatement("update pedido set "+coluna+" = ? where num_nota = ?"); //Preparando a instrução SQL

//            Setando os parametros
            conexao.pstmt.setInt(1, numNovo);
            conexao.pstmt.setInt(2,num_nota);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    =================================================================================================
//    Método para obter toods os dados de pedidos
    public ResultSet buscarNotasFiscais(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM nota_fiscal ORDER BY NUM_NOTA"); //Preparando a instrução SQL

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            return conexao.rs; //Retornando o select

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

}
