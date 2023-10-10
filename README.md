# Projeto Spring-SpotMusic

O Spring-SpotMusic é um projeto de exemplo que demonstra a criação de uma aplicação web usando tecnologias como Spring Boot, Spring Data JPA, Hibernate, Thymeleaf e Bootstrap. Este projeto oferece uma plataforma básica para gerenciar playlists de músicas.

## Tecnologias Utilizadas

- **Spring Boot**: Um framework que simplifica o desenvolvimento de aplicativos Java baseados em Spring.
- **Spring Data JPA e Hibernate**: Para persistência de dados e manipulação do banco de dados.
- **Thymeleaf**: Um mecanismo de template que permite a renderização de páginas HTML no lado do servidor.
- **Bootstrap**: Um framework de código aberto para desenvolvimento de interfaces web responsivas.

## Funcionalidades

- **Criação e Gerenciamento de Playlists**: Os usuários podem criar playlists de músicas.
- **Adição e Remoção de Músicas**: Os usuários podem adicionar e remover músicas de suas playlists.
- **Validação de Dados**: A aplicação utiliza validação de dados para garantir que as informações inseridas sejam corretas.

## Configuração

1. Clone o repositório do projeto para sua máquina local:
2. git clone https://github.com/RafaelWillian91/Project-Spring-SpotMusic.git
3. Importe o projeto em sua IDE preferida.
4. Configure as propriedades do banco de dados no arquivo `application.properties` ou `application.yml`.
  Exemplo application.yml:
    spring:
  mvc:
    hiddenmethod:
      filter:
        enabled: true
  datasource:
    url: jdbc:mysql://localhost/SuaBasedeDados?useSSL=false&createDatabaseIfNotExist=true
    username: seuUsuario
    password: SuaSenha
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
      show-sql: true
      properties:
      hibernate:
      dialect: org.hibernate.dialect.MySQL5Dialect

6. Execute o projeto.
7. Acesse a aplicação no navegador em [http://localhost:8080](http://localhost:8080).

## Contribuição

Sinta-se à vontade para contribuir com melhorias neste projeto. Basta fazer um fork do repositório, implementar suas melhorias e enviar um pull request.

## Autor -> Rafael Willian

Este projeto foi desenvolvido por [Rafael Willian](https://github.com/RafaelWillian91).

## Licença

Este projeto é licenciado sob a Licença MIT.



