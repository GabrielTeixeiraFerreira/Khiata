<%@ page errorPage="../paginas-mensagem/404.jsp" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/login.css">
    <link rel="shortcut icon" href="../../assets/cadeado.ico" type="image/x-icon">
    <title>Login</title>
</head>
<body>
    <div class="content">
        <div class="logo">
            <img src="../../assets/LogoKhiata.svg" alt="">
        </div>

        <div class="formulario">
            <h1>Bem-vindo, administrador!</h1>

            <br>
            <form action="login-adm" method="post">
                <label for="email">E-mail do administrador</label>
                <br>
                <input type="email" name="email" id="email" placeholder="voce@exemplo.com">

                <br><br>
                <label for="senha">Senha</label>
                <br>
                <input type="senha" name="senha" id="senha" placeholder="Digite sua senha aqui">

                <br><br><br>
                <button type="submit">Entrar</button>
            </form>
        </div>

    </div>

    <div class="imagem">
        <img src="../../assets/mulher_login.svg" alt="">
    </div>
</body>
</html>