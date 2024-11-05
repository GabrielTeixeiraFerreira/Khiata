package com.khita_servlet.controller.tipoCurso;

import com.khita_servlet.dao.TipoCursoDAO;
import com.khita_servlet.model.TipoCurso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="registrarTipo", value = "/pages/paginas-principais/registrar-tipo")
public class RegistrarTipo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Instanciando o objeto modificador de BD
        TipoCursoDAO tipoCursoDAO = new TipoCursoDAO();

        // Pegando os parâmetros como String
        String tipo = req.getParameter("tipo");

        // Criando o objeto que vai ser inserido dentro do banco de dados
        TipoCurso tipoCurso = new TipoCurso(tipo);

        // Verificando se o tipo possui pelo menos uma letra
        if (!tipoCurso.getTipo().matches("[A-Za-z]")){

            // Tentando inserir o tipo de curso no banco
            if (tipoCursoDAO.inserirTipoCurso(tipoCurso.getTipo())>0){
                // Caso tenha inserido vai mandar mensagem de inclusão
                req.setAttribute("erro", false);
                req.setAttribute("mensagem", "Tipo de curso inserido com sucesso!");

            } else{
                // Caso tenha ocorrido um erro no banco
                req.setAttribute("erro", true);
                req.setAttribute("mensagem", "Ocorreu um erro ao inserir o tipo de curso, tente novamente.");
            }

        } else{
            // Caso não possua vai mandar mensagem de erro
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "O tipo de curso deve possuir pelo menos uma letra.");
        }

        // Mandando para a página com o resultado da ação
        req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);

    }



}
