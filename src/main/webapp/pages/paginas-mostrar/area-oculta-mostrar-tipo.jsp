<%@ page import="com.khita_servlet.model.TipoCurso" errorPage="../paginas-mensagem/404.jsp"%>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../css/tabela.css" />
    <title>Tipos de curso</title>
  </head>
  <body>
    <div class="table-content">
      <table>
        <tr>
          <th>Id</th>
          <th>Tipo de curso</th>
        </tr>
        <% int qtdTipos = (int) request.getAttribute("qtdTipos"); TipoCurso[]
        tiposCurso = (TipoCurso[]) request.getAttribute("tiposCurso"); for (int
        i = 0; i < qtdTipos; i++) {%>
        <tr>
          <td><%= tiposCurso[i].getId() %></td>
          <td><%= tiposCurso[i].getTipo() %></td>
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
