package com.khita_servlet.controller.administrador;


import java.io.*;

import com.khita_servlet.model.Administrador;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;

import com.khita_servlet.dao.AdministradorDAO;

@WebServlet(name = "registrarAdministrador", value="/pages/paginas-principais/registrar-administrador")

public class RegistrarAdm extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Criando o objeto modificador de BD
        AdministradorDAO administradorDAO = new AdministradorDAO();

//        Recebendo os parâmetros como String já removendo os espaços da senha e do e-mail
        String nomeCompleto = req.getParameter("nome_completo");
        String email        = req.getParameter("email").strip();
        String senha        = req.getParameter("senha").strip();

        Administrador administrador = new Administrador(email,senha,nomeCompleto);


        // Verificando se esta dentro do padrão: exemplo@empresa.???(.br)
        // e verificando se a senha possui: 8 caracteres, letra minuscula e maiúscula
        //                                  número e caractere especial
        if (administrador.getEmail().matches("^[^.][a-zA-Z0-9._%+-].*@.*[.][a-z]{3}[.br]?")
         && administrador.getSenha().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$")){

            if (administradorDAO.inserirAdministrador(administrador.getEmail(),
                                         administrador.getSenha(),
                                         administrador.getNome_completo()) > 0){
                // Retorne uma página avisando que foi cadastrado
                req.setAttribute("erro", false);
                req.setAttribute("mensagem", "Administrador foi inserido com sucesso");
            }else{
                // Erro no banco
                req.setAttribute("erro", true);
                req.setAttribute("mensagem", "Ocorreu um erro ao inserir o administrador, tente novamente");
            }

        } else{
            // Dados não batem com o valor esperado
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Credenciais erradas, insira o e-mail corretamente.\n" +
                                                "A senha deve conter um mínimo de 8 caracteres, um maiúsculo e um minúsculo, um número e um caractere especial");
        }

//        Mandando para a página com a mensagem
        req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);
    }
}
