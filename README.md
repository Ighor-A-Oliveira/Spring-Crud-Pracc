# Crud Simples

Crud Simples feito para praticar os fundamentos de Spring Boot

[![Java 25](https://img.shields.io/badge/Java-25-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3+-green)](https://spring.io/projects/spring-boot)
[![H2 Database](https://img.shields.io/badge/H2-2.x-blue)](https://www.h2database.com/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue)](https://maven.apache.org/)


## Funcionalidades implementadas
- Adicionar Usuarios
- Deletar Usuario por Id ou por Email
- Buscar Usuario por Id ou por Email
- Buscar Todos os Usuarios
- Atualiza dados do registro de usuario especifico buscando pelo Id ou Email


## Pré-requisitos
| Ferramenta   | Versão mínima | Comando de verificação |
|--------------|---------------|-------------------------|
| Java JDK     | 25            | `java -version`        |
| Maven        | 3.9+         | `mvn -v`               |
| H2   | 2.0+           | `h2 --version`       |


## Como rodar
- git clone `git@github.com:Ighor-A-Oliveira/Spring-Crud-Pracc.git`
- cd Spring-Crud-Pracc
- Va em application.properties e veja se tem tem a configuração spring.datasource.url=jdbc:h2:mem:usuario
- mvn clean install
- mvn spring-boot:run
> **Aplicação disponível em: http://localhost:8080*

## Application.properties

```properties
# JPA / Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# H2 Database
spring.datasource.url=jdbc:h2:mem:usuario
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Console do H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```




## Endpoints da API 

| Método | Rota                                   | Descrição                              | Auth     |
|--------|----------------------------------------|----------------------------------------|----------|
| **POST** | `/usuario/add`                     | Adiciona usuário                       | Pública  |
| **GET** | `/usuario/buscar/all`                        | Retorna uma lista com todos os usuarios   | Pública  |
| **GET** | `/usuario/buscar/por-id`                 | Busca usuario pelo id              | Pública      |
| **GET** | `/usuario/buscar/por-emaill`                  | Busca usuario pelo email      | Pública      |
| **DELETE** | `/usuario/deletar/por-id`              | Delete usuario especifico pelo id | Pública      |
| **DELETE** | `/usuario/deletar/por-email`             | Delete usuario especifico pelo email  | Pública      |
| **PUT** | `/usuario/atualizar/por-id`     | Atualiza dados de usuario especifico pelo id | Pública      |
| **PUT** | `/usuario/atualizar/por-email`     | Atualiza dados de usuario especifico pelo email | Pública      |





