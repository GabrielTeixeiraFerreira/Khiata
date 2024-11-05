package com.khita_servlet.controller.administrador;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;

import com.khita_servlet.dao.AdministradorDAO;
import com.khita_servlet.model.Administrador;

@WebServlet(name = "mostrarAdm", value = "/pages/paginas-principais/mostrarAdm")
public class MostrarAdm extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Criando o objeto modificador de BD
        AdministradorDAO administradorDAO = new AdministradorDAO();

//        Criando o objeto que armazena todos os adms do BD
        Administrador[] admsMostrar = administradorDAO.buscarAdministrador();

        // Setando os atributos
        req.setAttribute("qtdAdms", admsMostrar.length); // <-- colocando o atributo que diz a quantidade de adms no sistema
        req.setAttribute("adms", admsMostrar); // <-- colocando o atributo dos adms para percorrer no JSP


        // Enviando para a página onde estará a tabela com todos os administradores cadastrados no sistema
        req.getRequestDispatcher("/pages/paginas-mostrar/area-oculta-mostrar-administrador.jsp").forward(req,resp);


    }
}
