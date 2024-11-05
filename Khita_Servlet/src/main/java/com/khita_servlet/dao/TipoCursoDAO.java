package com.khita_servlet.dao;

import com.khita_servlet.model.Administrador;
import com.khita_servlet.model.Categoria;
import com.khita_servlet.model.TipoCurso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoCursoDAO {

//    =====================================================================================
//    Método para inserir valores dentro do BD na tabela de categoria
    public int inserirTipoCurso(String tipo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into tipo_curso " +
                    "(TIPO) " + // <-- colunas
                    "values (?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setString(1,tipo);

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
    public int inserirTipoCurso(int id,String tipo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into tipo_curso " +
                    "(TIPO, ID) " + // <-- colunas
                    "values (?,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setString(1,tipo);
            conexao.pstmt.setInt(2, id);

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
    public int removerTipoCurso(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        String remover = "DELETE FROM tipo_curso WHERE ID = ?"; //Criando a instrução em uma variável separada
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

    public int alterarTipoCurso(int id, String textoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE tipo_curso SET tipo = ? WHERE id = ?"); // Criando a instrução para setar os parametros

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

//    =================================================================================================
//    Método para obter o objeto de tipo curso pelo tipo escrito na tabela
    public TipoCurso buscarTipoCursoPeloTipo(String tipo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
//            Validando se existe um tipo de curso com esse nome
            conexao.pstmt = conexao.conn.prepareStatement(
                    "SELECT EXISTS ( SELECT ID FROM tipo_curso WHERE TIPO = ?)");

            // Setando o parâmetro
            conexao.pstmt.setString(1,tipo);

            conexao.rs = conexao.pstmt.executeQuery(); // Armazenando o resultado do SELECT

            conexao.rs.next(); // Passando linha

            // Testando a existencia da categoria com esse nome
            if (conexao.rs.getBoolean(1)){
                // Preparando a instrução SQL
                conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM tipo_curso WHERE TIPO = ?");

                // Setando os parâmetros
                conexao.pstmt.setString(1, tipo);

                conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

                conexao.rs.next(); // Passando linha

                return new TipoCurso(
                        conexao.rs.getInt("id"),
                        conexao.rs.getString("tipo"));  // Retornando o objeto de TipoCurso
            }

            return null; // <-- retorna null caso não haja nenhum tipo com esse nome

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null; // Retornando null caso haja um erro no BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }


    //    =================================================================================================
//    Método para obter todos os dados de categoria
    public TipoCurso[] buscarTipoCategoria() {

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            //Preparando a instrução SQL
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM tipo_curso ORDER BY ID");

            conexao.rs = conexao.pstmt.executeQuery();//Armazenando o Select dentro do objeto ResultSet

            List<TipoCurso> tipoCursoList = new ArrayList<>();
            int qtdTipos = 0;

            if (conexao.rs.next()){
                do {
                    tipoCursoList.add(new TipoCurso(
                            conexao.rs.getInt("id"),
                            conexao.rs.getString("tipo")
                    ));
                    qtdTipos++;
                }while (conexao.rs.next());

                return tipoCursoList.toArray(new TipoCurso[qtdTipos]);

            } else {
                return new TipoCurso[0];
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }
}
