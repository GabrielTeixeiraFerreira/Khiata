Projeto Interdisciplinar Khiata

Projeto Khiata criado para a ajuda de reutilização de resíduos têxteis, tendo a Landing Page que serve para compartilhar todas as informações do projeto

Projeto desenvolvido utilizando HTML, CSS e JavaScript para o front-end, Java para o back-end e PostgreSQL como banco de dados. O gerenciamento de tarefas é realizado utilizando o Trello.

Requisitos

Antes de iniciar a instalação, certifique-se de ter os seguintes softwares instalados:

Java JDK 17+

PostgreSQL

Apache Maven (para gestão de dependências do Java)

Git

[IDE recomendada: IntelliJ IDEA e VS Code]

Instalação e Execução

Clonando o Repositório

git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio

Configurando o Banco de Dados

Inicie o PostgreSQL e crie um banco de dados:

CREATE DATABASE nome_do_banco;

Atualize o arquivo de configuração (application.properties ou application.yml) com as credenciais do banco.

Back-end (Java)

Acesse o diretório do back-end:

cd backend

Compile e execute o servidor:

mvn clean install
mvn spring-boot:run

O servidor estará rodando em http://localhost:8080

Front-end (HTML, CSS e JavaScript)

Acesse o diretório do front-end:

cd frontend

Instale as dependências:

npm install

Inicie o servidor de desenvolvimento:

npm start

O projeto estará acessível em http://localhost:3000

Trello

Para acompanhar as tarefas do projeto, acesse o Trello e utilize o board Nome do Board.

Copyright

Este projeto é de propriedade de [Seu Nome ou Empresa]. Todos os direitos reservados. Nenhuma parte deste projeto pode ser copiada, modificada ou distribuída sem permissão prévia.
