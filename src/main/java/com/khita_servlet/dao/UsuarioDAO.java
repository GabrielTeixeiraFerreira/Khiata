package com.khita_servlet.dao;

import com.khita_servlet.model.Categoria;
import com.khita_servlet.model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {


//    =====================================================================================
//    Método para inserir valores dentro do BD na tabela de usuario
    public int inserirUsuario( String cpf,String nome, String sobrenome, String telefone, String email, String senha,
                               String tp_cliente, double nota_avaliacao, boolean premium, String cep_endereco, String data_nascimento,
                               String genero, String url_foto){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into usuario " +
                    "(CPF,NOME, SOBRENOME, TELEFONE, EMAIL, SENHA, TP_CLIENTE, " + // <-- colunas
                    "NOTA_AVALIACAO, PREMIUM, CEP_ENDERECO, DATA_NASCIMENTO, GENERO, URL_FOTO) " + // <-- colunas
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");  // <-- parametros

//                Setando os parametros
            conexao.pstmt.setString(1,cpf);
            conexao.pstmt.setString(2,nome);
            conexao.pstmt.setString(3,sobrenome);
            conexao.pstmt.setString(4,telefone);
            conexao.pstmt.setString(5,email);
            conexao.pstmt.setString(6,senha);
            conexao.pstmt.setString(7,tp_cliente);
            conexao.pstmt.setDouble(8,nota_avaliacao);
            conexao.pstmt.setBoolean(9,premium);
            conexao.pstmt.setString(10,cep_endereco);
            conexao.pstmt.setString(11, data_nascimento);
            conexao.pstmt.setString(12,genero);
            conexao.pstmt.setString(13,url_foto);


            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando a conexão com BD
        }
    }

