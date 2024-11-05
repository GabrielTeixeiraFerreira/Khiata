package com.khita_servlet.controller.usuario;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;

import com.khita_servlet.dao.UsuarioDAO;
import com.khita_servlet.model.Usuario;

@WebServlet(name = "mostrarUsuarios", value = "/pages/paginas-principais/mostrar-usuarios")
public class MostrarUsuarios extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Criando o objeto modificador de BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();

//        Criando o objeto que armazena todos os adms do BD
        Usuario[] usuariosMostrar = usuarioDAO.buscarUsuarios();

        req.setAttribute("usuarios", usuariosMostrar); // <-- colocando o atributo dos usuários para percorrer no JSP
        req.setAttribute("qtdUsuarios", usuariosMostrar.length); // <-- colocando o atributo da quantidade de usuários cadastrados

        // Enviando para a página onde estarão os dados armazenados dos usuários
        req.getRequestDispatcher("/pages/paginas-mostrar/area-oculta-mostrar-usuario.jsp").forward(req, resp);

    }
}
