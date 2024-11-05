<%@ page errorPage="../paginas-mensagem/404.jsp" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../css/area-oculta.css" />
    <link rel="shortcut icon" href="../../assets/cadeado.ico" type="image/x-icon">
    <title>Area de Administração</title>
</head>
<body>
<!-- HEADER -->
<!-- --------------------------------------------------------- -->
<header>
    <nav class="navbar">
        <div class="title">
            <a href="area-oculta.jsp">
                <img
                        src="../../assets/LogoKhiata_branco.png"
                        alt="Logo Khiata"
                />
            </a>
        </div>

            <ul class="nav-links">
                <li class="nav-titulo"><a href="#mensagem" onclick="showTab('tab10')">Categoria</a></li>
                <br>


                <li class="nav-titulo"><a href="#mensagem" onclick="showTab('tab20')">Usuários</a></li>
                <br>


                <li class="nav-titulo"><a href="#mensagem" onclick="showTab('tab30')">Endereço</a></li>
                <br>


                <li class="nav-titulo"><a href="#mensagem" onclick="showTab('tab40')">Administrador</a></li>
                <br>

                <li class="nav-titulo"><a href="#mensagem" onclick="showTab('tab50')">Preferencias</a></li>
                <br>

                <li class="nav-titulo"><a href="#mensagem" onclick="showTab('tab60')">Cursos</a></li>
                <br>

                <li class="nav-titulo"><a href="#mensagem" onclick="showTab('tab70')">Tipos Curso</a></li>
                <br>

                <li class="nav-titulo"><a href="#mensagem" onclick="showTab('tab80')">Analytics</a></li>

                <a href="../../index.html">
                    <img class="home" src="../../assets/botao-home-para-interface.png">
                </a>
            </ul>
            
        </div>


        </ul>
        <!-- HTML -->
        <div class="hamburger" onclick="toggleMenu()">
            <span class="bar up"></span>
            <span class="bar down"></span>
            <span class="bar down"></span>
        </div>

    </nav>
</header>

<!-- FIM DO HEADER -->
<!-- --------------------------------------------------------- -->



