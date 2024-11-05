import com.khita_servlet.model.*;
import com.khita_servlet.dao.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

////        Área de testes para as classes normais
////        ---------------------------------------------------------
//
//        Administrador adm = new Administrador("scorpigabriel@gmail.com","000", "Gabriel TXT");
//        Categoria cat1 = new Categoria("Patchwork", adm);
//        Categoria cat2 = new Categoria("Jeans", adm);
//        Categoria cat3 = new Categoria("Calça", adm);
//
//        Usuario user1 = new Usuario("123.321.741-56","Gabriel", "Teixeira Ferreira",
//                "11 97272-1700", "gabriel.ferreira@germinare.org.br", "123321",
//                "Comprador", 8.6, true, "2009-01-17",
//                new Endereco("03660-050", "Rua Dené", "SP", "São Paulo", 137),
//                new Categoria[]{cat1,cat2,cat3}, "Homem", "nenhuma");
//
//        System.out.println(user1+"\n");
//
//        Categoria cat4 = new Categoria("Tênis", adm);
//
//        user1.adicionarPreferencia(cat4);
//
//        System.out.println(user1+"\n");
//
//        if (user1.removerPreferencia(cat4)){
//            System.out.println("Removeu");
//        }else {
//            System.out.println("Não possui esta preferencia para remover");
//        }
//
//        System.out.println(user1);






//        Área de testes para as classes DAO
//        ---------------------------------------------------------
//        Conexao conexao = new Conexao();
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        AdministradorDAO administradorDAO = new AdministradorDAO();
//        CategoriaDAO categoriaDAO = new CategoriaDAO();
//
//        if (conexao.conectar()){
//            System.out.println("foi");
//            conexao.desconectar();
//        }else{
//            System.out.println("nem");
//        }
//
//        ResultSet usuariosRs = usuarioDAO.buscarUsuarios();
//        ResultSet categoriaRS = categoriaDAO.buscarCategoria();
//        System.out.println(usuariosRs);
//
//        try {
//            System.out.println("oi");
//            categoriaRS.next();
//            categoriaRS.next();
//            if (usuariosRs.next()){
//                System.out.println("ID               NOME                TELEFONE");
//                do {
//                    System.out.printf("%d %25s %20s\n", usuariosRs.getInt("id"), usuariosRs.getString("nome")+" "+usuariosRs.getString("sobrenome"), usuariosRs.getString("telefone"));
//                }while (usuariosRs.next());
//            }
//            System.out.println(categoriaRS.getInt("id_administrador"));
//
//        }catch (SQLException sqle){
//            sqle.printStackTrace();
//        }




//        if (administradorDAO.login("giovanna@gmail.com", "#Gigi2024")){
//            System.out.println("logou");
//        }else{
//            System.out.println("senha errada");
//        }


//        System.out.println(administradorDAO.buscarAdmPeloEmailESenha("giovanna@gmail.com","#Gigi2024"));

        // System.out.println(administradorDAO.inserirAdministrador("gaga@gmail.com", "Biel/161723", "Gigiobriel"));

//        System.out.println(usuarioDAO.buscarIdPeloEmail("caio@gmail.com"));
//        System.out.println(usuarioDAO.modificarPremium(usuarioDAO.buscarIdPeloEmail("caio@gmail.com"), true));


        //System.out.println(usuarioDAO.buscarUsuarioPeloId(1));

//        System.out.println(categoriaDAO.inserirCategoria(7, "Patchwork",1));


//        System.out.println(usuarioDAO.buscarUsuarioPeloEmail("gabriel.ferreira@germinare.org.br"));
        String url = "https://www.youtube.com/watch?v=1t1HMENPn3o";

        url=url.split("v=")[1].substring(0,11);

        System.out.println(url);

        String videoId = url; // Substitua pelo ID do vídeo do YouTube
        String apiKey = System.getenv("LINK_API"); // Substitua pela sua chave de API do YouTube

        int duration = YouTubeVideoInfo.getVideoDuration(videoId, apiKey);
        System.out.println("Duração do vídeo: " + duration);

        System.out.println("Título do video: "+YouTubeVideoInfo.getVideoTitle(videoId,apiKey));


    }

}