//    Para inserir ID manualmente
    public int inserirUsuario( int id,String cpf,String nome, String sobrenome, String telefone, String email, String senha,
                               String tp_cliente, double nota_avaliacao, boolean isPremium, String cep_endereco, String data_nascimento,
                               String genero, String url_foto){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo a conexão com BD
        try {

            // Criando a instrução com parametros a definir
            conexao.pstmt = conexao.conn.prepareStatement("insert into usuario " +
                    "(CPF,NOME, SOBRENOME, TELEFONE, EMAIL, SENHA, TP_CLIENTE, " +    // <-- colunas
                    "NOTA_AVALIACAO, PREMIUM, CEP_ENDERECO, DATA_NASCIMENTO, ID, GENERO, URL_FOTO) " + // <-- colunas
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  // <-- parametros

    //                Setando os parametros
            conexao.pstmt.setString(1,cpf);
            conexao.pstmt.setString(2,nome);
            conexao.pstmt.setString(3,sobrenome);
            conexao.pstmt.setString(4,telefone);
            conexao.pstmt.setString(5,email);
            conexao.pstmt.setString(6,senha);
            conexao.pstmt.setString(7,tp_cliente);
            conexao.pstmt.setDouble(8,nota_avaliacao);
            conexao.pstmt.setBoolean(9,isPremium);
            conexao.pstmt.setString(10,cep_endereco);
            conexao.pstmt.setString(11, data_nascimento);
            conexao.pstmt.setInt(12,id);
            conexao.pstmt.setString(13,genero);
            conexao.pstmt.setString(14,url_foto);


            return conexao.pstmt.executeUpdate(); // Executando e retornando a quantidade de linhas que mudaram


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return -1; //Retornando um número negativo que indica que ocorreu um problema com o BD
        }finally {
            conexao.desconectar();//Fechando a conexão com BD
        }
    }


//    =================================================================================================
//        Método para remover completamente um úsuario de acordo com seu ID
    public int removerUsuario(int id){
        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD

        String remover = "DELETE FROM USUARIO WHERE ID = ?"; //Criando a instrução em uma variável separada
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


//    =================================================================================================
//    Método para atualizar o valor de um campo

//    ------------------------------------------------------------
//    Método para quando for boolean
    public int modificarPremium(int id, boolean boolNovo){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexao

        try {
            conexao.pstmt = conexao.conn.prepareStatement("UPDATE usuario SET premium = ? WHERE id = ?"); // Criando a instrução para setar os parametros

            //   Setando os parametros
            conexao.pstmt.setBoolean(1, boolNovo);
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
//    Método para obter toods os dados de usuarios
    public Usuario[] buscarUsuarios(){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM USUARIO ORDER BY ID"); //Preparando a instrução SQL

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            List<Usuario> usuarioList = new ArrayList<>();
            int qtdUsuarios = 0;

            if (conexao.rs.next()){
                do {
                    usuarioList.add(
                            buscarUsuarioPeloEmail(
                                    conexao.rs.getString("email")));
                    qtdUsuarios++;
                }while (conexao.rs.next());

                return usuarioList.toArray(new Usuario[qtdUsuarios]);

            }else {
                return new Usuario[0];
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }


//    =============================================================================================
//    Método que retorna o objeto de usuário de acordo com o id passado por ele

    public Usuario buscarUsuarioPeloEmail(String email){

        //Criando objeto para criar a conexao e criar os métodos do BD
        Conexao conexao = new Conexao();

        conexao.conectar(); //Abrindo conexão com BD
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM USUARIO WHERE EMAIL = ?"); //Preparando a instrução SQL

            // Setando o parâmetro
            conexao.pstmt.setString(1, email);

            conexao.rs = conexao.pstmt.executeQuery(); //Armazenando o Select dentro do objeto ResultSet

            // Passando para a próxima linha
            // Caso não possua linhas vai retornar nulo
            if (!conexao.rs.next()){
                return null;
            }

            // Recebendo o valor do ID do usuário para conseguir suas preferencias
            int id = conexao.rs.getInt("id");

            // Objeto que vai armazenar a Query de preferências do usuário
            ResultSet rsPreferencia;

            // Criando a Query e armazenando no pstmt
             conexao.pstmt = conexao.conn.prepareStatement("select categoria.categoria from preferencias " +
                    "join categoria on categoria.id = preferencias.id_categoria " +
                    "where preferencias.id_usuario = ?");

             // Setando o parâmetro de id do usuário
            conexao.pstmt.setInt(1, id);

            // Armazenando a Query no objeto criado para isso
            rsPreferencia = conexao.pstmt.executeQuery();

            // Criando uma List de Categoria que são as preferências do usuário
            // Essa List vai se tornar um vetor que fica dentro do objeto de Usuário
            List<Categoria> preferenciasList = new ArrayList<>();

            // Instanciando uma variável que irá armazenar a quantidade de preferências para a futura criação do vetor
            int qtdPreferencias = 0;

            // Instanciando o vetor que irá ser adicionado no objeto de Usuário
            Categoria[] preferenciasVetor;

            // Instanciando um objeto que irá buscar o objeto de Categoria conforme as categorias adquiridas na Query de cima
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            // Buscando todas as preferências da Query e diretamente adicionando na List
            while (rsPreferencia.next()){
                preferenciasList.add( categoriaDAO.buscarCategoriaPeloNomeCategoria(rsPreferencia.getString("categoria"))
                );
                qtdPreferencias++;
            }

            // Transformando a List em vetor com o tamanho adequado
            preferenciasVetor = preferenciasList.toArray(new Categoria[qtdPreferencias]);

            // Retornando o objeto de Usuário com todos os dados preenchidos, inclusive as suas preferências
            return new Usuario( conexao.rs.getInt("id"),
                                conexao.rs.getString("cpf"),
                                conexao.rs.getString("nome"),
                                conexao.rs.getString("sobrenome"),
                                conexao.rs.getString("telefone"),
                                conexao.rs.getString("email"),
                                conexao.rs.getString("senha"),
                                conexao.rs.getString("tp_cliente"),
                                conexao.rs.getDouble("nota_avaliacao"),
                                conexao.rs.getBoolean("premium"),
                                conexao.rs.getString("data_nascimento"),
                                conexao.rs.getString("cep_endereco"),
                                preferenciasVetor,
                                conexao.rs.getString("genero"),
                                conexao.rs.getString("url_foto")
                                );

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            conexao.desconectar(); //Fechando conexao com BD
        }
    }
}
