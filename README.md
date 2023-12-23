# RESTful Java API with CRUD Operations

This project is a backend-only application implementing a RESTful API using Java. It features CRUD (Create, Read, Update, Delete) operations for managing entities related to an employee system. It does not include any frontend components and can be tested using Postman.

## Project Structure

The project follows a structured design with the following components:

- **Entities**: Contains the data models for Employee, Projects, and EmployeeProjectSystem.
- **Controllers**: Handles incoming HTTP requests, interacts with services, and returns appropriate responses.
- **Services**: Implements business logic and interacts with repositories.
- **Mappers**: Maps between entities and DTOs (Data Transfer Objects).
- **DTOs**: Holds data used for transferring information between layers.
- **Exceptions**: Manages custom exceptions for error handling.

## Technologies Used

- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework for building and deploying Java applications.
- **MySQL**: Database management system utilized with the following configurations:
  - Database URL: `jdbc:mysql://localhost:3306/employeesystem`
  - Username: `root`
  - Hibernate Dialect: `org.hibernate.dialect.MySQLDialect`
  - Hibernate DDL auto: `update`

## Database Configuration

The application uses MySQL as the database. The database configuration can be found in the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employeesystem
spring.datasource.username=root
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update

