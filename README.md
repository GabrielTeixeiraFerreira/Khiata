# Projeto Interdisciplinar Khiata

## Descrição
O Projeto Khiata foi criado para ajudar na reutilização de resíduos têxteis, contando com uma Landing Page para compartilhar todas as informações do projeto.

Este projeto foi desenvolvido utilizando:
- **Front-end**: HTML, CSS e JavaScript
- **Back-end**: Java
- **Banco de dados**: PostgreSQL
- **Gerenciamento de tarefas**: Trello

## Requisitos
Antes de iniciar a instalação, certifique-se de ter os seguintes softwares instalados:

- **Java JDK 17+**
- **PostgreSQL**
- **Apache Maven** (para gestão de dependências do Java)
- **Git**
- **IDE recomendada**: IntelliJ IDEA ou VS Code

## Instalação e Execução

### Clonando o Repositório
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### Configurando o Banco de Dados
1. Inicie o PostgreSQL e crie um banco de dados:
```sql
CREATE DATABASE nome_do_banco;
```
2. Atualize o arquivo de configuração (`application.properties` ou `application.yml`) com as credenciais do banco.

### Back-end (Java)
1. Acesse o diretório do back-end:
```bash
cd backend
```
2. Compile e execute o servidor:
```bash
mvn clean install
mvn spring-boot:run
```
O servidor estará rodando em `http://localhost:8080`

### Front-end (HTML, CSS e JavaScript)
1. Acesse o diretório do front-end:
```bash
cd frontend
```
2. Instale as dependências:
```bash
npm install
```
3. Inicie o servidor de desenvolvimento:
```bash
npm start
```
O projeto estará acessível em `http://localhost:3000`

## Trello
Para acompanhar as tarefas do projeto, acesse o [Trello](https://trello.com/) e utilize o board `Nome do Board`.

## Copyright
Este projeto é de propriedade de [Seu Nome ou Empresa]. Todos os direitos reservados. Nenhuma parte deste projeto pode ser copiada, modificada ou distribuída sem permissão prévia.

