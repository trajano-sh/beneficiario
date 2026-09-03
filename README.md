# Beneficiários API

API REST para gerenciamento de beneficiários e seus documentos.

## Tecnologias

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Bean Validation
* H2 Database
* Lombok
* Maven

## Endpoints

| Método   | Endpoint                       | Descrição             |
| -------- | ------------------------------ | --------------------- |
| `GET`    | `/api/v1/recipients`           | Lista beneficiários   |
| `GET`    | `/api/v1/recipients/{id}`      | Busca beneficiário    |
| `POST`   | `/api/v1/recipients`           | Cadastra beneficiário |
| `PUT`    | `/api/v1/recipients/{id}`      | Atualiza beneficiário |
| `DELETE` | `/api/v1/recipients/{id}`      | Remove beneficiário   |
| `POST`   | `/api/v1/recipients/{id}/docs` | Adiciona documentos   |

## Executando

```bash
git clone https://github.com/trajano-sh/beneficiario.git
cd beneficiario
./mvnw spring-boot:run
```

A aplicação ficará disponível em:

```text
http://localhost:8080
```

## Estrutura

```text
controller
database
dto
exceptions
mapper
service
```

## Autor

[trajano-sh](https://github.com/trajano-sh)
