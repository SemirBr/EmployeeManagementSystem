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

## API Endpoints

### Employee

- `GET /api/employees`: Retrieve all employees.
- `GET /api/employees/{id}`: Retrieve an employee by ID.
- `POST /api/employees`: Create a new employee.
- `PUT /api/employees/{id}`: Update an employee by ID.
- `DELETE /api/employees/{id}`: Delete an employee by ID.

### Projects

- `GET /api/projects`: Retrieve all projects.
- `GET /api/projects/{id}`: Retrieve a project by ID.
- `POST /api/projects`: Create a new project.
- `PUT /api/projects/{id}`: Update a project by ID.
- `DELETE /api/projects/{id}`: Delete a project by ID.

### EmployeeProjectSystem

- `GET /api/employeeprojectsystems`: Retrieve all employee-project relationships.
- `GET /api/employeeprojectsystems/{id}`: Retrieve an employee-project relationship by ID.
- `POST /api/employeeprojectsystems`: Create a new employee-project relationship.
- `PUT /api/employeeprojectsystems/{id}`: Update an employee-project relationship by ID.
- `DELETE /api/employeeprojectsystems/{id}`: Delete an employee-project relationship by ID.

## Testing

You can test the API endpoints using tools like Postman. Send HTTP requests to the respective endpoints (as mentioned above) to perform CRUD operations on the entities.

## Database SQL File

The SQL file for the database setup can be found within the project. Ensure proper configurations and security measures before deploying in production environments.


