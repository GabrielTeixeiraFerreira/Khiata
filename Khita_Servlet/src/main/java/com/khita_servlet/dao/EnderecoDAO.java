package com.khita_servlet.dao;

import com.khita_servlet.model.Endereco;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {

//    =====================================================================================
//    Método para inserir valores dentro do BD na tabela de endereco
    public int inserirEndereco(String cep, String rua, String estado, String cidade, int numero){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD

        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into endereco " +
                    "(CEP, RUA, ESTADO, CIDADE, NUMERO) " + // <-- colunas
                    "values (?,?,?,?,?)"); // <-- parametros

//            Setando os parametros
            conexao.pstmt.setString(1,cep);
            conexao.pstmt.setString(2, rua);
            conexao.pstmt.setString(3,estado);
            conexao.pstmt.setString(4,cidade);
            conexao.pstmt.setInt(5,numero);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando a conexão com BD
        }
    }

//    --------------------------------------------------------
//    Método extra que inclui endereço com complemento
public int inserirEndereco(String cep, String rua, String estado, String cidade, String complemento,int numero){

    //Criando objeto para criar a conexao e criar os métodos do BD
    Conexao conexao = new Conexao();

    conexao.conectar(); //Abrindo a conexão com BD

    try {

        // Criando a instrução com parametros a definir
        conexao.pstmt = conexao.conn.prepareStatement("insert into endereco " +
                "(CEP, RUA, ESTADO, CIDADE, COMPLEMENTO, NUMERO) " + // <-- colunas
                "values (?,?,?,?,?,?)"); // <-- parametros

//            Setando os parametros
        conexao.pstmt.setString(1,cep);
        conexao.pstmt.setString(2, rua);
        conexao.pstmt.setString(3,estado);
        conexao.pstmt.setString(4,cidade);
        conexao.pstmt.setString(5, complemento);
        conexao.pstmt.setInt(6,numero);

        return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

    }catch (SQLException sqle){
        sqle.printStackTrace();
        return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
    }finally {
        conexao.desconectar();//Fechando a conexão com BD
    }
}



//    =====================================================================================
//    Método para remover a linha pelo cep

    public int removerEndereco(String cep){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        String remover = "DELETE FROM endereco WHERE cep = ?"; //Criando a instrução em uma variável separada
        try {

//            Instanciando o objeto preparedStatement (pstmt)
            conexao.pstmt = conexao.conn.prepareStatement(remover);

//            Setando o valor do parâmetro
            conexao.pstmt.setString(1,cep);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando conexão com BD
        }
    }




//    =====================================================================================
//    Método para alterar uma coluna de endereco de acordo com o cep

//    ---------------------------------------------------------
//    Para quando for VARCHAR ou TEXT

    public int alterarEndereco(String cep, String coluna, String textoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE endereco SET "+coluna+" = ? WHERE cep = ?"); // Criando a instrução para setar os parametros

            //        Setando os parametros
            conexao.pstmt.setString(1, textoNovo);
            conexao.pstmt.setString(2, cep);

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

    public int alterarEndereco(String cep, String coluna, int numNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE cursos SET numero = ? WHERE cep = ?"); // Criando a instrução para setar os parametros

            //        Setando os parametros
            conexao.pstmt.setInt(1, numNovo);
            conexao.pstmt.setString(2, cep);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();// Fechando a conexão com o BD
        }
    }


//    =================================================================================================
//    Método para obter toods os dados de enderecos
    public Endereco buscarEnderecoPorIdUsuario(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM endereco " +
                                                               "WHERE endereco.cep = " +
                    "                             (SELECT cep_endereco FROM usuario WHERE id = ?)"); //Preparando a instrução SQL


//            Setando os parâmetros
            conexao.pstmt.setInt(1, id);

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            if(conexao.rs.next()){
                return new Endereco(conexao.rs.getString("CEP"),
                                    conexao.rs.getString("RUA"),
                                    conexao.rs.getString("ESTADO"),
                                    conexao.rs.getString("CIDADE"),
                                    conexao.rs.getString("COMPLEMENTO"),
                                    conexao.rs.getInt("NUMERO")); //Retornando o objeto
            }

            return null;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }


}
