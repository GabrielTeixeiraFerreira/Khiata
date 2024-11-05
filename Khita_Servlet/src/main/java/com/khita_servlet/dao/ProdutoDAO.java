package com.khita_servlet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {

//    ==================================================================================================================
//    Método para adicionar um produto
    public int inserirProduto(String nome, double preco, String id_costureiro, double avaliacao){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com o BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("insert into produto " +
                    "(NOME, PRECO, ID_COSTUREIRO, AVALIACAO) " + // <-- Colunas
                    "values (?,?,?,?)"); // <-- Parâmetros


//            Setando os parâmetros
            conexao.pstmt.setString(1,nome);
            conexao.pstmt.setDouble(2,preco);
            conexao.pstmt.setString(3,id_costureiro);
            conexao.pstmt.setDouble(4, avaliacao);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;  //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    ---------------------------------------------------------
//    Para colocar manualmente o id
    public int inserirProduto(int id,String nome, double preco, String id_costureiro, double avaliacao){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com o BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("insert into produto " +
                    "(NOME, PRECO, ID_COSTUREIRO, ID, AVALIACAO) " + // <-- Colunas
                    "values (?,?,?,?,?)"); // <-- Parâmetros


            //            Setando os parâmetros
            conexao.pstmt.setString(1,nome);
            conexao.pstmt.setDouble(2,preco);
            conexao.pstmt.setString(3,id_costureiro);
            conexao.pstmt.setInt(   4,id);
            conexao.pstmt.setDouble(5,avaliacao);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;  //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    -------------------------------------------------------
//    Métodos para adicionar com descrição
    public int inserirProduto(String nome, double preco, String id_costureiro, double avaliacao, String descricao){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com o BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("insert into produto " +
                    "(NOME, PRECO, ID_COSTUREIRO, AVALIACAO, DESCRICAO) " + // <-- Colunas
                    "values (?,?,?,?)"); // <-- Parâmetros


    //            Setando os parâmetros
            conexao.pstmt.setString(1,nome);
            conexao.pstmt.setDouble(2,preco);
            conexao.pstmt.setString(3,id_costureiro);
            conexao.pstmt.setDouble(4,avaliacao);
            conexao.pstmt.setString(5,descricao);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;  //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

    //    ---------------------------------------------------------
//    Para colocar manualmente o id
    public int inserirProduto(int id,String nome, double preco, String id_costureiro, double avaliacao, String descricao){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com o BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("insert into produto " +
                    "(NOME, PRECO, ID_COSTUREIRO, ID, AVALIACAO, DESCRICAO) " + // <-- Colunas
                    "values (?,?,?,?,?)"); // <-- Parâmetros


            //            Setando os parâmetros
            conexao.pstmt.setString(1,nome);
            conexao.pstmt.setDouble(2,preco);
            conexao.pstmt.setString(3,id_costureiro);
            conexao.pstmt.setInt(   4,id);
            conexao.pstmt.setDouble(5,avaliacao);
            conexao.pstmt.setString(6,descricao);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;  //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    ==================================================================================================================
//    Remover um produto pelo id
    public int removerProduto(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("delete from produto where id =?"); //Comando preparado sem parametros

//            Setando parâmetros
            conexao.pstmt.setInt(1,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }



//    ==================================================================================================================
//    Alterando valores da tabela Produto


//    ------------------------------------------------------------------------
//    Caso seja double (preço)
    public int alterarProduto(int id, String coluna,double precoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("update produto set "+coluna+" = ? where id = ?"); //Criando a instrução com parametros a definir

//            Setando parametros
            conexao.pstmt.setDouble(1,precoNovo);
            conexao.pstmt.setInt(2,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando conexao com BD
        }
    }

//   ------------------------------------------------------------------------------------
//    Caso seja texto (nome, cpf_costureiro)
    public int alterarProduto(int id, String coluna,String textoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("update produto set "+coluna+" = ? where id = ?"); //Criando a instrução com parametros a definir

//            Setando parametros
            conexao.pstmt.setString(1,textoNovo);
            conexao.pstmt.setInt(2,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando conexao com BD
        }
    }


//    =================================================================================================
//    Método para obter toods os dados de produtos
    public ResultSet buscarProdutos(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM PRODUTO ORDER BY ID"); //Preparando a instrução SQL

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
