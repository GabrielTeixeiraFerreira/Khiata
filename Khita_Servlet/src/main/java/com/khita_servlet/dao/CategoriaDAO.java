package com.khita_servlet.dao;

import com.khita_servlet.model.Administrador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.khita_servlet.model.Administrador;
import com.khita_servlet.model.Categoria;

public class CategoriaDAO {


//    =====================================================================================
//    Método para inserir valores dentro do BD na tabela de categoria
    public int inserirCategoria(String categoria, int id_administrador){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into categoria " +
                    "(CATEGORIA, ID_ADMINISTRADOR) " + // <-- colunas
                    "values (?,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setString(1,categoria);
            conexao.pstmt.setInt(2,id_administrador);

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
    public int inserirCategoria(int id,String categoria, int id_administrador){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into categoria " +
                    "(CATEGORIA, ID_ADMINISTRADOR, ID) " + // <-- colunas
                    "values (?,?,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setString(1,categoria);
            conexao.pstmt.setInt(2,id_administrador);
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
    public int removerCategoria(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        String remover = "DELETE FROM categoria WHERE ID = ?"; //Criando a instrução em uma variável separada
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
//    Método para alterar uma coluna de categoria de acordo com o id

//    ---------------------------------------------------------
//    Para quando for VARCHAR ou TEXT

    public int alterarCategoria(int id, String textoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE categoria SET categoria = ? WHERE id = ?"); // Criando a instrução para setar os parametros

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
    public int alterarCategoria(int id, String coluna,int numNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE categoria SET "+coluna+" = ? WHERE id = ?"); // Criando a instrução para setar os parametros

 //           Setando os parametros
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
//    Método para obter o id da categoria segundo seu nome
    public Categoria buscarCategoriaPeloNomeCategoria(String categoria){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
//            Validando se existe uma categoria com esse nome
            conexao.pstmt = conexao.conn.prepareStatement(
                    "SELECT EXISTS ( SELECT ID FROM categoria WHERE CATEGORIA = ?)");

            // Setando o parâmetro
            conexao.pstmt.setString(1, categoria);

            conexao.rs = conexao.pstmt.executeQuery(); // Armazenando o resultado do SELECT

            conexao.rs.next(); // Passando linha

            // Testando a existencia da categoria com esse nome
            if (conexao.rs.getBoolean(1)){
                // Preparando a instrução SQL
                conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM categoria WHERE CATEGORIA = ?");

                // Setando os parâmetros
                conexao.pstmt.setString(1, categoria);

                conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

                conexao.rs.next(); // Passando linha

                // Criando o objeto para conseguir receber o administrador criador dessa categoria
                AdministradorDAO administradorDAO = new AdministradorDAO();

                // Recebendo o administrador usando o ID presente na tabela de categoria para pegar o objeto de Administrador
                int idAdm = conexao.rs.getInt("id_administrador");
                Administrador administrador = administradorDAO.buscarAdministradorEspecifico(idAdm);

                return new Categoria(conexao.rs.getInt("id"),
                                     conexao.rs.getString("categoria"),
                                     administrador);  // Retornando o objeto de Categoria
            }

            return null; // <-- retorna null caso não haja nenhuma categoria com esse nome

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null; // Retornando null caso haja um erro no BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    =================================================================================================
//    Método para obter o adm da categoria com ID indicado
    public Administrador buscarAdmDeCategoriaEspecifica(int idCategoria){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement(
                    "SELECT administrador.* FROM categoria " +
                        "LEFT JOIN administrador ON administrador.id = categoria.id_administrador " +
                        "WHERE categoria.id = ?"); //Preparando a instrução SQL

            conexao.pstmt.setInt(1,idCategoria);

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            conexao.rs.next();

            return new Administrador(
                    conexao.rs.getString("EMAIL"),
                    conexao.rs.getString("SENHA"),
                    conexao.rs.getString("NOME_COMPLETO")
            );

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    =================================================================================================
//    Método para obter todos os dados de categoria
    public Categoria[] buscarCategoria() {

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            //Preparando a instrução SQL
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM categoria ORDER BY ID");

            conexao.rs = conexao.pstmt.executeQuery();//Armazenando o Select dentro do objeto ResultSet

            List<Categoria> categoriaList = new ArrayList<>();
            int qtdCategorias = 0;

            if (conexao.rs.next()){
                do {
                    categoriaList.add(
                            buscarCategoriaPeloNomeCategoria(
                                    conexao.rs.getString("categoria")
                            )
                    );
                    qtdCategorias++;
                }while (conexao.rs.next());

                return categoriaList.toArray(new Categoria[qtdCategorias]);

            }else{
                return new Categoria[0];
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

}
