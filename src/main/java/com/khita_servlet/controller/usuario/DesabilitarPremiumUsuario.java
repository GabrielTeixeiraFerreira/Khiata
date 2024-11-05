package com.khita_servlet.controller.usuario;


import java.io.*;

import com.khita_servlet.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;

import com.khita_servlet.dao.UsuarioDAO;


@WebServlet(name = "desabilitarPremium", value = "/pages/paginas-principais/desabilitar-premium")
public class DesabilitarPremiumUsuario extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Criando o objeto modificador de BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();

//        Recebendo os parâmetros como String
        String email = req.getParameter("email").strip();

        // Recebendo o ID do usuário que terá seu premium desabilitado
        Usuario usuario = usuarioDAO.buscarUsuarioPeloEmail(email);

        // Caso o usuário não seja encontrado no banco de dados
        if (usuario == null){
            // Usuário não encontrado
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Usuário não foi encontrado ou não existe, tente novamente.");

        } else if (!usuario.isPremium()){
            // Usuário já não é premium
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Usuário não possui premium para desabilitar.");

        }
        else if (usuarioDAO.modificarPremium( usuario.getId(), false) > 0){ // <-- Agora é premium
            // Habilitou premium
            req.setAttribute("erro", false);
            req.setAttribute("mensagem", "O usuário teve o premium desabilitado");
        } else{
            // Erro no banco
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Ocorreu um erro com o banco de dados, tente novamente.");
        }


//        Mandando para a página com a mensagem
        req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);
    }
}
