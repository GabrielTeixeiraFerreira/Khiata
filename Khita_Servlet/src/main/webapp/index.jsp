<%@ page errorPage="pages/paginas-mensagem/404.jsp" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/landingPage.css">
    <link rel="shortcut icon" href="assets/agulha.ico" type="image/x-icon">
    <title>Landing Page</title>
</head>
<body>


<div class="conteudo-principal">

    <a href="${pageContext.request.contextPath}/pages/paginas-principais/login.jsp" class="login">
        <img src="assets/pessoa.svg" alt="">
    </a>

    <div class="texto">
        <div class="logo">
            <img src="assets/LogoKhiata_branco.png" alt="">
        </div>

        <div class="conteudo">
            <h1>Transformando o <strong>mundo</strong> de <em><strong>ponto</strong></em> em <em> <strong>ponto</strong></em></h1>
            <br><br><br>

            <div class="botoes">
                <a href="#sobre">Sobre nós</a>
                <a href="#contatos">Nossa equipe</a>
            </div>
        </div>
    </div>

    <div class="imagemPrimeiro">
        <img src="assets/imagemFrente.webp" alt="">
    </div>
</div>
<hr>
<br><br><br><br><br><br>






<div class="sobre" id="sobre">
    <h1>Sobre Nós</h1>
</div>
<div class="containerSobre">
    <!-- Caixa com informações sobre quem somos -->
    <div class="caixa">
        <div class="icone">
            <img src="assets/quemSomos.png" alt="Quem Somos">
        </div>
        <div class="text">
            <h3>Quem Somos</h3>
            <p>
                Aqui na Khiata, acreditamos que a moda pode ser sustentável e socialmente responsável.
                Somos um app dedicado a promover a reutilização de tecidos, transformando o que poderia ser
                descartado em peças novas e cheias de propósito.
                Nosso foco é reduzir o desperdício têxtil, dando uma segunda chance a materiais que merecem ser
                valorizados.
            </p>
        </div>
    </div>
    <!-- Caixa com informações sobre a missão -->
    <div class="caixa">
        <div class="icone">
            <img src="assets/nossasCausas.png" alt="Nossa Missão">
        </div>
        <div class="text">
            <h3>Nossa Missão</h3>
            <p>
                A indústria têxtil e de confecção no Brasil movimenta cerca de R$200 bilhões anualmente,
                representando 23% do faturamento da Indústria de Transformação e 16,7% dos empregos nesse setor.
                No entanto, entre 70% e 75% das roupas usadas são descartadas em aterros sanitários, com apenas
                1%
                sendo reutilizadas.
                Segundo o SEBRAE, muitos proprietários de empresas relatam falta de interesse e comprometimento
                dos
                trabalhadores,
                sendo que 62% das empresas não oferecem benefícios e 80% não disponibilizam subsídios para
                formação
                técnica.
            </p>
        </div>
    </div>
    <!-- Outra seção sobre a missão, repetida para mais detalhes -->
    <div class="caixa">
        <div class="icone">
            <img src="assets/nossaMissao.png" alt="Nossa Missão">
        </div>
        <div class="text">
            <h3>Nossa Missão</h3>
            <p>
                Além de contribuir para um futuro mais verde, também apoiamos costureiras e artesãos locais,
                oferecendo oportunidades de trabalho e capacitação. Ao combinar sustentabilidade e
                responsabilidade
                social,
                criamos um impacto positivo em nossa comunidade e no meio ambiente.
                Nosso compromisso é com a moda consciente, inovadora e inclusiva.
                Trabalhamos juntos por um ciclo de produção que respeita as pessoas e o planeta.
                Se você acredita em um futuro onde a moda é sustentável, conte conosco nessa jornada!
            </p>
        </div>
    </div>
    <!-- Seção sobre as ODS que a empresa impacta -->
    <div class="caixa">
        <div class="icone">
            <img src="assets/Ods's.png" alt="Ods's que nós impactamos">
        </div>
        <div class="text">
            <h3>ODS's que nós impactamos</h3>
            <p>
                Estamos comprometidos em alinhar nossas ações aos Objetivos de Desenvolvimento Sustentável (ODS)
                da ONU, criando um impacto positivo em diversas áreas.
            <ul>
                <li>
                    <strong>ODS 4</strong>, promovemos a capacitação e a aprendizagem, criando oportunidades para
                    todos.
                </li>
                <li>
                    <strong>ODS 8</strong> ao apoiar costureiras e artesãos locais com emprego
                    justo e qualificação.
                </li>
                <li>
                    <strong>ODS 11</strong>, incentivamos cidades e comunidades sustentáveis, reduzindo o
                    descarte de tecidos e promovendo a economia circular.
                </li>
                <li>
                    <strong>ODS 12</strong> por meio da reutilização de materiais, diminuindo o
                    desperdício e incentivando o consumo consciente.
                </li>
                <li>
                    <strong>ODS 13</strong>, nossas práticas ajudam a reduzir a pegada de carbono da moda.
                </li>
                <li>
                    <strong>ODS 17</strong>, valorizamos parcerias que fortalecem nosso impacto
                    coletivo para atingir o futuro mais sustentável.
                </li>
            </ul>
            </p>
        </div>
    </div>
