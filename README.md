# SpringWithMongoDb
## Sobre o projeto
O SpringWithMongoDb é uma API REST desenvolvida com Spring Boot que realiza operações de CRUD utilizando o MongoDB como banco de dados NoSQL.

O objetivo do projeto é demonstrar boas práticas no desenvolvimento backend, incluindo:
- Arquitetura em camadas
- Uso de DTOs
- Construção de endpoints RESTful
- Integração com banco NoSQL

## Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Web
- Spring Data MongoDB
- MongoDB
- Postman
- MongoDB Compass

## Estrutura do projeto
O projeto segue uma organização em camadas:
```
src/main/java
├── controllers   # Endpoints da API
├── services      # Regras de negócio
├── repositories  # Acesso ao banco (MongoDB)
├── domain        # Entidades
├── dto           # Objetos de transferência de dados
```
## Funcionalidades
- Criar novos registros
- Listar todos os registros
- Buscar registro por ID
- Atualizar dados existentes
- Remover registros
- Integração com MongoDB
- API RESTful para integração com outros sistemas

## Endpoints
| Método | Endpoint               | Descrição                                      |
|--------|------------------------|-----------------------------------------------|
| GET    | /users                | Lista todos os usuários                        |
| GET    | /users/{id}           | Busca usuário por ID                           |
| POST   | /users                | Cria um novo usuário                           |
| PUT    | /users/{id}           | Atualiza um usuário                            |
| DELETE | /users/{id}           | Remove um usuário                              |
| GET    | /users/{id}/posts     | Lista as postagens de um usuário               |
| GET    | /posts/{id}           | Busca uma postagem por ID                      |
| GET    | /posts/titlesearch    | Busca postagens por título (query param text)  |
| GET    | /posts/fullsearch     | Busca completa (texto, minDate, maxDate)       |
