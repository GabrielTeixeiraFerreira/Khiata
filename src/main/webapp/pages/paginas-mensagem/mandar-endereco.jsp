<%@ page import="com.khita_servlet.model.Usuario" %>
<%@ page import="com.khita_servlet.model.Endereco" %>
<%@ page errorPage="404.jsp" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Mandar endereço</title>
  <link rel="stylesheet" href="../../css/endereco.css">
</head>

<body>
  <%  Usuario comprador  = (Usuario) request.getAttribute("comprador");
    Usuario costureiro = (Usuario) request.getAttribute("costureiro");
    Endereco enderecoComprador = (Endereco) request.getAttribute("endereco");

    String corpoEmail = "Olá senhor/a costureiro/a "+costureiro.getNome()+", nós da equipe administrativa do Khiata, viemos por meio deste e-mail enviar o endereço do/a comprador/a" +comprador.getNome()+ ". Agradecemos desde já! \nSegue o endereço solicitado: " +enderecoComprador;
%>
  <div class="transicao">
    <div id="container">
      <div class="card-container">
        <div class="card">
          <h1>Comprador/a</h1>
          <h3><%= comprador.getNome() %></h3><br>
          <p>CEP: <%= enderecoComprador.getCep() %></p>
          <div class="layers">
            <div class="layer"></div>
            <div class="layer"></div>
            <div class="layer"></div>
            <div class="layer"></div>
            <div class="layer"></div>
          </div>
        </div>
      </div>
      <!-- oi -->
      <div class="button-container">
        <div class="button">
          <button style="--clr:#39FF14"><span>Mandar email</span><i></i></button>
        </div>
      </div>
      <div class="container-arrow">
        <div class="arrow">
          <span></span>
          <span></span>
          <span></span>
        </div>
      </div>
      <!-- oi -->
      <div class="card-container">
        <div class="card">
          <h1>Costureiro/a</h1>
          <p><%= costureiro.getNome() %></p>
          <div class="layers">
            <div class="layer"></div>
            <div class="layer"></div>
            <div class="layer"></div>
            <div class="layer"></div>
            <div class="layer"></div>
          </div>
        </div>
      </div>
    </div>
    
  </div>

</html>

</body>