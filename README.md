API REST criada com Java junto com SpringBoot para operações de CRUD, implementando a Autenticação JWT e usando MySQL como banco de dados.
## 🛠️ Tecnologias
- JSON Web Token
- Spring Boot
- MySQL
- JPA
- Spring Security
## 🚀 Como rodar
1.Ter o Java
2.Fazer Configuração e Dowload do framework Spring Boot
3.Ter o MySQL instalado 
4.Configurar o banco de dados no arquivo "api-spring-java\src\main\resources\application.properties"
5.Configurar o banco de dados no arquivo "api-spring-java\src\main\java\com\claudio\tarefas\Tarefa.java"
## 📋 Endpoints
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | /tarefas | Recupera lista de tarefas |
| POST | /tarefas | Cria uma nova tarefa |
| PUT | /tarefas | Atualiza uma tarefa pelo id |
| DELETE | /tarefas | Exclui uma tarefa |
| POST | /auth/register | Cadastra um novo usuário |
| POST | /auth/login | Retorna o token JWT |
## 🔒 Autenticação
As rotas `/tarefas` requerem autenticação. 
Faça login em `/auth/login` e use o token retornado no header:
Authorization: Bearer {token}
