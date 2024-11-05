package com.khita_servlet.controller.preferencia;

import java.io.*;


import com.khita_servlet.dao.PreferenciaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;

import com.khita_servlet.dao.CategoriaDAO;
import com.khita_servlet.dao.UsuarioDAO;
import com.khita_servlet.model.Categoria;
import com.khita_servlet.model.Usuario;

@WebServlet(name = "alocarPreferencia" , value = "/pages/paginas-principais/alocar-preferencia")
public class AlocarPreferencia extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PreferenciaDAO preferenciaDAO = new PreferenciaDAO();


        String email = req.getParameter("email").strip();
        String nomeCategoria = req.getParameter("categoria").strip();


        Usuario usuario = usuarioDAO.buscarUsuarioPeloEmail(email);
        Categoria preferencia = categoriaDAO.buscarCategoriaPeloNomeCategoria(nomeCategoria);

        if (usuario == null){
            // Caso o usuário não exista
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Usuário não existe ou seu e-mail foi digitado errado");

        } else if (preferencia == null) {
            // Caso a categoria não exista
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Categoria não existe ou seu nome foi digitado errado");

        } else if (preferenciaDAO.preferenciaJaAlocada(usuario.getId(), preferencia.getId())) {
            // Caso a preferência já tenha sido alocada naquele usuário
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Preferência já tinha sido alocada a esse usuário");

        } else if (preferenciaDAO.inserirPreferencia(usuario.getId(), preferencia.getId())>0){
            // Caso a categoria seja inserida
            usuario.adicionarPreferencia(preferencia);

            req.setAttribute("erro", false);
            req.setAttribute("mensagem", "Preferência foi alocada ao usuário");

        } else {
            // Caso dê erro no banco
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Ocorreu um erro com o banco de dados, tente novamente.");
        }

        req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);

    }
}
