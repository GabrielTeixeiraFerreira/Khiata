package com.khita_servlet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {

//    =====================================================================================
//    Método para adicionar o item
    public int inserirItem(int quantidade, int id_produto, int id_pedido){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD

        try{
            conexao.pstmt= conexao.conn.prepareStatement("insert into item " +
                    "(QUANTIDADE, ID_PRODUTO, ID_PEDIDO)" + // <-- Colunas
                    " values (?,?,?)"); // <-- Parametros

//            Setando parâmetros
            conexao.pstmt.setInt(1,quantidade);
            conexao.pstmt.setInt(2, id_produto);
            conexao.pstmt.setInt(3,id_pedido);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); // Fechando conexao com BD
        }
    }

//    ---------------------------------------------------------
//    Para colocar manualmente o id
    public int inserirItem(int id,int quantidade, int id_produto, int id_pedido){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD

        try{
            conexao.pstmt= conexao.conn.prepareStatement("insert into item " +
                    "(QUANTIDADE, ID_PRODUTO, ID_PEDIDO, ID)" + // <-- Colunas
                    " values (?,?,?,?)"); // <-- Parametros

            //            Setando parâmetros
            conexao.pstmt.setInt(1,quantidade);
            conexao.pstmt.setInt(2, id_produto);
            conexao.pstmt.setInt(3,id_pedido);
            conexao.pstmt.setInt(4,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); // Fechando conexao com BD
        }
    }

//    ======================================================================================
//    Remover uma linha pelo ID
    public int removerItem(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try{
            conexao.pstmt = conexao.conn.prepareStatement("delete from item where id = ?"); //Criando a instrução com os parâmetros a setar

//            Setando os parametros
            conexao.pstmt.setInt(1,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();
        }
    }

//    =====================================================================================================
//    Para modificar uma coluna
    public int alterarItem(int id, String coluna, int numNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE ITEM SET "+coluna+" = ? where ?"); //Criando instrução

//            Setando os parametros
            conexao.pstmt.setInt(1,numNovo);
            conexao.pstmt.setInt(2,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com banco
        }

    }

//    =================================================================================================
//    Método para obter toods os dados de usuarios
    public ResultSet buscarItem(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM ITEM ORDER BY ID"); //Preparando a instrução SQL

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
