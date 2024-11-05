package com.khita_servlet.controller.categoria;

import java.io.*;

import com.khita_servlet.model.Administrador;
import com.khita_servlet.model.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;

import com.khita_servlet.dao.AdministradorDAO;
import com.khita_servlet.dao.CategoriaDAO;

@WebServlet(name = "registrarCategoria", value = "/pages/paginas-principais/registrar-categoria")
public class RegistrarCategoria extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Criando o objeto modificador de BD
        AdministradorDAO administradorDAO = new AdministradorDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();

//        Recebendo os parâmetros como String removendo os espaços
        String email         = req.getParameter("email").strip();
        String senha         = req.getParameter("senha").strip();
        String categoriaNome = req.getParameter("categoria").strip();

        Administrador administrador = new Administrador(email,senha,null);

//        Validando o nome da categoria (só pode letra)
        if (!categoriaNome.matches("^[a-zA-Z]*$")) {
//              Categoria pode conter apenas letras
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Coloque apenas letras no nome da categoria");
        }else {

//             Verificando a existência do ADM
            if (!administradorDAO.login(administrador.getEmail(),
                           administrador.getSenha())){ //<-- caso não exista
//              ADM não existe
                req.setAttribute("erro", true);
                req.setAttribute("mensagem", "Administrador não existe ou está com credenciais erradas");
            }
            else {
//                  Pegando o ID do ADM pelo e-mail e senha passados por ele
                administrador = administradorDAO.buscarAdmPeloEmailESenha(email,senha);

                Categoria categoria = new Categoria(categoriaNome, administrador);

//                 Inserindo categoria no BD
                if (categoriaDAO.inserirCategoria(categoria.getCategoria(),
                                                 categoria.getAdm_criador().getId()) > 0){
                    // Inseriu no BD
                    req.setAttribute("erro", false);
                    req.setAttribute("mensagem", "Categoria inserida com sucesso");
                }else{
                    // Erro no BD
                    req.setAttribute("erro", true);
                    req.setAttribute("mensagem", "Ocorreu um erro no banco de dados, tente novamente");
                }
            }
        }

//        Mandando para a página com a mensagem
        req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);



    }
}
