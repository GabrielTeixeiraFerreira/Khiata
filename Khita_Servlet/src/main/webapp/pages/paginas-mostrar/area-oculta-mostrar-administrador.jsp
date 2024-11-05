<%@ page import="com.khita_servlet.model.Administrador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../paginas-mensagem/404.jsp" %>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../css/tabela.css" />
    <title>Administradores</title>
  </head>
  <body>
    <div class="table-content">
      <table>
        <tr>
          <th>Id</th>
          <th>Nome Completo</th>
          <th>E-mail ADM</th>
          <th>Senha ADM</th>
        </tr>

        <% int qtdAdministradores = (int) request.getAttribute("qtdAdms");
        Administrador[] administradores = (Administrador[])
        request.getAttribute("adms"); for (int i = 0; i < qtdAdministradores;
        i++) {%>

        <tr>
          <td><%= administradores[i].getId() %></td>
          <td><%= administradores[i].getNome_completo() %></td>
          <td><%= administradores[i].getEmail() %></td>
          <td><%= administradores[i].getSenha() %></td>
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
