# CURD_Using_Database_Student

This is a Spring Boot-based CRUD (Create, Read, Update, Delete) application that manages student information in a database. It provides RESTful APIs for handling students and their associated departments, with a MySQL database backend.

###Note : please add first department then students

## Table of Contents
**Java 17**: Programming language used for the backend logic.
- **Spring Boot 3**: Framework for building the CRUD application.
- **Spring Data JPA**: For interacting with the MySQL database in an object-oriented way.
- **Hibernate**: ORM tool used under Spring Data JPA for managing entity relationships.
- **MySQL**: Relational database for storing student and department data.
- **Maven**: For project build and dependency management.
- **Postman**: For testing the REST APIs.
- **Maven Dependencies**:spring web,spring Data JPA, MySQL Driver, Dev tools(optional), Lombok(optional)

##Database Configuration

The application uses a MySQL database to store student and department information. You can configure the database connection details in the `application.properties` file located in the `src/main/resources` directory.

Here is an example configuration:

```properties
server.port=(port number) i.e 8080
spring.datasource.url=jdbc:mysql://localhost:3306/(your database name)
spring.datasource.username=(database username)
spring.datasource.password=(database password)
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true

Note:remove the () and replace them with your configuration.
```

## API Endpoints

### Student APIs

- **Create Students**
	`POST /api/students`
	Request Body:
    `json`
    `{`
    `"studentName": "name",`
    `"studentAge": "age",`
    `"studentNumber": number,`
    `"departmentName": "dept name"`
  	`}`
  	
- **Get All Students**
	`GET /api/students`
	
- **Get Student By ID**
	`GET /api/students/{Id}`
	
- **Update Student**
	`PUT /api/students/{Id}`
	Request Body:
    `json`
  
- **Update Student**
	`DELETE /api/students/{Id}`
    

### Department APIs
- **Get All Departments**
	`GET /departments`

- **Get Department by Name**
	`GET /departments/{departmentName}`

## Running the Application
Once you've configured the database and built the project, you can run the application using the following command:

```bash
mvn spring-boot:run
```
OR use your IDE and run the main class where @SpringBootApplication is present

###Future Enhancements

- Implement authentication and authorization using Spring Security to secure the API.
- Add pagination and sorting for the list of students to improve performance.
- Create Swagger documentation for easier API management and testing.
- Add frontend integration using React or Angular to provide a user-friendly interface for managing students and departments.


    

   







