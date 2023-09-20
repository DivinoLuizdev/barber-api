# SistemaDeGestaodeBarbearias

# BarberData API

A BarberData API é uma aplicação Java baseada no framework Spring Boot que oferece uma série de funcionalidades relacionadas a barbearias, incluindo autenticação de usuários, registro de novos usuários, e outras operações relacionadas. A API é documentada e pode ser testada facilmente usando o Swagger UI.

## Pré-requisitos

Antes de começar a usar a BarberData API, você precisará ter as seguintes ferramentas e configurações em seu sistema:

- **Java Development Kit (JDK)**: Certifique-se de ter o JDK instalado em sua máquina. Você pode fazer o download do JDK mais recente em [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html).

- **Maven**: A API utiliza o Maven como sistema de automação de compilação. Você pode fazer o download do Maven em [Maven](https://maven.apache.org/download.cgi).

- **Banco de Dados PostgreSQL**: É necessário ter um servidor PostgreSQL configurado em sua máquina. Certifique-se de ter as seguintes informações configuradas:
  - **Driver**: org.postgresql.Driver
  - **URL**: jdbc:postgresql://localhost:5433/projetoJWT2
  - **Usuário**: postgres
  - **Senha**: "12345"

## Configuração e Execução

Siga as etapas abaixo para configurar e executar a BarberData API:

1. Clone este repositório para o seu sistema:

```bash
git clone https://github.com/seu-usuario/barberdata-api.git
```
 
A BarberData API estará agora disponível em http://localhost:8080.

## Documentação da API
A documentação da API é gerada automaticamente e pode ser acessada através do Swagger UI em http://localhost:8080/swagger-ui.html. Neste ambiente, você pode explorar e testar todos os endpoints disponíveis na API.

Para autenticar-se, você precisará fornecer um token JWT válido no formato Bearer {seu_token}. Certifique-se de estar autenticado antes de acessar endpoints protegidos.
```
http://localhost:8080/auth/register
```
```
{
  "login": "String",
  "password": "String",
  "role": "ADMIN" OR USER
}
```
```
http://localhost:8080/auth/login
```
```
{
  "login": "String",
  "password": "String" 
}
```
Retorno:
```
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIs444InN1YiI6ImRpdmlub1dhciIsImV4cCI6MTY5NTI1NTgyMX0.zon3hoh6GWgGZPX-zphAq4dhbsI-LSE2DcTgsIuo_Tg"
}
```

## Estrutura do Projeto
> O projeto segue uma estrutura de pasta organizada da seguinte forma:
```
|-- api
|   |-- barberdata
|       |-- controller
|       |-- domain
|       |   |-- dto
|       |   |-- enums
|       |   |-- user
|       |-- repository
|       |-- security
|       |-- service
|           |-- Authorization
|               |-- interfaces
```
## Dependências Principais

Este projeto utiliza as seguintes dependências principais:

> Spring Boot: Um framework de desenvolvimento Java que facilita a criação de aplicativos web e APIs RESTful.

> Spring Security: Utilizado para lidar com autenticação e autorização de usuários.

> Springdoc OpenAPI: Uma biblioteca que facilita a documentação da API e sua integração com o Swagger UI.

> Swagger UI: Uma interface que permite visualizar e testar facilmente a API diretamente no navegador.

> PostgreSQL: O banco de dados PostgreSQL é utilizado para armazenar os dados da aplicação.

## Contribuição
Sinta-se à vontade para contribuir com melhorias ou correções neste projeto. Você pode abrir problemas (issues) ou enviar pull requests com suas contribuições.

## Licença
Este projeto é licenciado sob a MIT [License](https://www.mit.edu/~amini/LICENSE.md) . Consulte o arquivo LICENSE para obter mais informações.
 