<!-- Conteúdos -->
<!-- --------------------------------------------------------- -->
<div class="main-content">

    <!-- Categoria -->
    <!-- -------------------------------------------------------------- -->

    <div id="tab10" class="tab-content info">
        <br>
        <h1>Categorias</h1>
        <p>Aqui você poderá registrar, ver e remover as categorias de costura do Khiata</p>
        <p>Essas categorias serão alocadas como tags dos produtos e como preferências dos usuários.</p>

        <br>

        <li class="content-item"><a href="#mensagem" onclick="showTab('tab11')">Mostrar categorias</a></li>
        <li class="content-item"><a href="#mensagem" onclick="showTab('tab12')">Criar categoria</a></li>
        <li class="content-item"><a href="#mensagem" onclick="showTab('tab13')">Remover categoria</a></li>
        <br>
        <br>
        <div class="imgs"><img id="categoria" src="../../assets/gestao-de-pastas.png" alt=""></div>

    </div>



    <div id="tab11" class="tab-content">
        <h2>Mostrar Categorias</h2>
        <p>Aqui você pode ver todas as categorias disponíveis.</p>

        <form action="mostrar-categorias" method="post">
            <button type="submit">Mostrar categorias</button>
        </form>
    </div>

    <div id="tab12" class="tab-content">
        <h2>Criar Categoria</h2>
        <p>Formulário para criar uma nova categoria.</p>

        <form action="registrar-categoria" method="post">

            <label for="email">E-mail do administrador</label>
            <br>
            <input type="email" name="email" id="email">

            <br><br>

            <label for="senha">Senha do administrador</label>
            <br>
            <input type="password" name="senha" id="senha">

            <br><br>

            <label for="categoria">Nome da categoria</label>
            <br>
            <input type="text" name="categoria" id="categoriaInput">

            <br><br>

            <button type="submit">Criar</button>

        </form>

    </div>

    <div id="tab13" class="tab-content">
        <h2>Remover Categoria</h2>
        <p>Selecione uma categoria para remover.</p>

        <form action="remover-categoria" method="post">

            <label for="categoria">Nome da categoria</label>
            <br>
            <input type="text" name="categoria" id="categoriaInput">

            <br><br>

            <button type="submit">Remover</button>

        </form>
    </div>
    <!-- -------------------------------------------------------------- -->



    <!-- Usuário -->
    <!-- -------------------------------------------------------------- -->
    <div id="tab20" class="tab-content info">
        <br>
        <h1>Usuários</h1>
        <p>Aqui você poderá ver, habilitar e desabilitar o premium dos usuários.</p>
        <p>Os usuários podem ser compradores ou costureiros que realizam todas as ações do nosso aplicativo</p>
        <br>
        <li class="content-item"><a href="#mensagem" onclick="showTab('tab21')">Mostrar usuários</a></li>
        <br><br>

        <div class="imgs"><img id="user" src="../../assets/silhueta-de-multiplos-usuarios.png"></div>
    </div>
    
    <div id="tab21" class="tab-content">
        <h2>Mostrar Usuários</h2>
        <p>Lista de todos os usuários registrados.</p>
        
        <form action="mostrar-usuarios" method="post">
            <button type="submit">Mostrar usuários</button>
        </form>
        
    </div>
    
    <!-- -------------------------------------------------------------- -->

    
    <!-- Endereço -->
    <!-- ------------------------------------------------------------- -->
    <div id="tab30" class="tab-content info">
        <br>
        <h1>Endereços</h1>
        <p>Aqui você poderá disponibilizar o endereço do comprador ao costureiro para que possa ocorrer a entrega.</p>
        <p>Por conta do endereço ser um dado sensível é importante que tenhamos esse controle para evitar golpes.</p>
        <br>
        <li class="content-item"><a href="#mensagem" onclick="showTab('tab31')">Disponibilizar endereço</a></li>
        <br><br>
        <div class="imgs"><img id="endereco" src="../../assets/mapa.png" alt=""></div>
    </div>


    <div id="tab31" class="tab-content">
        <h2>Disponibilizar Endereço</h2>
        <p>Configurações para disponibilizar endereço de entrega.</p>

        <form action="disponibilizar-endereco" method="post">

            <label for="email">E-mail do/a comprador/a</label>
            <br>
            <input type="email" name="email-comprador" id="email-comprador">

            <br><br>

            <label for="email">E-mail do/a costureiro/a</label>
            <br>
            <input type="email" name="email-vendedor" id="email-vendedor">

            <br><br>

            <button type="submit">Disponibilizar endereço</button>

        </form>
    </div>
    <!-- -------------------------------------------------------------- -->


    <!-- Administrador -->
    <!-- ------------------------------------------------------------- -->
    <div id="tab40" class="tab-content info">
        <br>
        <h1>Administradores</h1>
        <p>Aqui será possível criar, remover e visualizar os administradores que terão acesso a esta página e que poderão realiar diversas outras ações para o Khiata.</p>

        <br>

        <li class="content-item"><a href="#mensagem" onclick="showTab('tab41')">Mostrar administradores</a></li>
        <li class="content-item"><a href="#mensagem" onclick="showTab('tab42')">Registrar administrador(a)</a></li>
        <li class="content-item"><a href="#mensagem" onclick="showTab('tab43')">Remover administrador(a)</a></li>
        <br><br>
        <div class="imgs"><img id="admin" src="../../assets/definicoes.png" alt="admin"></div>

    </div>


    <div id="tab41" class="tab-content">
        <h2>Mostrar Administradores</h2>
        <p>Lista de todos os administradores registrados.</p>

        <form action="mostrarAdm" method="post">
            <button type="submit">Mostrar administradores</button>
        </form>
    </div>


    <div id="tab42" class="tab-content">
        <h2>Registrar administrador</h2>
        <p>Formulário para criar um administrador novo no sistema.</p>

        <form action="registrar-administrador" method="post">

            <label for="email">E-mail do administrador</label>
            <br>
            <input type="email" name="email" id="email">

            <br><br>

            <label for="senha">Senha do administrador</label>
            <br>
            <input type="password" name="senha" id="senha">

            <br><br>

            <label for="nome_completo">Nome do administrador</label>
            <br>
            <input type="text" name="nome_completo" id="nome_completo">

            <br><br>

            <button type="submit">Registrar</button>

        </form>
    </div>


    <div id="tab43" class="tab-content">
        <h2>Remover administrador</h2>
        <p>Formulário para remover um administrador do sistema.</p>
        
        <form action="remover-administrador" method="post">

            <label for="email">E-mail do administrador</label>
            <br>
            <input type="email" name="email" id="email">

            <br><br>
            <label for="senha">Senha do administrador</label>
            <br>
            <input type="password" name="senha" id="senha">

            <br><br>

            <button type="submit">Remover</button>
        </form>
    </div>
    <!-- ------------------------------------------------------------- -->


    <!-- Preferência -->
    <!-- ------------------------------------------------------------- -->
    <div id="tab50" class="tab-content info">
        <br>
        <h1>Preferência</h1>
        <p>Aqui você poderá adicionar e retirar preferências a usuários específicos, indicando produtos. </p>

        <br>
        <li class="content-item"><a href="#mensagem" onclick="showTab('tab51')">Alocar preferência em usuário</a></li>
        <li class="content-item"><a href="#mensagem" onclick="showTab('tab52')">Desalocar preferência em usuário</a></li>
        <br><br>
        <div class="imgs"><img id="pref" src="../../assets/preferencias.png" alt=""></div>

    </div>

    <div id="tab51" class="tab-content">
        <h2>Alocar preferência</h2>
        <p>Formulário para atribuir uma categoria de preferência do usuário</p>

        <form action="alocar-preferencia" method="post">

            <label for="email">E-mail do usuário</label>
            <br>
            <input type="email" name="email" id="email">

            <br><br>

            <label for="categoria">Nome da categoria</label>
            <br>
            <input type="text" name="categoria" id="categoriaInput">

            <br><br>

            <button type="submit">Alocar</button>

        </form>
    </div>


    <div id="tab52" class="tab-content">
        <h2>Desalocar preferência</h2>
        <p>Formulário para remover uma categoria de preferência do usuário</p>

        <form action="desalocar-preferencia" method="post">

            <label for="email">E-mail do usuário</label>
            <br>
            <input type="email" name="email" id="email">

            <br><br>

            <label for="categoria">Nome da categoria</label>
            <br>
            <input type="text" name="categoria" id="categoriaInput">

            <br><br>

            <button type="submit">Desalocar</button>

        </form>
    </div>
    <!-- ------------------------------------------------------------ -->



    <!-- Cursos -->
    <!-- ------------------------------------------------------------- -->
    <div id="tab60" class="tab-content info">
        <br>
        <h1>Cursos</h1>
        <p>Aqui você poderá visualizar, adicionar e remover cursos para os usuários do Khiata</p>


        <br>

        <li class="content-item"><a href="#mensagem" onclick="showTab('tab61')">Mostrar curso</a></li>

        <li class="content-item"><a href="#mensagem" onclick="showTab('tab62')">Registrar curso</a></li>

        <li class="content-item"><a href="#mensagem" onclick="showTab('tab63')">Remover curso</a></li>
        <br><br>

        <div class="imgs"><img id="curso" src="../../assets/educacao.png" alt=""></div>

    </div>


    <div id="tab61" class="tab-content">
        <h2>Mostrar cursos</h2>
        <p>Aqui você poderá visualizar todos os cursos presentes no Khiata.</p>

        <form action="mostrar-cursos" method="post">

            <button type="submit">Mostrar cursos</button>

        </form>
    </div>


    <div id="tab62" class="tab-content">
        <h2>Registrar curso</h2>
        <p>Formulário para criação de um curso.</p>

        <form action="registrar-curso" method="post">

            <label for="link-video">Link do vídeo do curso (YouTube) </label>
            <br>
            <input type="text" name="link-video" id="link-video">

            <br><br>
            <label for="tipo">Tipo de curso</label>
            <br>
            <input type="text" name="tipo" id="tipo">

            <br><br>

            <button type="submit">Registrar</button>

        </form>
    </div>


    <div id="tab63" class="tab-content">
        <h2>Remover curso</h2>
        <p>Formulário para remoção de um curso.</p>

        <form action="remover-curso" method="post">

            <label for="link-video">Link do vídeo do curso (YouTube) </label>
            <br>
            <input type="text" name="link-video" id="link-video">

            <br><br>

            <button type="submit">Remover</button>

        </form>
    </div>
    <!-- ------------------------------------------------------------ -->




    <!-- Tipo de curso -->
    <!-- ------------------------------------------------------------- -->
    <div id="tab70" class="tab-content info">
        <br>
        <h1>Tipos de Cursos</h1>
        <p>Aqui você poderá visualizar, adicionar e remover tipos de curso que serão alocados nos cursos criando playlists.</p>
        <br>

        <li class="content-item"><a href="#mensagem" onclick="showTab('tab71')">Mostrar tipos de curso</a></li>

        <li class="content-item"><a href="#mensagem" onclick="showTab('tab72')">Registrar tipo de curso</a></li>

        <li class="content-item"><a href="#mensagem" onclick="showTab('tab73')">Remover tipo de curso</a></li>
        <br><br>

        <div class="imgs">
            <img id="tipo-curso" src="../../assets/computador-portatil.png" alt="">
        </div>

    </div>


    <div id="tab71" class="tab-content">
        <h2>Mostrar tipos de cursos</h2>
        <p>Aqui você poderá visualizar todos os tipos de cursos presentes no Khiata.</p>

        <form action="mostrar-tipos" method="post">

            <button type="submit">Mostrar</button>

        </form>
    </div>


    <div id="tab72" class="tab-content">
        <h2>Registrar tipo de curso</h2>
        <p>Formulário para criação de um tipo de curso.</p>

        <form action="registrar-tipo" method="post">

            <label for="tipo">Tipo de curso novo</label>
            <br>
            <input type="text" name="tipo" id="tipo">

            <br><br>

            <button type="submit">Registrar</button>

        </form>
    </div>
    <div id="tab73" class="tab-content">
        <h2>Remover tipo de curso</h2>
        <p>Formulário para remoção de um tipo de curso.</p>

        <form action="remover-tipo" method="post">

            <label for="tipo">Tipo de curso para remoção</label>
            <br>
            <input type="text" name="tipo" id="tipo">

            <br><br>

            <button type="submit">Remover</button>

        </form>
    </div>
    <!-- ------------------------------------------------------------- -->


    <!-- Analytics -->
    <!-- ------------------------------------------------------------- -->

        <!-- Conteúdo da página do segundo ano -->

        <div id="tab80" class="tab-content info">
            <br>
            <h1>Analytics</h1>
            <p>Aqui você poderá visualizar dados relevantes sobre os usuários e o funcionamento do Khiata.</p>
            <br>

            <br>
            <li class="content-item"><a href="#" target="-blank">Analisar</a></li>
            <br><br>

            <div class="imgs"><img id="analytics" src="../../assets/analytics.png" alt=""></div>
        </div>
    <!-- ------------------------------------------------------------- -->

</div>
<!-- --------------------------------------------------------- -->






<!-- Script -->
<!-- --------------------------------------------------------- -->
<script>


    function toggleMenu() {
        const menus = document.querySelectorAll('.menu');
        menus.forEach(menu => {
            menu.style.display = 'none';
        });
        const navLinks = document.querySelector(".nav-links");
        navLinks.classList.toggle("active");
    }

    function showTab(tabId) {
        var tabs = document.querySelectorAll('.tab-content');
        tabs.forEach(function(tab) {
            tab.classList.remove('active');
        });

        var selectedTab = document.getElementById(tabId);
        selectedTab.classList.add('active');
    }
    // PARTE PARA ACIONAR HAMBURGUER
    function toggleMenu() {
        const navLinks = document.querySelector(".nav-links");
        navLinks.classList.toggle("active");
    }


</script>


<!-- --------------------------------------------------------- -->



</body>
</html>