# TR - BD 2025.1 - UNIUFC
## UniUFC-BD: Sistema de Controle Acadêmico

Este repositório contém o sistema de controle acadêmico **UniUFC-BD** desenvolvido para a disciplina de **Banco de Dados (Período 2025.1)** da Engenharia da Computação no Campus de Sobral da UFC.  
O sistema oferece funcionalidades para gerenciar dados de departamentos, cursos, disciplinas, professores e alunos, incluindo autenticação de usuários e diversas consultas.

### EQUIPE 9
- 569944, FRANCISCO ANTONIO PAIVA DE SOUSA, fcoantoniops@alu.ufc.br
- 495228, RENATO FERREIRA GOMES RODRIGUES, renatofgomesr@alu.ufc.br
- 555616, VICTOR EDUARDO PITA CAMPOS, victorcampos@alu.ufc.br

---

## 📚 Tabela de Conteúdo

- [Visão Geral do Projeto](#-visão-geral-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração do Ambiente](#️-configuração-do-ambiente)
    - [Pré-requisitos](#pré-requisitos)
    - [Configuração do Banco de Dados](#configuração-do-banco-de-dados)
- [Compilação e Execução](#compilação-e-execução)
- [Documentação da API (Swagger UI)](#-documentação-da-api-swagger-ui)
- [Endpoints da API](#-endpoints-da-api)

---

## 🚀 Visão Geral do Projeto

O **UniUFC-BD** é uma aplicação Spring Boot que interage com um banco de dados MySQL para armazenar e recuperar informações acadêmicas.  
Ele expõe uma API RESTful com diferentes níveis de acesso: DBA, Servidor, Professor, Aluno e Anônimo.

---

## Tecnologias Utilizadas

- **Linguagem:** Java
- **Framework:** Spring Boot
- **Banco de Dados:** MySQL (5.7+)
- **Modelagem:** MySQL Workbench (8.0+)
- **Gerenciamento de Dependências:** Maven
- **Documentação da API:** Swagger/OpenAPI 3
- **Migração de Banco:** Flyway

---

## ⚙️ Configuração do Ambiente

### Pré-requisitos

Certifique-se de ter instalado:

- Java JDK 17+
- Apache Maven 3.x
- MySQL Server 5.7+
- MySQL Workbench (opcional)

---

### Configuração do Banco de Dados

1. **Crie o banco de dados:**

```sql
CREATE DATABASE nome_qualquer;
USE nome_qualquer;
```

2. **Scripts de criação e povoamento:**

Os arquivos `.sql` devem estar na pasta:
```
src/main/resources/db/migration
```

> Já estão inclusos os scripts de criação e povoamento do banco de dados.

3. **application.properties:**

Atualize as credenciais criando um arquivo ".env" na pasta raiz do projeto com as seguintes varáveis de ambiente:

```
MY_URL=url
MY_DATABASE=database
MY_USERNAME=meu_usuario
MY_PASSWORD=minha_senha
```

**Como é usado no application-properties:**

```properties
spring.application.name=TrabalhoBD-2025_1-UniUFC

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://${MY_URL}/${MY_DATABASE}?sslmode=verify-full
spring.datasource.username=${MY_USERNAME}
spring.datasource.password=${MY_PASSWORD}

spring.jpa.open-in-view=false
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.hbm2ddl.auto=none
spring.jpa.properties.hibernate.transaction.jta.platform=org.hibernate.service.jta.platform.internal.NoJtaPlatform

spring.datasource.hikari.max-lifetime=1800000
spring.datasource.hikari.idle-timeout=600000
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.maximum-pool-size=30

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.baseline-on-migrate=true

server.servlet.context-path=/api/v1/

# Swagger Config
springdoc.swagger-ui.disable-swagger-default-url=true
springdoc.swagger-ui.operationsSorter=alpha
springdoc.swagger-ui.tagsSorter=alpha

server.servlet.encoding.charset=UTF-8
server.servlet.encoding.enabled=true
server.servlet.encoding.force=true

# Informações da API
app.api.title=UniUFC API
app.api.description=API para consulta de alunos, cursos e professores.
app.api.version=1.0.0
app.api.contact.name=Victor Eduardo
app.api.contact.email=victoreduardodev@gmail.com
app.api.license.name=UFC
app.api.server.local.url=http://localhost:8080/api/v1
app.api.server.local.description=Servidor Local
```

---

## 🧪 Compilação e Execução

```bash
git clone https://github.com/seu-usuario/UniUFC-BD.git
cd UniUFC-BD
mvn clean install
mvn spring-boot:run
```

> A aplicação estará disponível em: `http://localhost:8080/api/v1/`

---

## 📖 Documentação da API (Swagger UI)

Acesse:  
[http://localhost:8080/api/v1/swagger-ui.html](http://localhost:8080/api/v1/swagger-ui.html)

---

## 🌐 Endpoints da API

### 🔐 Autenticação (`/uniufc/auth`)

| Método | Endpoint              | Descrição                                  | Permissão |
|--------|------------------------|--------------------------------------------|-----------|
| POST   | `/auth/login`         | Autentica e retorna JWT                    | ANONYMOUS |
| POST   | `/auth/refresh`       | Atualiza JWT usando refresh token          | ANONYMOUS |
| POST   | `/auth/revoke`        | Revoga um refresh token                    | ANONYMOUS |

### 🎓 Alunos (`/uniufc`)

| Método | Endpoint                        | Descrição                                  | Parâmetro           |
|--------|----------------------------------|--------------------------------------------|---------------------|
| GET    | `/disciplinas-aluno`           | Lista disciplinas cursadas/cursando        | `matricula`         |
| GET    | `/disciplinas-concluidas`      | Lista disciplinas concluídas               | `matricula`         |
| GET    | `/info-aluno`                  | Dados pessoais do aluno                    | `matricula`         |
| GET    | `/curso-aluno`                 | Curso atual do aluno                       | `matricula`         |

### 🎓 Cursos (`/uniufc`)

| Método | Endpoint                        | Descrição                                  | Parâmetro           |
|--------|----------------------------------|--------------------------------------------|---------------------|
| GET    | `/disciplinas-obrigatorias`    | Lista de obrigatórias do curso             | `curso`             |
| GET    | `/disciplinas-optativas`       | Lista de optativas do curso                | `curso`             |
| GET    | `/alunos-curso`                | Lista de alunos do curso                   | `curso`             |
| GET    | `/alunos-curso-obrigatorias`   | Alunos nas obrigatórias                    | `curso`             |
| GET    | `/alunos-curso-optativas`      | Alunos nas optativas                       | `curso`             |

### 🏛️ Departamentos (`/uniufc`)

| Método | Endpoint                | Descrição                                  | Parâmetro  |
|--------|--------------------------|--------------------------------------------|------------|
| GET    | `/cursos-dep`          | Cursos de um departamento                  | `dep`      |
| GET    | `/departamento-info`   | Informações do departamento                | `dep`      |

### 📚 Disciplinas (`/uniufc`)

| Método | Endpoint                | Descrição                                  | Parâmetro  |
|--------|--------------------------|--------------------------------------------|------------|
| GET    | `/alunos-matriculados` | Alunos matriculados em uma disciplina      | `dis`      |
| GET    | `/pre-requisitos`      | Pré-requisitos da disciplina               | `dis`      |
| GET    | `/open-disciplinas`    | Disciplinas abertas relacionadas           | `dis`      |

### 👨‍🏫 Professores (`/uniufc`)

| Método | Endpoint                | Descrição                                  | Parâmetro     |
|--------|--------------------------|--------------------------------------------|---------------|
| GET    | `/professor-disciplinas` | Disciplinas ministradas por um professor   | `siape`       |
| GET    | `/professor-alunos`     | Alunos orientados na pós-graduação         | `siape`       |

---