</div>
<br>
<hr>
<!-- Seção de Projetos / Nossa Empresa -->
<div class="projetos" id="empresa">
    <div class="bolaKhiata">
        <div class="title__about">
            <h2></h2>
        </div>
        <div class="contentTMJ">
            <div class="left">
                <div class="title__about">
                    <h2>TMJ</h2>
                </div>
                <p id="sobreKhiata">
                    <strong>Transformando o mundo juntos.</strong><br>
                    Somos uma empresa comprometida com o desenvolvimento sustentável.
                    A TMJ está sempre buscando novas soluções para os desafios ambientais.
                    A empresa investe em pesquisas e desenvolve produtos eco-friendly.
                </p>
            </div>

            <div class="right">
                <img src="assets/TMJlogo.png" alt="">
            </div>


        </div>
    </div>
</div>

<hr>
<br><br><br>
<div class="funcionalidade">
    <div class="texto">
        <h1>Funcionalidades do Khiata</h1>
        <p>Aqui será possível experimentar uma prévia do nosso app. Para conseguir acesso a versão completa, instale agora mesmo!</p>
    </div>

    <div class="phone-screen phone-interactive">
        <iframe width="250px" height="610px"
                src="https://embed.figma.com/proto/tv9Q5z0XLS5Z1Wj0OPOx7K/Prot%C3%B3tipo-Teste?node-id=21-544&node-type=canvas&scaling=scale-down-width&content-scaling=fixed&page-id=0%3A1&starting-point-node-id=21%3A536&hotspot-hints=0&embed-host=share&hide-ui=1"
                allowfullscreen></iframe>
    </div>
</div>
<br><br><br>
<hr class="esconderLinha">
<br>




