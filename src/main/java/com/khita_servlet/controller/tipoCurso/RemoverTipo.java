package com.khita_servlet.controller.tipoCurso;

import com.khita_servlet.dao.CursoDAO;
import com.khita_servlet.dao.TipoCursoDAO;
import com.khita_servlet.model.TipoCurso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "removerTipo", value = "/pages/paginas-principais/remover-tipo")
public class RemoverTipo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TipoCursoDAO tipoDAO = new TipoCursoDAO();
        CursoDAO cursoDAO = new CursoDAO();

        // Instanciando o objeto modificador de BD
        TipoCursoDAO tipoCursoDAO = new TipoCursoDAO();

        // Pegando os parâmetros como String
        String tipo = req.getParameter("tipo");

        // Pegando o objeto do Banco
        TipoCurso tipoCurso = tipoCursoDAO.buscarTipoCursoPeloTipo(tipo);

        if (tipoCurso != null){
            // Caso exista esse tipo de curso

            if (tipoCursoDAO.removerTipoCurso(tipoCurso.getId())>0){
                // Caso consiga remover
                req.setAttribute("erro", false);
                req.setAttribute("mensagem", "Tipo de curso removido com sucesso");

            } else{
                // Caso não consiga remover
                req.setAttribute("erro", true);
                req.setAttribute("mensagem", "Ocorreu um erro com o banco de dados ou esse tipo de curso está alocado a um curso.");
            }

        } else{
            // Caso não possua esse tipo de curso no banco
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Não existe esse tipo de curso");
        }

        // Mandando para a página com o resultado da ação
        req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);

    }

}

