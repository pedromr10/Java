# SimpleTaskList
## Descrição
O SimpleTaskList permite criar, listar, concluir e remover tarefas de forma estruturada, demonstrando boas práticas de desenvolvimento com Spring Boot, persistência com JPA/Hibernate e uso de enums e DTOs.

## Funcionalidades
- Criar novas tarefas
- Listar todas as tarefas
- Marcar tarefas como concluídas
- Remover tarefas
- Persistência de dados via banco relacional
- Estrutura RESTful para futuras integrações

## Tecnologias
- Java 17+
- Spring Boot
- Spring Data JPA / Hibernate
- Banco de dados H2 (testes)
- Maven (gerenciamento de dependências)

#  SpringWithMongoDb

## Descrição
O SpringWithMongoDb é uma API REST desenvolvida com Spring Boot que realiza operações de CRUD utilizando o MongoDB como banco de dados NoSQL.
O projeto tem como objetivo demonstrar boas práticas de desenvolvimento backend, incluindo organização em camadas, uso de DTOs e construção de endpoints RESTful.

## Funcionalidades
- Criar novos registros  
- Listar todos os registros  
- Buscar registro por ID  
- Atualizar dados existentes  
- Remover registros  
- Integração com MongoDB  
- Estrutura RESTful para integração com outras aplicações
  
## Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Web
- Spring Data MongoDB
- MongoDB
- Postman
- MongoDB Compass
- Eclipse STS

## Endpoints (exemplo)

```http
GET    /users        -> Lista todos os usuários
GET    /users/{id}   -> Busca usuário por ID
POST   /users        -> Cria um novo usuário
PUT    /users/{id}   -> Atualiza um usuário
DELETE /users/{id}   -> Remove um usuário