<!-- ------------------------------------------------------------------------------------------------- -->
<!-- CARDS -->
<!-- COMEÇANDO CARDS -->
<div class="bodycard" id="contatos">
    <div class="all_cards">
        <div class="title1card">1º Ano Tech</div>
        <!-- card 1 -->
        <div class="container_card1"> <!-- mudar -->
            <div class="card card_1">
                <div class="contentcard ">
                    <div class="imagem">
                        <img src="assets/caio.jpg" alt="Pessoa">
                    </div>
                </div>
            </div>
            <div class="card card1_2">
                <div class="mais1"></div><!-- mudar -->
                <div class="contentcard ">
                    <h3>Caio de Oliveira</h3>
                    <h4>Desenvolvedor WEB - Front-end</h4>
                </div>
            </div>

            <div class="popup" id="popup1">
                <div class="popup-content">
                    <span class="close-btn" id="closePopup1">&times;</span>
                    <div class="popup-header">
                    </div>
                    <div class="popup-body">
                        <div class="popup-left">
                            <img src="assets/caio.jpg" alt="Foto da Pessoa 1" class="modal-img">
                            <Atua class="popup-desc">
                                Estudante do Germinare Tech - Desenvolvedor do app Khiata - Pretende seguir ramo de
                                Análise
                                de Dados.Atua na área de desenvolvimento do site, também na parte de lógica de
                                programação.
                                </p>
                        </div>
                        <div class="popup-right">
                            <p><strong>Idade:</strong> 16</p>
                            <p><strong>Gênero:</strong> Masculino</p>
                            <p><strong>Telefone:</strong> (11) 98485-8093</p>
                            <p><strong>E-mail:</strong> caio.garcia@germinare.org.br</p>
                            <p><strong>Função:</strong> Desenvolvedor do site</p>
                            <p>
                                <strong>Descrição da Função:</strong> Responsável por
                                desenvolver o site, principalemnte na área de cards.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- fazendo outros cards precisa: fazer o grid dessa bomba com 4x3 -->
        <!-- div do all cards e conteiner -->

        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- precisa modificar de card em card o conteiner card.card_2 popup closepopup -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- card 2 -->
        <div class="container_card2"> <!-- mudar -->
            <div class="card card_1">
                <div class="contentcard ">
                    <div class="imagem">
                        <img src="assets/inacio.jpg" alt="Pessoa">
                    </div>
                </div>
            </div>
            <div class="card card2_2">
                <div class="mais2"></div>
                <div class="contentcard ">
                    <h3>Filipi Inácio</h3>
                    <h4>Desenvolvedor WEB - Front-end</h4>
                </div>
            </div>
            <div class="popup" id="popup2">
                <div class="popup-content">
                    <span class="close-btn" id="closePopup2">&times;</span>
                    <div class="popup-header">
                    </div>
                    <div class="popup-body">
                        <div class="popup-left">
                            <img src="assets/inacio.jpg" alt="Foto da Pessoa 2" class="modal-img">
                            <p class="popup-desc">
                                Estudante do Germinare Tech - Desenvolvedor do app Khiata -
                                Pretende seguir ramo de Desenvolvedor de Sistemas.
                                Atua na área de desenvolvimento do site e também na área de
                                programação orientada à objetos.
                            </p>
                        </div>
                        <div class="popup-right">
                            <p><strong>Idade:</strong> 16</p>
                            <p><strong>Gênero:</strong> Masculino</p>
                            <p><strong>Telefone:</strong> (11) 97597-7141</p>
                            <p><strong>E-mail:</strong> filipi.inacio@germinare.org.br</p>
                            <p><strong>Função:</strong> Desenvolvedor web</p>
                            <p>
                                <strong>Descrição da Função:</strong> Responsável por ideias,
                                criação e montagem das páginas web do projeto.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- precisa modificar de card em card o conteiner card.card_2 popup closepopup -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- card 3 -->
        <div class="container_card3"> <!-- mudar -->
            <div class="card card_1">
                <div class="contentcard ">
                    <div class="imagem">
                        <img src="assets/tetxsFoto.jpeg" alt="Pessoa">
                    </div>
                </div>
            </div>
            <div class="card card3_2">
                <div class="mais3"></div>
                <div class="contentcard ">
                    <h3>Gabriel Teixeira</h3>
                    <h4>Developer - Back-end</h4>
                </div>
            </div>
            <div class="popup" id="popup3">
                <div class="popup-content">
                    <span class="close-btn" id="closePopup3">&times;</span>
                    <div class="popup-header">
                    </div>
                    <div class="popup-body">
                        <div class="popup-left">
                            <img src="assets/tetxsFoto.jpeg" alt="Foto da Pessoa 3" class="modal-img">
                            <p class="popup-desc">
                                Estudante do Germinare Tech - Desenvolvedor do app Khiata -
                                Pretende seguir ramo de Análise de Dados.
                                Atua na área de banco de dados do app e site, na área de
                                programação orientada à objetos e também de desenvolvimento do
                                site.
                            </p>
                        </div>
                        <div class="popup-right">
                            <p><strong>Idade:</strong> 15</p>
                            <p><strong>Gênero:</strong> Masculino</p>
                            <p><strong>Telefone:</strong> (11) 97272-1701</p>
                            <p>
                                <strong>E-mail:</strong> gabriel.ferreira@germinare.org.br
                            </p>
                            <p><strong>Função:</strong> Developer - Back-end</p>
                            <p>
                                <strong>Descrição da Função:</strong> Responsável por
                                desenvolver o site, servlet e criar e atualizar/cuidar do banco de dados.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- precisa modificar de card em card o conteiner card.card_2 popup closepopup -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- card 4 -->
        <div class="container_card4"> <!-- mudar -->
            <div class="card card_1">
                <div class="contentcard ">
                    <div class="imagem">
                        <img src="assets/giovannaAndrade.png    " alt="Pessoa">
                    </div>
                </div>
            </div>
            <div class="card card4_2">
                <div class="mais4"></div>
                <div class="contentcard ">
                    <h3>Giovanna Vicentim</h3>
                    <h4>Developer - Back-end</h4>
                </div>
            </div>
            <div class="popup" id="popup4">
                <div class="popup-content">
                    <span class="close-btn" id="closePopup4">&times;</span>
                    <div class="popup-header">
                    </div>
                    <div class="popup-body">
                        <div class="popup-left">
                            <img src="assets/giovannaAndrade.png" alt="Foto da Pessoa 4" class="modal-img">
                            <p class="popup-desc">
                                Estudante do Germinare Tech - Desenvolvedora do app Khiata -
                                Pretende seguir ramo de Análise de Dados.
                                Atua na área de banco de dados do app e site, na área de
                                programação orientada à objetos e também de desenvolvimento do
                                site.
                            </p>
                        </div>
                        <div class="popup-right">
                            <p><strong>Idade:</strong> 16</p>
                            <p><strong>Gênero:</strong> Feminino</p>
                            <p><strong>Telefone:</strong> (11) 94951-2199</p>
                            <p><strong>E-mail:</strong> giovanna.vicentim@germinare.org.br</p>
                            <p><strong>Função:</strong> Developer - Back-end</p>
                            <p><strong>Descrição da Função:</strong> Responsável por
                                desenvolver o site, servlet e criar e atualizar/cuidar do banco de dados.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- precisa modificar de card em card o conteiner card.card_2 popup closepopup -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------ -->
        <!-- card 5 -->
        <div class="sub_cards">
            <div class="container_card5">
                <div class="card card_1">
                    <div class="contentcard ">
                        <div class="imagem">
                            <img src="assets/LauraTavora.jpg" alt="Pessoa">
                        </div>
                    </div>
                </div>
                <div class="card card5_2">
                    <div class="mais5"></div>
                    <div class="contentcard ">
                        <h3>Laura Tavora</h3>
                        <h4>Desenvolvedor WEB - Front-end</h4>
                    </div>
                </div>
                <div class="popup" id="popup5">
                    <div class="popup-content">
                        <span class="close-btn" id="closePopup5">&times;</span>
                        <div class="popup-header">
                        </div>
                        <div class="popup-body">
                            <div class="popup-left">
                                <img src="assets/LauraTavora.jpg" alt="Foto da Pessoa 5" class="modal-img">
                                <p class="popup-desc">
                                    Estudante do Germinare Tech - Desenvolvedora do app Khiata -
                                    Pretende seguir ramo de Desenvolvedor de Sistemas.
                                    Atua na área de desenvolvimento do site.
                                </p>
                            </div>
                            <div class="popup-right">
                                <p><strong>Idade:</strong> 16</p>
                                <p><strong>Gênero:</strong> Feminino</p>
                                <p><strong>Telefone:</strong> (11) 97776-0294</p>
                                <p><strong>E-mail:</strong> laura.tavora@germinare.org.br</p>
                                <p><strong>Função:</strong> Desenvolvedora WEB</p>
                                <p><strong>Descrição da Função: </strong> Responsável por ideias,
                                    criação e montagem das páginas web do projeto. </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
            <!-- precisa modificar de card em card o conteiner card.card_2 popup closepopup -->
            <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
            <!-- card 6 -->
            <div class="container_card6">
                <div class="card card_1">
                    <div class="contentcard ">
                        <div class="imagem">
                            <img src="assets/rafael.jpg" alt="Pessoa">
                        </div>
                    </div>
                </div>
                <div class="card card6_2">
                    <div class="mais6"></div>
                    <div class="contentcard ">
                        <h3>Rafael Cruz</h3>
                        <h4>Gestor de projetos</h4>

                    </div>
                </div>
                <div class="popup" id="popup6">
                    <div class="popup-content">
                        <span class="close-btn" id="closePopup6">&times;</span>
                        <div class="popup-header">
                        </div>
                        <div class="popup-body">
                            <div class="popup-left">
                                <img src="assets/rafael.jpg" alt="Foto da Pessoa 6" class="modal-img">
                                <p class="popup-desc">
                                    Estudante do Germinare Tech - Desenvolvedor do app Khiata -
                                    Pretende seguir ramo de Desenvolvedor de Sistemas.
                                    Atua na área de gerenciamento do projeto, utilizando planilhas do EXCEL.
                                </p>
                            </div>
                            <div class="popup-right">
                                <p><strong>Idade:</strong> 15</p>
                                <p><strong>Gênero:</strong> Masculino</p>
                                <p><strong>Telefone:</strong> (11) 95552-9102</p>
                                <p><strong>E-mail:</strong> rafael.cruz@germinare.org.br</p>
                                <p><strong>Função:</strong> Gerente de Projetos</p>
                                <p><strong>Descrição da Função:</strong> Responsável por gerenciar os projetos da
                                    empresa e
                                    garantir que todos os prazos sejam cumpridos.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
            <!-- precisa modificar de card em card o conteiner card.card_2 popup closepopup -->
            <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
            <!-- card 7 -->
            <div class="container_card7">
                <div class="card card_1">
                    <div class="contentcard ">
                        <div class="imagem">
                            <img src="assets/rapha.jpg" alt="Pessoa">
                        </div>
                    </div>
                </div>
                <div class="card card7_2">
                    <div class="mais7"></div>
                    <div class="contentcard ">
                        <h3>Raphaela Maria de Souza Gomes</h3>
                        <h4>Desenvolvedor WEB</h4>

                    </div>
                </div>
                <div class="popup" id="popup7">
                    <div class="popup-content">
                        <span class="close-btn" id="closePopup7">&times;</span>
                        <div class="popup-header">
                        </div>
                        <div class="popup-body">
                            <div class="popup-left">
                                <img src="assets/rapha.jpg  " alt="Foto da Pessoa 7" class="modal-img">
                                <p class="popup-desc">
                                    Estudante do Germinare Tech - Desenvolvedora do app Khiata -
                                    Pretende seguir ramo de Desenvolvedor de Sistemas.
                                    Atua na área de desenvolvimento do site.
                                </p>
                            </div>
                            <div class="popup-right">
                                <p><strong>Idade:</strong> 16</p>
                                <p><strong>Gênero:</strong> Feminino</p>
                                <p><strong>Telefone:</strong> (11) 98754-3080</p>
                                <p><strong>E-mail:</strong> raphaela.gomes@germinare.org.br</p>
                                <p><strong>Função:</strong> Gerente de Projetos</p>
                                <p><strong>Descrição da Função:</strong> Responsável estilizar páginas
                                    do site e também cooperação na
                                    criação de design do App.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        </div>
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <div class="title2card">2º Ano Tech</div>
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- precisa modificar de card em card o conteiner card.card_2 popup closepopup -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- card 8 -->
        <div class="container_card8">
            <div class="card card_1">
                <div class="contentcard ">
                    <div class="imagem">
                        <img src="assets/VetorettiFoto.jpeg" alt="Pessoa">
                    </div>
                </div>
            </div>
            <div class="card card8_2">
                <div class="mais8"></div>
                <div class="contentcard ">
                    <h3>Enzo Vetoretti</h3>
                    <h4>Analista de dados</h4>

                </div>
            </div>
            <div class="popup" id="popup8">
                <div class="popup-content">
                    <span class="close-btn" id="closePopup8">&times;</span>
                    <div class="popup-header">
                    </div>
                    <div class="popup-body">
                        <div class="popup-left">
                            <img src="assets/VetorettiFoto.jpeg" alt="Foto da Pessoa 8" class="modal-img">
                            <p class="popup-desc">
                                Está cursando Análise de Dados no Instituto JeF e cooperando na construção do aplicativo, utilizando IAs, Dashboards, etc.
                            </p>
                        </div>
                        <div class="popup-right">
                            <p><strong>Idade:</strong> 17</p>
                            <p><strong>Gênero:</strong> Masculino</p>
                            <p><strong>Telefone:</strong> (11) 97597-7141</p>
                            <p><strong>E-mail:</strong> enzo.rocha@germinare.org.br</p>
                            <p><strong>Função:</strong> Analista de Dados</p>
                            <p><strong>Descrição da Função:</strong> Responsável por cuidar dos Dashboards e das IAs.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- precisa modificar de card em card o conteiner card.card_2 popup closepopup -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- card 9 -->
        <div class="container_card9">
            <div class="card card_1">
                <div class="contentcard ">
                    <div class="imagem">
                        <img src="assets/Inaldo Pereira Freitas (1).JPG" alt="Pessoa">
                    </div>
                </div>
            </div>
            <div class="card card9_2">
                <div class="mais9"></div>
                <div class="contentcard">
                    <h3>Inaldo Pereira</h3>
                    <h4>Analista de dados</h4>

                </div>
            </div>
            <div class="popup" id="popup9">
                <div class="popup-content">
                    <span class="close-btn" id="closePopup9">&times;</span>
                    <div class="popup-header">
                    </div>
                    <div class="popup-body">
                        <div class="popup-left">
                            <img src="assets/Inaldo Pereira Freitas (1).JPG" alt="Foto da Pessoa 9"
                                 class="modal-img">
                            <p class="popup-desc">
                                Está cursando Análise de Dados no Instituto JeF e cooperando na construção do aplicativo, com coisas relacionadas ao banco de dados, incluindo RPA.
                            </p>
                        </div>
                        <div class="popup-right">
                            <p><strong>Idade:</strong> 17</p>
                            <p><strong>Gênero:</strong> Masculino</p>
                            <p><strong>Telefone:</strong> (11) 98010-0556</p>
                            <p><strong>E-mail:</strong> inaldo.freitas@germinare.org.br</p>
                            <p><strong>Função:</strong> Analista de dados</p>
                            <p><strong>Descrição da Função:</strong> Cuidar de tudo relacionando ao banco de dados (RPA incluso)</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- precisa modificar de card em card o conteiner card.card_2 popup closepopup -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- card 10 -->
        <div class="container_card10">
            <div class="card card_1">
                <div class="contentcard ">
                    <div class="imagem">
                        <img src="assets/Nicolas.jpg" alt="Pessoa">
                    </div>
                </div>
            </div>
            <div class="card card10_2">
                <div class="mais10"></div>
                <div class="contentcard ">
                    <h3>Nícolas Nakashima</h3>
                    <h4>Desenvolvedor WEB</h4>

                </div>
            </div>
            <div class="popup" id="popup10">
                <div class="popup-content">
                    <span class="close-btn" id="closePopup10">&times;</span>
                    <div class="popup-header">
                    </div>
                    <div class="popup-body">
                        <div class="popup-left">
                            <img src="assets/Nicolas.jpg" alt="Foto da Pessoa 10" class="modal-img">
                            <p class="popup-desc">
                                Está cursando Desenvolvimento de Sistemas no Instituto JeF e cooperando na construção do aplicativo, com coisas relacionadas
                                ao back-end do projeto.
                            </p>
                        </div>
                        <div class="popup-right">
                            <p><strong>Idade:</strong> 17</p>
                            <p><strong>Gênero:</strong> Masculino</p>
                            <p><strong>Telefone:</strong> (11) 95693-8057</p>
                            <p><strong>E-mail:</strong> nicolas.nakashima@germinare.org.br</p>
                            <p><strong>Função:</strong> Desenvolvedor de Sistemas - Back-end</p>
                            <p><strong>Descrição da Função:</strong> Responsável pelo Back-end do projeto(API), implementação dos projetos na cloud, versionamento e protection rules no github, front-end na parte web.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- precisa modificar de card em card o conteiner card.card_2 popup closepopup -->
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <!-- card 11 -->
        <div class="container_card11">
            <div class="card card_1">
                <div class="contentcard ">
                    <div class="imagem">
                        <img src="assets/heitor.jpg" alt="Pessoa">
                    </div>
                </div>
            </div>
            <div class="card card11_2">
                <div class="mais11"></div>
                <div class="contentcard ">
                    <h3>Heitor Campos</h3>
                    <h4>Desenvolvedor WEB</h4>

                </div>
            </div>
            <div class="popup" id="popup11">
                <div class="popup-content">
                    <span class="close-btn" id="closePopup11">&times;</span>
                    <div class="popup-header">
                    </div>
                    <div class="popup-body">
                        <div class="popup-left">
                            <img src="assets/heitor.jpg" alt="Foto da Pessoa 11" class="modal-img">
                            <p class="popup-desc">
                                Está cursando Desenvolvimento de Sistemas no Instituto JeF e cooperando na construção do aplicativo, com coisas relacionadas
                                a design, git, etc.
                            </p>
                        </div>
                        <div class="popup-right">
                            <p><strong>Idade:</strong> 16</p>
                            <p><strong>Gênero:</strong> Masculino</p>
                            <p><strong>Telefone:</strong> (11) 99237-8347</p>
                            <p><strong>E-mail:</strong> heitor.campos@germinare.org.br</p>
                            <p><strong>Função:</strong> Desenvolvedor de Sistemas</p>
                            <p><strong>Descrição da Função:</strong> Responsável por: front mobile, design (UX) e versionamento do projeto no git.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- div do all cards -->
