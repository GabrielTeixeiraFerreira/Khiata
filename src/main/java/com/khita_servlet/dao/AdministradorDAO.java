package com.khita_servlet.dao;

import com.khita_servlet.model.Administrador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {

//    =====================================================================================
//    Método para inserir valores dentro do BD na tabela de ADM
    public int inserirAdministrador(String email, String senha, String nomeCompleto){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into administrador " +
                    "(EMAIL, SENHA, NOME_COMPLETO) " + // <-- colunas
                    "values (?, FN_CriptografarSenha(?) ,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setString(1,email);
            conexao.pstmt.setString(2,senha);
            conexao.pstmt.setString(3,nomeCompleto);

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
    public int inserirAdministrador(int id,String email, String senha, String nomeCompleto){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into administrador " +
                    "(EMAIL, SENHA, NOME_COMPLETO, ID) " + // <-- colunas
                    "values (?,?,?,?)");  // <-- parametros

            //  Setando os parametros
            conexao.pstmt.setString(1,email);
            conexao.pstmt.setString(2,senha);
            conexao.pstmt.setString(3,nomeCompleto);
            conexao.pstmt.setInt(4,id);

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
    public int removerAdministrador(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        String remover = "DELETE FROM administrador WHERE ID = ?"; //Criando a instrução em uma variável separada
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
//    Método para alterar uma coluna de historico de acordo com o id

//    ---------------------------------------------------------
//    Para quando for VARCHAR ou TEXT

    public int alterarAdministrador(int id, String coluna,String textoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE administrador SET "+coluna+" = ? WHERE id = ?"); // Criando a instrução para setar os parametros

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

    public int alterarAdministrador(int id, int numNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE administrador SET id = ? WHERE id = ?"); // Criando a instrução para setar os parametros

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
//    Método para obter todos os dados de administrador
    public Administrador[] buscarAdministrador(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM administrador ORDER BY ID"); //Preparando a instrução SQL

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            List<Administrador> administradorList = new ArrayList<>();
            int qtdAdministradores = 0;

            if(conexao.rs.next()){
                do {
                    administradorList.add(
                            buscarAdministradorEspecifico(
                                    conexao.rs.getInt("id")
                            )
                    );
                    qtdAdministradores++;
                }while (conexao.rs.next());

                return administradorList.toArray(new Administrador[qtdAdministradores]);

            }else{
                return new Administrador[0];
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    =================================================================================================
//    Método para verificar login do adm
    public boolean login(String email, String senha){
        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            //Preparando a instrução SQL
            conexao.pstmt = conexao.conn.prepareStatement(
                    "SELECT EXISTS(SELECT 1 FROM administrador WHERE EMAIL = ? AND FN_DescriptografarSenha(SENHA) = ?)");

//            Setando parametros
            conexao.pstmt.setString(1,email);
            conexao.pstmt.setString(2,senha);

            conexao.rs = conexao.pstmt.executeQuery();//Armazenando o Select dentro do objeto ResultSet

            conexao.rs.next(); // <-- passando linha

            return conexao.rs.getBoolean(1);

        }catch (SQLException sqle){
            return false;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }


//    =================================================================================================
//    Método para verificar login do adm
    public Administrador buscarAdmPeloEmailESenha(String email, String senha){
        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            //Preparando a instrução SQL
            conexao.pstmt = conexao.conn.prepareStatement(
                    "SELECT * FROM administrador WHERE EMAIL = ? AND FN_DescriptografarSenha(SENHA) = ?");

//            Setando os parâmetros
            conexao.pstmt.setString(1, email);
            conexao.pstmt.setString(2, senha);

            conexao.rs = conexao.pstmt.executeQuery();//Armazenando o Select dentro do objeto ResultSet

            conexao.rs.next(); // <-- caso não existam adms com essa senha e e-mail vai cair no catch

            return new Administrador(conexao.rs.getInt("id"),
                                     conexao.rs.getString("email"),
                                     conexao.rs.getString("senha"),
                                     conexao.rs.getString("nome_completo"));

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    =================================================================================================
//    Método para obter todos os dados de administrador
    public Administrador buscarAdministradorEspecifico(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM administrador WHERE ID = ?"); //Preparando a instrução SQL

            conexao.pstmt.setInt(1, id);

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            conexao.rs.next(); // Passando linha

            return new Administrador(conexao.rs.getInt("id")
                                    ,conexao.rs.getString("email")
                                    ,conexao.rs.getString("senha")
                                    ,conexao.rs.getString("nome_completo")); // Retornadno o objeto de Administrador

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }
}
