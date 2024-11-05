package com.khita_servlet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FotoDAO {

//    =====================================================================================
//    Método para inserir valores dentro do BD na tabela de fotos
    public int inserirFoto(int id_produto, String url){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD

        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into fotos " +
                    "(ID_PRODUTO, URL) " + // <-- colunas
                    "values (?,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setInt(1,id_produto);
            conexao.pstmt.setString(2,url);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando a conexão com BD
        }
    }

//    ---------------------------------------------------------
//    Para colocar manualmente o id
    public int inserirFoto(int id,int id_produto, String url){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD]

        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into fotos " +
                    "(ID_PRODUTO, URL, ID) " + // <-- colunas
                    "values (?,?,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setInt(1,id_produto);
            conexao.pstmt.setString(2,url);
            conexao.pstmt.setInt(3,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando a conexão com BD
        }
    }


//    =====================================================================================
//    Método para remover a linha pelo id

    public int removerFoto(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        String remover = "DELETE FROM fotos WHERE ID = ?"; //Criando a instrução em uma variável separada
        try {

//            Instanciando o objeto preparedStatement (pstmt)
            conexao.pstmt = conexao.conn.prepareStatement(remover);

//            Setando o valor do parâmetro
            conexao.pstmt.setInt(1,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;  //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando conexão com BD
        }
    }



//    =====================================================================================
//    Método para alterar uma linha de fotos de acordo com o id

//    ---------------------------------------------------------
//    Para quando for VARCHAR ou TEXT

    public int alterarFoto(int id, String coluna,String textoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE fotos SET "+coluna+" = ? WHERE id = ?"); // Criando a instrução para setar os parametros

            //        Setando os parametros
            conexao.pstmt.setString(1, textoNovo);
            conexao.pstmt.setInt(2, id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();// Fechando a conexão com o BD
        }
    }


//    ---------------------------------------------------------
//    Para quando for INT

    public int alterarFoto(int id, String coluna,int numNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE fotos SET "+coluna+" = ? WHERE id = ?"); // Criando a instrução para setar os parametros

            //        Setando os parametros
            conexao.pstmt.setInt(1, numNovo);
            conexao.pstmt.setInt(2, id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;  //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();// Fechando a conexão com o BD
        }
    }

//    =================================================================================================
//    Método para obter toods os dados de fotos
    public ResultSet buscarFotos(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM FOTOS ORDER BY ID"); //Preparando a instrução SQL

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
