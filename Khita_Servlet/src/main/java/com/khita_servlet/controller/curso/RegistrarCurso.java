package com.khita_servlet.controller.curso;

import com.khita_servlet.dao.CursoDAO;
import com.khita_servlet.dao.TipoCursoDAO;
import com.khita_servlet.model.Curso;
import com.khita_servlet.model.TipoCurso;
import com.khita_servlet.model.YouTubeVideoInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registrarCurso", value = "/pages/paginas-principais/registrar-curso")
public class RegistrarCurso extends  HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Instanciando o objeto modificador de BD
        TipoCursoDAO tipoCursoDAO = new TipoCursoDAO();

        // Pegando os parâmetros como String
        String linkVideo = req.getParameter("link-video");
        String tipoCursoString = req.getParameter("tipo");

        // Verificando se existe um tipo com esse nome
        TipoCurso tipoCurso = tipoCursoDAO.buscarTipoCursoPeloTipo(tipoCursoString);

        if (tipoCurso == null){
            // Caso não exista tipo de curso indicado
            req.setAttribute("erro", true);
            req.setAttribute("mensagem", "Tipo de curso não existe");
        }
        else{
            // Verificando se o link está valido
            if (!linkVideo.matches("^https://www.youtube.com/watch\\?v=.{11}.*$")){
                // Link inválido para link do youtube
                req.setAttribute("erro", true);
                req.setAttribute("mensagem", "Link do YouTube está inválido");

            } else{

                // Pegando o id do vídeo a partir de sua URL
                String idVideo = linkVideo.split("v=")[1].substring(0,11);

                // Recebendo os valores necessários para o banco a partir do vídeo do YouTube
                String linkThumbnail = "https://img.youtube.com/vi/"+idVideo+"/maxresdefault.jpg";
                int segundos = YouTubeVideoInfo.getVideoDuration(idVideo, System.getenv("LINK_API"));
                String titulo = YouTubeVideoInfo.getVideoTitle(idVideo, System.getenv("LINK_API"));

                // Instanciando o objeto que irá segurar os valores a serem inseridos no banco
                Curso curso = new Curso(linkThumbnail, segundos, titulo, linkVideo, new String[0],tipoCurso);

                // Instanciando o objeto modificador de BD
                CursoDAO cursoDAO = new CursoDAO();

                // Caso consiga inserir
                if (cursoDAO.inserirCurso(
                        curso.getThumbnail(),
                        curso.getDuracao_segundos(),
                        curso.getTitulo(),
                        curso.getLink_video(),
                        curso.getTipo_curso().getId()) > 0){
                    req.setAttribute("erro", false);
                    req.setAttribute("mensagem", "Curso inserido com sucesso");
                }

                // Caso não consiga inserir
                else {
                    req.setAttribute("erro", true);
                    req.setAttribute("mensagem", "Ocorreu um erro no banco de dados ao inserir um curso");
                }

            }
        }

        // Enviando para a página com as possíveis mensagens
        req.getRequestDispatcher("/pages/paginas-mensagem/area-oculta-mensagem.jsp").forward(req,resp);


    }
}
