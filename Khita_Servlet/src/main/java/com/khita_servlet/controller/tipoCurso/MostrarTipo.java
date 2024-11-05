package com.khita_servlet.controller.tipoCurso;

import com.khita_servlet.dao.TipoCursoDAO;
import com.khita_servlet.model.TipoCurso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mostrarTipo", value = "/pages/paginas-principais/mostrar-tipos")
public class MostrarTipo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Instanciando objeto modificador de BD
        TipoCursoDAO tipoCursoDAO = new TipoCursoDAO();

        // Recebendo os tipos de curso do banco
        TipoCurso[] tiposCurso = tipoCursoDAO.buscarTipoCategoria();

        // Setando os parâmetros que serão utilizados para mostrar os tipos
        req.setAttribute("tiposCurso", tiposCurso);
        req.setAttribute("qtdTipos", tiposCurso.length);

        // Mandando para página que estarão os tipos de curso
        req.getRequestDispatcher("/pages/paginas-mostrar/area-oculta-mostrar-tipo.jsp").forward(req,resp);
    }
}
