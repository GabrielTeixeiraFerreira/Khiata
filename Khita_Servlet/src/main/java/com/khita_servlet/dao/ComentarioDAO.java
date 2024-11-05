package com.khita_servlet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComentarioDAO {

//    =====================================================================================
//    Método para inserir valores dentro do BD na tabela de comentario
    public int inserirComentario(String mensagem, String tp_comentario, int id_usuario, int id_referencia){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into comentario " +
                    "(MENSAGEM, TP_COMENTARIO, ID_USUARIO, ID_REFERENCIA) " + // <-- colunas
                    "values (?,?,?,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setString(1,mensagem);
            conexao.pstmt.setString(2,tp_comentario);
            conexao.pstmt.setInt(3,id_usuario);
            conexao.pstmt.setInt(4,id_referencia);

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

    public int inserirComentario(int id,String mensagem, String tp_comentario, int id_usuario, int id_referencia){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into comentario " +
                    "(MENSAGEM, TP_COMENTARIO, ID_USUARIO, ID_REFERENCIA, ID) " + // <-- colunas
                    "values (?,?,?,?,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setString(1,mensagem);
            conexao.pstmt.setString(2,tp_comentario);
            conexao.pstmt.setInt(3,id_usuario);
            conexao.pstmt.setInt(4,id_referencia);
            conexao.pstmt.setInt(5,id);

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

    public int removerComentario(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        String remover = "DELETE FROM comentario WHERE ID = ?"; //Criando a instrução em uma variável separada
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
//    Método para alterar uma coluna de comentario de acordo com o id

//    ---------------------------------------------------------
//    Para quando for VARCHAR ou TEXT

    public int alterarComentario(int id, String coluna,String textoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE historico SET "+coluna+" = ? WHERE id = ?"); // Criando a instrução para setar os parametros

            //        Setando os parametros
            conexao.pstmt.setString(1, textoNovo);
            conexao.pstmt.setInt(2, id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;  //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();// Fechando a conexão com o BD
        }
    }


//    ---------------------------------------------------------
//    Para quando for INT

    public int alterarComentario(int id, String coluna,int numNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE historico SET "+coluna+" = ? WHERE id = ?"); // Criando a instrução para setar os parametros

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
//    Método para obter toods os dados de comentario
    public ResultSet buscarComentario(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM comentario ORDER BY ID"); //Preparando a instrução SQL

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            return conexao.rs; //Retornando o select

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    --------------------------------------------------
//    Método para pegar os comentários de cursos

    public ResultSet buscarComentarioDeCurso(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM comentario WHERE tp_comentario = 'curso' ORDER BY ID"); //Preparando a instrução SQL

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            return conexao.rs; //Retornando o select

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    --------------------------------------------------
//    Método para pegar os comentários de produtos

    public ResultSet buscarComentarioDeProduto(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM comentario WHERE tp_comentario = 'produto' ORDER BY ID"); //Preparando a instrução SQL

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
