# sistema-votacao-de-pauta

O sistema criada para cadastrar uma nova pauta, iniciar uma nova sessão, votar e consultar o resultado da votação.

# Documentação do projeto

## Frontend

Link abaixo para documentação da api no Swagger (Open api)
[http://localhost:8080/swagger-ui/index.html] 

Scripts disponiveis
Dentro da pasta frontend, você pode rodar:

yarn start
Executa o aplicativo no modo desenvolvimento.
Abra http://localhost:3000 para visualizar no browser.

A página será recarregada se você fizer edições.
Você também irá se deparar com qualquer erro de lint no console.

## Backend

- Deve subir o docker para rodar o mysql
- O spring está rodando na porta 8080

## Regras de Negócio
Deve-se seguir a ordem lógica de operações conforme descrito abaixo:
- Criar uma pauta;
- Abrir a sessão de votação;
- Realizar as votações dentro do tempo padrão de 1 minuto;
- Listar as pautas com seus resultados;

### Tecnologias
- Java 17
- Swagger
- Spring Boot Frmakework
- Docker
- React Js
- Mysql
- Mapstruct para mapear os atributos json [https://mapstruct.org/]
- Testes unitários com JUnit
