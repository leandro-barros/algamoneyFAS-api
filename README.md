<h1 style="text-align: center; font-weight: bold;">AlgamoneyFAS-api</h1>

<p align="center">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/leandro-barros/algamoneyFAS-api.svg">

  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/leandro-barros/algamoneyFAS-api.svg">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/leandro-barros/algamoneyFAS-api.svg">
  
  <a href="https://github.com/leandro-barros/algamoneyFAS-api/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/leandro-barros/algamoneyFAS-api.svg">
  </a>

  <a href="https://github.com/leandro-barros/algamoneyFAS-api/issues">
    <img alt="Repository issues" src="https://img.shields.io/github/issues/leandro-barros/algamoneyFAS-api.svg">
  </a>

  <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
</p>


<h4 align="center"> 
	🚧  AlgamoneyFAS-api ♻️ Concluído 🚀 🚧
</h4>

<p align="center">
 <a href="#-sobre-o-projeto">Sobre o Projeto</a> •
 <a href="#-executar-o-projeto">Executar Projeto</a> • 
 <a href="#-tecnologias">Tecnologias</a> • 
 <a href="#-autor">Autor</a> • 
 <a href="#-licença">Licença</a>
</p>

## 💻 Sobre o projeto

Projeto do curso Fullstack Angular e Spring da AlgaWorks. Foi implementado API Rest para controlar as despesas e receitas de pequenos estabelecimentos.

Repositório do Front-end: https://github.com/leandro-barros/algamoneyFAS-ui

Link curso: https://cafe.algaworks.com/fsas-inscricoes/

## 🚀 Executar o projeto

Este projeto é uma API RESTful desenvolvida com Spring Boot, possuindo endpoints expostos para efetuar requisições.

### Pré-requisitos

Para executar o projeto precisa ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java 8](https://aws.amazon.com/pt/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc) e [Postman](https://www.postman.com/). 
Além disto é bom ter um editor para trabalhar com o código como [Intellij](https://www.jetbrains.com/pt-br/idea/).

O Postman é para executar as requisições.

#### 🧭 Rodando a API REST

```bash
# Clone este repositório
$ git clone <https://github.com/leandro-barros/algamoneyFAS-api.git>

# Na classe principal execute o projeto.

# O servidor inciará na porta 8080

```

#### 🧭 Autenticação da API REST

Para fazer a autenticação, deve-se solicitar um token JWT, para isso faça a seguinte chamada:

```bash
# POST http://localhost:8080/oauth/token

```

No body da requisição, no Form URL Encoded (x-www-form-urlencoded), passe as seguintes chaves com seus respectivos valores:

| KEY        | VALUE     |
|------------|-----------|
| client     | framework |
| grant_type | password  |
| username   | admin(Usuário cadastrado quando API start)     | 
| password   | admin (Senha cadastrada quando API start)     | 

No header, passe as seguintes chaves com seus respectivos valores:

| KEY           | VALUE                             |
|---------------|-----------------------------------|
| Content-Type  | application/x-www-form-urlencoded |
| Authorization | Basic ZnJhbWV3b3JrOmZpcnN0        |

Ao realizar a autenticação, caso os dados informados estejam corretos, a API retornará objeto semelhante a este:

```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MjY5MDc5OTksInVzZXJfbmFtZSI6InRlc3RlMSIsImp0aSI6Ijk3YmQyNjQzLTNmNTAtNDlkOC1iZTIyLTRjMGQ2ZWVlYjBlOSIsImNsaWVudF9pZCI6ImZyYW1ld29yayIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.GftyR8_mc-dYyFCdxdfn_ex0Z7nIEolnS6D1gttaCUQ",
  "token_type": "bearer",
  "expires_in": 1799,
  "scope": "read write",
  "jti": "97bd2643-3f50-49d8-be22-4c0d6eeeb0e9"
}
```

O valor retornado no atributo "access_token" é o token que deverá ser utilizado nas chamadas que necessitam de autenticação. No header dessas requisições, passe a chave "Authorization" e no valor dela passe o token precedido pela palavra Bearer (ex.: "Bearer eyJhbGciOiJIUzI1..."). Obs.: o token tem duração de 1 dia.

## 🛠 Tecnologias

As seguintes ferramentas foram utilizadas no desenvolvimento do projeto:

- [Java 8](https://aws.amazon.com/pt/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL](https://www.mysql.com/downloads/)
- [Maven](https://maven.apache.org/)
- [JWT](https://jwt.io/)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring Authorization Server](https://spring.io/projects/spring-authorization-server)

## 👨‍💻 Autor

<a href="https://www.linkedin.com/in/leandroebarros/">
   <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/13985064?v=4" width="100px;" alt=""/>
  <br />
  <sub><b>Leandro Barros</b></sub></a> <a href="https://www.linkedin.com/in/leandroebarros/" title="leandro">🚀
</a>

[![Linkedin Badge](https://img.shields.io/badge/-Leandro-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/leandroebarros/)](https://www.linkedin.com/in/leandroebarros/) 
[![Gmail Badge](https://img.shields.io/badge/-leandroedbarros@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:leandroedbarros@gmail.com)](leandroedbarros@gmail.com)

## 📝 Licença

Projeto esta sobe a licença [MIT](./LICENSE).

By Leandro Barros ❤️  [Entre em contato!](https://www.linkedin.com/in/leandroebarros/)
