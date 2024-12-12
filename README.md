# 💬 ForumHub API 🚀

## 📋 Descrição do Projeto
ForumHub é uma aplicação de API Rest para gerenciamento de fóruns, desenvolvida com Spring Boot, oferecendo funcionalidades completas de CRUD para tópicos de discussão e autenticação de usuários.

## ✨ Características Principais
- 🔐 Autenticação e Autorização com JWT
- 📝 Gerenciamento de Tópicos (Criação, Listagem, Atualização, Exclusão)
- 🛡️ Validação de Dados
- 📊 Documentação de API com Swagger
- 🔒 Segurança configurada com Spring Security

## 🛠️ Tecnologias Utilizadas
- Java 17
- Spring Boot 3.4.0
- Spring Security
- JWT Authentication
- MySQL
- Flyway (Migrations)
- Hibernate/JPA
- Lombok
- Swagger/OpenAPI

## 🚦 Pré-requisitos
- JDK 17
- Maven
- MySQL

## 🔧 Configuração do Projeto
1. Clone o repositório
```bash
git clone https://github.com/edimaiquemaciel/forumhub-challenge-backend.git
```

2. Configure o arquivo `application.properties`
```properties
# Configurações do banco de dados
spring.datasource.url=jdbc:mysql://localhost/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
# Configuração de segurança
api.security.token.secret=seu_segredo_jwt
```

3. Instale as dependências
```bash
mvn clean install
```

## 🌟 Endpoints Principais

### 🔑 Login
- `POST /login`: Autenticação de usuário

#### Exemplo de Requisição
```json
{
    "login": "usuario@email.com",
    "senha": "senha123"
}
```

#### Resposta de Sucesso
```json
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### 📝 Criar Tópico
- `POST /topicos`: Criar novo tópico

#### Exemplo de Requisição
```json
{
    "titulo": "Dúvida sobre Spring Boot",
    "mensagem": "Como configurar um projeto Spring Boot com MySQL?",
    "autor": "João Silva",
    "curso": "Spring Boot Básico"
}
```

### 📋 Listar Tópicos
- `GET /topicos`: Listar tópicos

#### Parâmetros de Paginação
- `page`: Número da página (padrão: 0)
- `size`: Quantidade de itens por página (padrão: 10)
- `sort`: Critério de ordenação (padrão: dataCriacao)

Exemplo: `/topicos?page=0&size=5&sort=titulo`

### 🔍 Detalhar Tópico
- `GET /topicos/{id}`: Detalhar tópico específico

#### Exemplo de URL
`/topicos/1`

#### Resposta de Sucesso
```json
{
    "id": 1,
    "titulo": "Dúvida sobre Spring Boot",
    "mensagem": "Como configurar um projeto Spring Boot com MySQL?",
    "dataCriacao": "2024-02-15T10:30:00",
    "status": "NAO_RESPONDIDO",
    "autor": "João Silva",
    "curso": "Spring Boot Básico"
}
```

### ✏️ Atualizar Tópico
- `PUT /topicos/{id}`: Atualizar tópico

#### Exemplo de Requisição
```json
{
    "titulo": "Configuração de Spring Boot com MySQL",
    "mensagem": "Passos detalhados para configurar MySQL em um projeto Spring Boot",
    "autor": "João Silva",
    "curso": "Spring Boot Avançado"
}
```

### 🗑️ Excluir Tópico
- `DELETE /topicos/{id}`: Excluir tópico

#### Exemplo de URL
`/topicos/1`

## 📖 Documentação da API
Acesse a documentação Swagger em: `http://localhost:8080/swagger-ui.html`

## 🔐 Autenticação
A API utiliza autenticação JWT. Após o login, inclua o token no header:
```
Authorization: Bearer {token}
```

## 🤝 Contribuição
1. Faça um fork do projeto
2. Crie sua feature branch (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 👥 Autor
**Edimaique Maciel**
- Email: edimaiqueacacio@gmail.com
