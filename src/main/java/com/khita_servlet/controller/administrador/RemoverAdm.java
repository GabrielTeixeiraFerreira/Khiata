package com.khita_servlet.controller.administrador;

import com.khita_servlet.dao.AdministradorDAO;
import com.khita_servlet.model.Administrador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "removerAdm", value = "/pages/paginas-principais/remover-administrador")
public class RemoverAdm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Instanciando objeto modificador de BD
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Pegando os parâmetros como String
        String email = req.getParameter("email").strip();
        String senha = req.getParameter("senha").strip();

        // Buscando o ADM no BD
        Administrador administrador = administradorDAO.buscarAdmPeloEmailESenha(email,senha);

        if (administrador != null){
            // Caso o administrador exista

            if (administradorDAO.removerAdministrador(administrador.getId())>0){
                // Administrador removido
                req.setAttribute("erro", false);
                req.setAttribute("mensagem", "Administrador removido com sucesso!");

            }else{
                // Administrador não pode ser removido
                req.setAttribute("erro", true);
                req.setAttribute("mensagem", "Ocorreu um erro com o banco de dados ou este administrador esta associado a alguma categoria.");
            }

        }else{
            // Caso o administrador não exista
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Administrador não existente ou com as credenciais erradas.");
        }

        // Enviando para a página com a mensagem de retorno
        req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);

    }
}
