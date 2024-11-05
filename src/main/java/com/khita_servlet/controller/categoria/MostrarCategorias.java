package com.khita_servlet.controller.categoria;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;

import com.khita_servlet.dao.CategoriaDAO;
import com.khita_servlet.model.Categoria;


@WebServlet(name = "mostrarCategoria", value = "/pages/paginas-principais/mostrar-categorias")
public class MostrarCategorias extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Criando o objeto modificador de BD
        CategoriaDAO categoriaDAO = new CategoriaDAO();

//        Criando o objeto que armazena todas as categorias do BD
        Categoria[] categoriasMostrar = categoriaDAO.buscarCategoria();

        req.setAttribute("categorias", categoriasMostrar); // <-- colocando o atributo das categorias para percorrer no JSP
        req.setAttribute("qtdCategorias", categoriasMostrar.length);

        req.getRequestDispatcher("/pages/paginas-mostrar/area-oculta-mostrar-categoria.jsp").forward(req,resp);







    }
}