</div>
<br><br><br><br><br><br><br>

<footer class="site-footer">
    <div class="footer-container">
        <div class="footer">
            <img src="assets/khiata (2).png" alt="Logo do Site" class="footer-logo">
            <img src="assets/9bffe443-6526-45b1-bf0f-094869c2a828-removebg-preview.png" alt="KHIKHIZINHA" class="footer-khi">
            <p>O Khiata te desafia a transformar o comum em extraordinário! Nossos tecidos, com texturas e cores únicas, são perfeitos para costureiros
                que buscam dar vida a peças exclusivas. Reinvente a moda e contribua para um futuro mais sustentável.</p>
        </div>

        <div class="footer">
            <h3>Contato</h3>
            <p>Email: <a href="mailto:khiatatextil@gmail.com">khiatatextil@gmail.com</a></p>
        </div>
        <div class="footer">
            <h3>Siga-nos</h3>
            <a href="https://www.facebook.com/profile.php?id=61568205062290" target="_blank">Facebook</a>
            <a href="https://www.instagram.com/khiatatextil/" target="_blank">Instagram</a>
        </div>
    </div>
    <div class="footer-bottom">
        <p>&copy; 2024 Khiata, by TMJ.</p>
    </div>
</footer>



<!-- SCRIPT JAVASCRIPT -->
<script src="js/script.js"></script>

</body>
</html>