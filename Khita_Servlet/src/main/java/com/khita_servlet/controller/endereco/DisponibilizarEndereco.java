package com.khita_servlet.controller.endereco;

import java.io.*;

import com.khita_servlet.dao.AdministradorDAO;
import com.khita_servlet.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;
import com.khita_servlet.dao.UsuarioDAO;
import com.khita_servlet.dao.EnderecoDAO;
import com.khita_servlet.model.Endereco;

@WebServlet(name = "disponibilizarEndereco", value = "/pages/paginas-principais/disponibilizar-endereco")
public class DisponibilizarEndereco extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Criando o objeto modificador de BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        EnderecoDAO enderecoDAO = new EnderecoDAO();

//        Recebendo os valores de e-mail dos dois usuários
        String emailComprador = req.getParameter("email-comprador").strip();
        String emailVendedor  = req.getParameter("email-vendedor").strip();

//        Adquirindo os IDs e armazenando em variaveis
        Usuario comprador = usuarioDAO.buscarUsuarioPeloEmail(emailComprador);
        Usuario costureiro = usuarioDAO.buscarUsuarioPeloEmail(emailVendedor);

        // Mandando mensagem de erro caso algum dos dois não exista
        if (comprador == null || costureiro == null){
            req.setAttribute("erro",true);
            req.setAttribute("mensagem", "Algum dos dois e-mail não existem ou estão errados");

            // Mandando para a página com a mensagem
            req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);
        }

//        Guardando o endereco do comprador dentro dum objeto
        Endereco enderecoComprador = enderecoDAO.buscarEnderecoPorIdUsuario(comprador.getId());

        // Enviando os objetos necessários para a construção das páginas no JSP posterior
        req.setAttribute("costureiro", costureiro);
        req.setAttribute("comprador", comprador);
        req.setAttribute("endereco", enderecoComprador);

        // Enviando para a página JSP de confirmação
        req.getRequestDispatcher("/pages/paginas-mensagem/mandar-endereco.jsp").forward(req,resp);


    }
}
