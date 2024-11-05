package com.khita_servlet.controller.preferencia;

import com.khita_servlet.dao.CategoriaDAO;
import com.khita_servlet.dao.PreferenciaDAO;
import com.khita_servlet.dao.UsuarioDAO;
import com.khita_servlet.model.Categoria;
import com.khita_servlet.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "desalocarPreferencia", value = "/pages/paginas-principais/desalocar-preferencia")
public class DesalocarPreferencia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Instanciando os objetos modificadores de BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        // Pegando os parâmetros como String
        String email = req.getParameter("email").strip();
        String nomeCategoria = req.getParameter("categoria");

        // Pegando os usuários do BD
        Usuario usuario = usuarioDAO.buscarUsuarioPeloEmail(email);
        Categoria categoria = categoriaDAO.buscarCategoriaPeloNomeCategoria(nomeCategoria);

        if (usuario == null){
            // Caso o usuário não exista
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Não existe um usuário com este e-mail");

        } else if (categoria == null) {
            // Caso a categoria não exista
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Não existe uma categoria com este nome");

        } else{
            // Caso os dois existam
            PreferenciaDAO preferenciaDAO = new PreferenciaDAO();

            if (!preferenciaDAO.preferenciaJaAlocada(usuario.getId(),categoria.getId())){
                // Caso esta categoria já não esteja alocada
                req.setAttribute("erro", true);
                req.setAttribute("mensagem", "Esta categoria já não era de preferência desse usuário");

            } else if (preferenciaDAO.removerPreferencia(usuario.getId(),categoria.getId())>0) {
                // Caso a preferencia tenha sido removida
                req.setAttribute("erro", false);
                req.setAttribute("mensagem", "Preferência desalocada");

            } else{
                // Caso tenha ocorrido um erro no banco
                req.setAttribute("erro", true);
                req.setAttribute("mensagem", "Ocorreu um erro com o banco de dados, tente novamente");

            }

            // Mandando para a página onde estará o resultado da ação
            req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);

        }


    }
}
