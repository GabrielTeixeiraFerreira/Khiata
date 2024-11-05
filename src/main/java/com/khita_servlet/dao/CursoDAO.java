package com.khita_servlet.dao;

import com.khita_servlet.model.Curso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

//    =====================================================================================
//    Método para inserir valores dentro do BD na tabela de cursos
    public int inserirCurso(String thumbnail, int duracao_segundos, String titulo, String link_video, int id_tipo_curso){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into cursos " +
                    "(THUMBNAIL, DURACAO_SEGUNDOS, TITULO, LINK_VIDEO, ID_TIPO_CURSO) " + // <-- colunas
                    "values (?,?,?,?,?)");  // <-- parametros

            //          Setando os parametros
            conexao.pstmt.setString(1,thumbnail);
            conexao.pstmt.setInt(2,duracao_segundos);
            conexao.pstmt.setString(3,titulo);
            conexao.pstmt.setString(4,link_video);
            conexao.pstmt.setInt(5,id_tipo_curso);

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
    public int inserirCurso(int id,String thumbnail, int duracao_segundos, String titulo, String link_video, int id_tipo_curso){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into cursos " +
                    "(THUMBNAIL, DURACAO_SEGUNDOS, TITULO, LINK_VIDEO, ID, ID_TIPO_CURSO) " + // <-- colunas
                    "values (?,?,?,?,?,?)");  // <-- parametros

            //          Setando os parametros
            conexao.pstmt.setString(1,thumbnail);
            conexao.pstmt.setInt(2,duracao_segundos);
            conexao.pstmt.setString(3,titulo);
            conexao.pstmt.setString(4,link_video);
            conexao.pstmt.setInt(5,id);
            conexao.pstmt.setInt(6,id_tipo_curso);

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

    public int removerCurso(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        String remover = "DELETE FROM cursos WHERE ID = ?"; //Criando a instrução em uma variável separada
        try {

//            Instanciando o objeto preparedStatement (pstmt)
            conexao.pstmt = conexao.conn.prepareStatement(remover);

//            Setando o valor do parâmetro
            conexao.pstmt.setInt(1,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando conexão com BD
        }
    }



//    =====================================================================================
//    Método para alterar uma coluna de curso de acordo com o id

//    ---------------------------------------------------------
//    Para quando for VARCHAR ou TEXT

    public int alterarCurso(int id, String coluna, String textoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE cursos SET "+coluna+" = ? WHERE id = ?"); // Criando a instrução para setar os parametros

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

    public int alterarCurso(int id, String coluna, int numNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE cursos SET "+coluna+" = ? WHERE id = ?"); // Criando a instrução para setar os parametros

            //        Setando os parametros
            conexao.pstmt.setInt(1, numNovo);
            conexao.pstmt.setInt(2, id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();// Fechando a conexão com o BD
        }
    }

//    =================================================================================================
//    Método para obter toods os dados de cursos
    public Curso[] buscarCursos(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT cursos.id" +
                    ", thumbnail" +
                    ", duracao_segundos" +
                    ", titulo" +
                    ", link_video" +
                    ", tipo_curso.tipo" +
                    " FROM cursos" +
                    " JOIN tipo_curso ON tipo_curso.id = cursos.id_tipo_curso"); //Preparando a instrução SQL

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            List<Curso> cursoList = new ArrayList<>();
            int qtdCursos =0;

            if (conexao.rs.next()){
                TipoCursoDAO tipoCursoDAO = new TipoCursoDAO();
                do {
                    cursoList.add(new Curso(
                            conexao.rs.getInt("id"),
                            conexao.rs.getString("thumbnail"),
                            conexao.rs.getInt("duracao_segundos"),
                            conexao.rs.getString("titulo"),
                            conexao.rs.getString("link_video"),
                            tipoCursoDAO.buscarTipoCursoPeloTipo(
                                    conexao.rs.getString("tipo")
                            )
                            ));
                    qtdCursos++;
                }while (conexao.rs.next());

                return cursoList.toArray(new Curso[qtdCursos]);

            }else{
                return new Curso[0];
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

    public Curso buscarCursoPeloLink(String link){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement(
                    "SELECT cursos.id" +
                             ", cursos.thumbnail" +
                             ", cursos.duracao_segundos" +
                             ", cursos.titulo" +
                             ", cursos.link_video" +
                             ", tipo_curso.tipo" +
                        "  FROM cursos" +
                        "  JOIN tipo_curso ON cursos.id_tipo_curso = tipo_curso.id" +
                        " WHERE cursos.link_video = ?"
            ); // Preparando a instrução SQL

            // Setando os parâmetros
            conexao.pstmt.setString(1,link);

            conexao.rs = conexao.pstmt.executeQuery(); // Executando a Query

            if (conexao.rs.next()){

                // Instanciando o objeto para buscar o tipo de curso
                TipoCursoDAO tipoCursoDAO = new TipoCursoDAO();

                // Retornando o objeto de curso
                return new Curso(
                        conexao.rs.getInt("id"),
                        conexao.rs.getString("thumbnail"),
                        conexao.rs.getInt("duracao_segundos"),
                        conexao.rs.getString("titulo"),
                        conexao.rs.getString("link_video"),
                        tipoCursoDAO.buscarTipoCursoPeloTipo(
                            conexao.rs.getString("tipo")
                        )
                );
            }

            return null; // Caso não exista esse curso

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }

    }


    // CursoDAO.java
    public boolean isTipoCursoAlocado(String tipo) {
        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement(
                    "SELECT COUNT(*) FROM cursos WHERE id_tipo_curso = ?"
            ); // Preparando a instrução SQL

            conexao.rs = conexao.pstmt.executeQuery();//Armazenando o Select dentro do objeto ResultSet

            conexao.rs = conexao.pstmt.executeQuery();//Armazenando o Select dentro do objeto ResultSet

            conexao.rs.next(); // <-- passando linha

            return conexao.rs.getBoolean(1);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.desconectar(); // Fechando conexão com o banco
        }
    }

}
