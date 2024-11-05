
package com.khita_servlet.dao;
import java.sql.*;

public class Conexao {

//    Atributos de conexão para realizar as operações do CRUD
    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;


//    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
//    Método para conectar no Banco de dados
    public boolean conectar() {
        try {

//            Declarando o tipo de banco de dados a ser conectado (opcional)
            Class.forName("org.postgresql.Driver");

//            Criando a conexão com o banco usando o usuário adm
            this.conn = DriverManager.getConnection(
                    "jdbc:postgresql://"+System.getenv("BD_LINK"), //<-- link do BD
                    System.getenv("BD_USER"), // <-- Usuário do BD
                    System.getenv("BD_PASSWD")); // <-- Senha do BD

            return true; // <-- a conexão funcionou

        } catch (SQLException | ClassNotFoundException sqle) {
            sqle.printStackTrace();
            return false; // <-- ocorreu um erro com a conexão
        }
    }



//    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
//    Método para desconectar o BD
    public void desconectar(){
        try {

//                Verificando se a conexão está aberta para que seja possivel fecha-la
            if (conn!=null && !conn.isClosed()){
                conn.close(); // <-- encerrando a conexão com o banco de dados
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

}
