# Spring Boot Template project

This is a template project for Spring Boot applications. 

## Features
- Exposes an API to perform CRUD operations on a single entity
- Connects to a PostgreSQL database
- Uses Spring data JPA for database operations
- Uses Flyway for database migration
- Uses Spring Boot Docker Compose to manage a Docker container running the PostgreSQL database
- Includes a datasource configuration for testing purposes that uses the H2 in-memory database

### Database migrations with Flyway
Flyway configuration is located in `application.yaml`.

### Spring Boot Docker Compose
With Spring Boot Docker Compose, the container running the PostgreSQL database will be automatically started when the application is started and stopped when the application is stopped.

Spring Boot Docker Compose will detect and use the `docker-compose.yml` file located in the root of the project. 

### Running the application
To run the application, execute the following command:
```shell 
mvn spring-boot:run