<%@ page errorPage="404.jsp" contentType="text/html;charset=UTF-8" language="java" %>
<% Object logado = request.getSession().getAttribute("logado");
    if (logado == null) {
        response.sendRedirect(request.getContextPath() + "/pages/paginas-principais/login.jsp");
    }
%>
<jsp:include page="../paginas-principais/area-oculta.jsp"></jsp:include>
<html>
<head>
    <link rel="stylesheet" href="../../css/erro.css">
    <title>Categoria</title>
</head>
<body>
    <% if ((boolean)request.getAttribute("erro")){%>
    <div id="mensagem">
        <a href="#mensagem">X</a>
        <br>
        <p><%= request.getAttribute("mensagem")%></p>
    </div>
    <% } else { %>
    <div id="mensagem">
        <a href="#mensagem">X</a>
        <br>
        <p style="color: green"><%= request.getAttribute("mensagem")%></p>
    </div>
    <% } %>
</body>
</html>

