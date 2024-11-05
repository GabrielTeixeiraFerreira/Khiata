package com.khita_servlet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PreferenciaDAO {

//    =====================================================================================
//    Método para inserir valores dentro do BD na tabela de preferencias
    public int inserirPreferencia(int id_usuario, int id_categoria){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD

        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into preferencias " +
                    "(ID_USUARIO, ID_CATEGORIA) " + // <-- colunas
                    "values (?,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setInt(1,id_usuario);
            conexao.pstmt.setInt(2,id_categoria);

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
    public int inserirPreferencia(int id, int id_usuario, int id_categoria){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD

        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into preferencias " +
                    "(ID_USUARIO, ID_CATEGORIA, ID) " + // <-- colunas
                    "values (?,?,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setInt(1,id_usuario);
            conexao.pstmt.setInt(2,id_categoria);
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

    public int removerPreferencia(int id_usuario, int id_categoria){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        String remover = "DELETE FROM preferencias WHERE ID_USUARIO = ? AND ID_CATEGORIA = ?"; //Criando a instrução em uma variável separada
        try {

//            Instanciando o objeto preparedStatement (pstmt)
            conexao.pstmt = conexao.conn.prepareStatement(remover);

//            Setando o valor do parâmetro
            conexao.pstmt.setInt(1,id_usuario);
            conexao.pstmt.setInt(2,id_categoria);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;  //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando conexão com BD
        }
    }



//    =====================================================================================
//    Método para alterar uma coluna de preferencias de acordo com o id

//    ---------------------------------------------------------
//    Para quando for INT

    public int alterarPreferencia(int id, String coluna,int numNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE preferencias SET "+coluna+" = ? WHERE id = ?"); // Criando a instrução para setar os parametros

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
//    Método para obter todos os dados de preferencias
    public ResultSet buscarPreferencias(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM PREFERENCIAS ORDER BY ID"); //Preparando a instrução SQL

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            return conexao.rs; //Retornando o select

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }


    public boolean preferenciaJaAlocada(int id_usuario, int id_categoria){

        // Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); // Conectando no BD

        try {
            // Criando a instrução SQL
            conexao.pstmt = conexao.conn.prepareStatement("SELECT EXISTS(SELECT  1 FROM preferencias " +
                                           "WHERE id_usuario = ? AND id_categoria = ?)");

            // Setando os parâmetros
            conexao.pstmt.setInt(1,id_usuario);
            conexao.pstmt.setInt(2,id_categoria);

            conexao.rs = conexao.pstmt.executeQuery();//Armazenando o Select dentro do objeto ResultSet

            conexao.rs.next(); // <-- passando linha

            return conexao.rs.getBoolean(1);

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar(); // Fechando conexão com o banco
        }


    }

}
