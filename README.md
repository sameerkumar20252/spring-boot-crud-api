# Spring Boot CRUD API

A REST API for Student CRUD operations built with **Spring Boot**, **Spring Data JPA** and **MySQL**.

## Features

- Create a new student
- View all students or a single student by ID
- Update student details
- Delete a student

## Tech Stack

- Java 17 (or the version in your `pom.xml`)
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven

## Project Structure

```
src/main/java/com/sameer/crudSpringBootDemo
├── controller   # REST endpoints (StudentController)
├── service      # Business logic (StudentService)
├── repository   # Database access (StudentRepository)
└── entity       # JPA entity (Student)
```

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven (or use the included `mvnw`)
- MySQL running on your machine

### Setup

1. **Clone the repository**

```
   git clone https://github.com/sameerkumar20252/spring-boot-crud-api.git
   cd spring-boot-crud-api
```

2. **Create a MySQL database**

```sql
   CREATE DATABASE your_database_name;
```

3. **Configure the application**

   Copy `src/main/resources/application.properties.example` to
   `src/main/resources/application.properties` and fill in your own details:

```
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
```

4. **Run the application**

```
   ./mvnw spring-boot:run
```

   On Windows, use `mvnw.cmd spring-boot:run`.
   The app starts at `http://localhost:8080`.

## API Endpoints

| Method | Endpoint          | Description            |
|--------|-------------------|------------------------|
| POST   | `/students`       | Add a new student      |
| GET    | `/students`       | Get all students       |
| GET    | `/students/{id}`  | Get a student by ID    |
| PUT    | `/students/{id}`  | Update a student       |
| DELETE | `/students/{id}`  | Delete a student       |

### Sample request body

```json
{
  "name": "Sameer Kumar",
  "email": "sameer@example.com"
}
```

## Testing

You can test the endpoints with [Postman](https://www.postman.com/) or `curl`:

```
curl http://localhost:8080/students
```

## Author

**Sameer Kumar**
GitHub: [@sameerkumar20252](https://github.com/sameerkumar20252)
