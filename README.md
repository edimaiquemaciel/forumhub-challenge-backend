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
- `POST /login`: Autenticação de usuário
- `POST /topicos`: Criar novo tópico
- `GET /topicos`: Listar tópicos
- `GET /topicos/{id}`: Detalhar tópico específico
- `PUT /topicos/{id}`: Atualizar tópico
- `DELETE /topicos/{id}`: Excluir tópico
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
6. 
## 👥 Autor
**Edimaique Maciel**
- Email: edimaiqueacacio@gmail.com
