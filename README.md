# FlyingPostgres
#### Demo application to show how connect and use Postgres SQL database with Flyway migration tool.

Due to many users has set their Postgres SQL instances on localhost environment on port 5432, docker compose file is prepared to set Postgres SQL database listen on port 5433 to avoid issues.

Prerequisites:
- JDK 17
- Maven
- IDEA IntelliJ
- Docker

Build and run application with using IDEA IntelliJ:
1. Open terminal from root folder and run ```docker compose up -d```
2. Wait about 20 seconds for Postgres SQL docker container to wake up.
3. Build application by running command ```mvn clean install```
4. Run application as Spring Boot project

You can check database tables by connecting to the Postgres SQL docker container via pgAdmin (use credentials provided in application.properties file).

You can examine application by calling endpoint: \
``curl -X GET http://localhost:8080/api/user/all``

