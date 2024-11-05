package com.khita_servlet.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {

//    ========================================================================================================
//    Método para adicionar pedido no BD
    public int inserirPedido(double total_a_pagar, Date dt_pedido, Date dt_entrega,
                             int id_comprador, int id_costureiro, int num_nota_fiscal){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com o BD

        try {

            conexao.pstmt = conexao.conn.prepareStatement("insert into pedido " +
                    "(TOTAL_A_PAGAR, DT_PEDIDO, DT_ENTREGA, ID_COMPRADOR, ID_COSTUREIRO, NUM_NOTA_FISCAL)" + // <-- Colunas
                    "values (?,?,?,?,?,?)"); // <-- Parametros

//            Setando os parametros
            conexao.pstmt.setDouble(1,total_a_pagar);
            conexao.pstmt.setDate(2,dt_pedido);
            conexao.pstmt.setDate(3,dt_entrega);
            conexao.pstmt.setInt(4, id_comprador);
            conexao.pstmt.setInt(5, id_costureiro);
            conexao.pstmt.setInt(6, num_nota_fiscal);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando a conexao com o BD
        }
    }

//    ---------------------------------------------------------
//    Para colocar manualmente o id
    public int inserirPedido(int id,double total_a_pagar, Date dt_pedido, Date dt_entrega,
                             int id_comprador, int id_costureiro, int num_nota_fiscal){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com o BD

        try {

            conexao.pstmt = conexao.conn.prepareStatement("insert into pedido " +
                    "(TOTAL_A_PAGAR, DT_PEDIDO, DT_ENTREGA, ID_COMPRADOR, ID_COSTUREIRO, NUM_NOTA_FISCAL, ID)" + // <-- Colunas
                    "values (?,?,?,?,?,?,?)"); // <-- Parametros

            //            Setando os parametros
            conexao.pstmt.setDouble(1,total_a_pagar);
            conexao.pstmt.setDate(2,dt_pedido);
            conexao.pstmt.setDate(3,dt_entrega);
            conexao.pstmt.setInt(4, id_comprador);
            conexao.pstmt.setInt(5, id_costureiro);
            conexao.pstmt.setInt(6, num_nota_fiscal);
            conexao.pstmt.setInt(7,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando a conexao com o BD
        }
    }

//    ==================================================================================================
//    Removendo um pedido inteiro pelo ID
    public int removerPedido(int id){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexao com o BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("delete from pedido where id = ?"); //Preparando instrução SQL

//            Setando os parametros
            conexao.pstmt.setInt(1,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando a conexao com BD
        }
    }



//    ==================================================================================================
//    Métodos para mudar valores por colunas pelo id

//    ---------------------------------------------------
//    Pra quando for Double (total)
    public int alterarPedido(int id, String coluna, double precoNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {

            conexao.pstmt = conexao.conn.prepareStatement("update pedido set "+coluna+" = ? where id = ?"); //Preparando a instrução SQL

//            Setando os parametros
            conexao.pstmt.setDouble(1, precoNovo);
            conexao.pstmt.setInt(2,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }

//    ---------------------------------------------------
//    Pra quando for Date (data_pedido e data_entrega)
    public int alterarPedido(int id, String coluna, Date dataNova){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {

            conexao.pstmt = conexao.conn.prepareStatement("update pedido set "+coluna+" = ? where id = ?"); //Preparando a instrução SQL

//            Setando os parametros
            conexao.pstmt.setDate(1, dataNova);
            conexao.pstmt.setInt(2,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }


//    ---------------------------------------------------
//    Pra quando for Int (num_nota_fiscal. id_costureiro e id_comprador)
    public int alterarPedido(int id, String coluna, int numNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao com BD

        try {

            conexao.pstmt = conexao.conn.prepareStatement("update pedido set "+coluna+" = ? where id = ?"); //Preparando a instrução SQL

//            Setando os parametros
            conexao.pstmt.setInt(1, numNovo);
            conexao.pstmt.setInt(2,id);

            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }


//    =================================================================================================
//    Método para obter toods os dados de pedidos
    public ResultSet buscarPedidos(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM USUARIO ORDER BY ID"); //Preparando a instrução SQL

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
