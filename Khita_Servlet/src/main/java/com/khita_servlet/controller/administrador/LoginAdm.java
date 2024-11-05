package com.khita_servlet.controller.administrador;


import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;

import com.khita_servlet.dao.AdministradorDAO;

@WebServlet(name = "loginADM", value="/pages/paginas-principais/login-adm")
public class LoginAdm extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Criando o objeto modificador de BD
        AdministradorDAO administradorDAO = new AdministradorDAO();

//        Recebendo os parâmetros como String
        String email = req.getParameter("email").strip();
        String senha = req.getParameter("senha").strip();


//        Verificando se é possível entrar no banco com esse conjunto de informações
            if (administradorDAO.login(email,senha)) {
                // Jogar para página oculta para ADMs
                req.getRequestDispatcher("/pages/paginas-principais/area-oculta.jsp").forward(req,resp);
            }else{
                // Colocar uma mensagem de erro dizendo que o login está errado
                req.getRequestDispatcher("/pages/paginas-mensagem/login-erro.jsp").forward(req,resp);
            }

    }
}
