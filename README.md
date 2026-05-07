# Employee Management System

Employee Management System is a Java Spring Boot backend project for managing employee records. The application is set up as a Maven-based REST backend with MySQL persistence, Spring Data JPA, and Spring Boot Actuator support.

## Project Status

This repository currently contains the backend foundation for the Employee Management System:

- Spring Boot application entry point
- Maven project configuration
- MySQL datasource configuration
- JPA support for future employee entities and repositories
- Web MVC support for future REST controllers
- Actuator dependency for health and monitoring endpoints
- Basic Spring Boot context test

Employee CRUD domain files such as controllers, services, entities, DTOs, and repositories can be added under the existing Java package as the application grows.

## Tech Stack

- Java 21
- Spring Boot 4.0.2
- Spring Web MVC
- Spring Data JPA
- MySQL
- Maven Wrapper
- Lombok
- JUnit 5

## Project Structure

```text
Employee Management System/
+-- README.md
+-- .gitignore
`-- ems-backend/
    +-- pom.xml
    +-- mvnw
    +-- mvnw.cmd
    +-- .mvn/
    `-- src/
        +-- main/
        |   +-- java/
        |   |   `-- com/javaproject/ems_backend/
        |   |       `-- EmsBackendApplication.java
        |   `-- resources/
        |       `-- application.properties
        `-- test/
            `-- java/
                `-- com/javaproject/ems_backend/
                    `-- EmsBackendApplicationTests.java
```

## Prerequisites

Install these tools before running the project:

- JDK 21 or newer
- MySQL Server
- Git

Maven does not need to be installed separately because the project includes the Maven Wrapper.

## Database Setup

Create a MySQL database for the application:

```sql
CREATE DATABASE ems;
```

The application uses the following default datasource values:

| Setting | Default value |
| --- | --- |
| Database URL | `jdbc:mysql://localhost:3306/ems` |
| Username | `root` |
| Password | empty |
| Server port | `8081` |

You can override the datasource values with environment variables.

PowerShell:

```powershell
$env:SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/ems"
$env:SPRING_DATASOURCE_USERNAME="root"
$env:SPRING_DATASOURCE_PASSWORD="your_mysql_password"
```

Bash:

```bash
export SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/ems"
export SPRING_DATASOURCE_USERNAME="root"
export SPRING_DATASOURCE_PASSWORD="your_mysql_password"
```

## Running the Application

From the backend folder:

```powershell
cd ems-backend
.\mvnw.cmd spring-boot:run
```

On macOS or Linux:

```bash
cd ems-backend
./mvnw spring-boot:run
```

The application starts on:

```text
http://localhost:8081
```

If Actuator endpoints are enabled by your Spring Boot configuration, the health endpoint is available at:

```text
http://localhost:8081/actuator/health
```

## Running Tests

From the backend folder:

```powershell
.\mvnw.cmd test
```

On macOS or Linux:

```bash
./mvnw test
```

## Configuration

The main configuration file is:

```text
ems-backend/src/main/resources/application.properties
```

Important properties:

```properties
spring.application.name=ems-backend
server.port=8081
spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:mysql://localhost:3306/ems}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:root}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:}
spring.jpa.hibernate.ddl-auto=update
```

`spring.jpa.hibernate.ddl-auto=update` lets Hibernate update the database schema during development. For production, use a controlled migration tool such as Flyway or Liquibase.

## Suggested Employee API Design

The project is ready for REST endpoints such as:

| Method | Endpoint | Purpose |
| --- | --- | --- |
| `GET` | `/api/employees` | List all employees |
| `GET` | `/api/employees/{id}` | Get one employee |
| `POST` | `/api/employees` | Create an employee |
| `PUT` | `/api/employees/{id}` | Update an employee |
| `DELETE` | `/api/employees/{id}` | Delete an employee |

A typical Spring Boot package layout for those features would be:

```text
com.javaproject.ems_backend
+-- controller
+-- dto
+-- entity
+-- exception
+-- repository
`-- service
```

## GitHub Setup

This folder can be published as a GitHub repository with:

```powershell
git init -b main
git add README.md .gitignore ems-backend
git commit -m "Initial employee management system backend"
```

After creating an empty repository on GitHub, connect it with:

```powershell
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPOSITORY_NAME.git
git push -u origin main
```

If you install GitHub CLI, you can create and push the GitHub repository directly from the terminal:

```powershell
gh auth login
gh repo create YOUR_USERNAME/YOUR_REPOSITORY_NAME --public --source . --remote origin --push
```

Use `--private` instead of `--public` if the repository should not be public.

## License

No license has been added yet. Add a license before publishing if you want others to know how they may use, modify, or share this project.
