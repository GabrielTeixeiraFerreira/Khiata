package com.khita_servlet.controller.categoria;

import java.io.*;

import com.khita_servlet.dao.AdministradorDAO;
import com.khita_servlet.model.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;

import com.khita_servlet.dao.CategoriaDAO;

@WebServlet(name = "removerCategoria", value = "/pages/paginas-principais/remover-categoria")
public class RemoverCategoria extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Criando o objeto modificador de BD
        CategoriaDAO categoriaDAO = new CategoriaDAO();

//        Recebendo os parâmetros
        String categoriaNome = req.getParameter("categoria");

        // Recebendo o objeto da categoria a ser removida
        Categoria categoria = categoriaDAO.buscarCategoriaPeloNomeCategoria(categoriaNome);

        // Removendo categoria
        if (categoria == null) {
            // Categoria não existe
            req.setAttribute("erro",true);
            req.setAttribute("mensagem", "Categoria não existente");

        } else if (categoriaDAO.removerCategoria(categoria.getId())>0 && categoria.getId()>0){
            // Mensagem avisando que removeu
            req.setAttribute("erro", false);
            req.setAttribute("mensagem", "Remoção da categoria ocorreu com sucesso");

        } else{
            // Erro no banco de dados ao remover
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Ocorreu um erro no banco de dados ao remover a categoria ou a categoria está alocada a alguma preferencia ou produto");
        }

//        Mandando para a página com a mensagem
        req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);
    }
}
