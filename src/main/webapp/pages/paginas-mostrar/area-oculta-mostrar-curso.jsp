<%@ page import="com.khita_servlet.model.Curso" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../paginas-mensagem/404.jsp"%>
<html>
  <head>
    <title>Cursos</title>
    <link rel="stylesheet" href="../../css/tabela.css" />
  </head>
  <body>
    <div class="table-content">
      <table>
        <tr>
          <th>Id</th>
          <th>Thumbnail</th>
          <th>Titulo</th>
          <th>Duração(Sec)</th>
          <th>Tipo</th>
          <th>Link</th>
        </tr>

        <% int qtdCursos = (int) request.getAttribute("qtdCursos"); Curso[]
        cursos = (Curso[]) request.getAttribute("cursos"); for (int i = 0; i <
        qtdCursos; i++) {%>

        <tr>
          <td><%= cursos[i].getId() %></td>
          <td><img src="<%= cursos[i].getThumbnail() %>" alt="Thumbnail" /></td>
          <td><%= cursos[i].getTitulo() %></td>
          <td><%= cursos[i].getDuracao_segundos() %></td>
          <td><%= cursos[i].getTipo_curso().getTipo() %></td>
          <td><%= cursos[i].getLink_video() %></td>
        </tr>

        <% } %>
      </table>
    </div>
    <!-- Botão para voltar para página principal -->
    <div class="voltar">
      <a href="../paginas-principais/area-oculta.jsp" class="botao-voltar">
        <img src="../../assets/voltar.png" alt="Voltar" />
        <span>Voltar</span>
      </a>
    </div>
  </body>
</html>
