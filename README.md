# Challenge API

**Java Version:** 11

**Spring Boot Version:** 2.5.2

**Docker Base image:** OpenJDK 11 (AdoptOpenJDK)

**Database image:** Postgres 13.1 Alpine

## Requirements

### Environment

- [Docker](https://www.docker.com/get-started) and [Docker Compose](https://docs.docker.com/compose/install/)

#### Build
- [Maven](https://maven.apache.org/install.html)
- [Java 11](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html)

#### Test
- [Mockito](https://site.mockito.org/)
- [JUnit](https://junit.org/junit5/)

## Development

### Basic commands
#### Up project
```
mvn clean package
docker-compose build
docker-compose up -d
```

## Testing
### Run tests

```
mvn test
```

## Documentation
- [Swagger](https://swagger.io/)
- Once the project is UP, you can access it from http://localhost:8080/swagger-ui.html
