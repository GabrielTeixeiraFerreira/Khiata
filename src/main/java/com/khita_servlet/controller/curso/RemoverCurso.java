package com.khita_servlet.controller.curso;

import com.khita_servlet.dao.CursoDAO;
import com.khita_servlet.model.Curso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "removerCurso", value = "/pages/paginas-principais/remover-curso")
public class RemoverCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Instanciando objeto modificador de BD
        CursoDAO cursoDAO = new CursoDAO();

        // Pegando os parâmetros como String
        String linkVideo = req.getParameter("link-video");

        // Pegando o curso do BD a partir do link
        Curso curso = cursoDAO.buscarCursoPeloLink(linkVideo);

        if (curso != null){
            // Caso o curso exista

            if (cursoDAO.removerCurso(curso.getId())>0){
                // Caso o curso tenha sido removido
                req.setAttribute("erro", false);
                req.setAttribute("mensagem", "Curso removido com sucesso");

            } else{
                // Caso não tenha sido possível remover este curso
                req.setAttribute("erro", true);
                req.setAttribute("mensagem", "Ocorreu um erro com o banco de dados ou este curso está presente em outra tabela.");
            }

        } else{
            // Caso o curso não exista
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Curso não existe");
        }

        // Mandando para a página com mensagem de retorno
        req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);

    }
}
