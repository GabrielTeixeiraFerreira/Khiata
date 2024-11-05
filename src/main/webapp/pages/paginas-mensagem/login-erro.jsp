<%@ page errorPage="404.jsp" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/erro.css">
    <style>
        #mensagem{
            left: 20vw;
            top: 20vh;
        }
    </style>
    <title>Login</title>
</head>
<jsp:include page="../paginas-principais/login.jsp"></jsp:include>
<body>
    <div id="mensagem">
        <a href="#mensagem">X</a>
        <br>
        <p>Credenciais erradas ou inexistentes. Tente novamente</p>
    </div>
</body>
</html>