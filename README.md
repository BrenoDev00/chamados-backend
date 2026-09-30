# chamados-backend
Repositório back-end do projeto de chamados.

## Descrição
- Aplicação para acompanhamento e gerenciamento de chamados realizados por técnicos de monitoramento NOC.

## Funcionalidades
- Cadastrar, listar, editar, excluir e pesquisar chamados.
- Cadastrar, listar, editar, excluir e pesquisar por equipamentos.
- Listar e editar técnicos do sistema.
- Autenticação JWT.

## Tecnologias utilizadas
- Java 25
- Spring Boot 4
- Spring Data
- Spring Security
- Docker e Docker Compose
- Swagger
- Banco de dados Postgres
- Banco em memória H2
- Gerenciador de dependências Maven
- I.A Gemini para apoio em tarefas e sugestões

## [Regras de negócio](./docs/business-rules.md)

## [Modelagem de dados](./docs/data-model.png)

## [Repositório front-end](https://github.com/BrenoDev00/chamados-frontend)

## Como executar a aplicação full stack

- É necessário incluir um arquivo [docker-compose.yaml](./docs/infra/docker-compose.txt) (infra) e um arquivo [initialize.sh](./docs/infra/initialize.txt) (instancia os containers da aplicação) na raiz da aplicação e executar o script initialize.
- Também é necessário incluir um arquivo .env conforme exemplos dos .env.example na raiz de cada repositório, e preencher as variáveis de ambiente.
- Observação: as pastas locais do front-end e back-end devem se chamar frontend e backend, respectivamente.
