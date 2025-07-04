

# Wish List – Spring Boot Web Application

This is a simple web application for managing a **wish list**, built using **Spring Boot**, **Thymeleaf**, **PostgreSQL**, and **Maven**.

## Features

- Add new items to the wish list
- Edit existing items
- Delete items
- Sort items by priority (ascending/descending)
- Sort items by price (ascending/descending)
- REST API available at `/api/lista`

## Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Maven

## Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-username/wishlist-app.git
cd wishlist-app
```

### 2. Configure the PostgreSQL database

Make sure PostgreSQL is installed and running, then create a database:

```sql
CREATE DATABASE lista_dorinte;
```

Update `src/main/resources/application.properties` with your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/lista_dorinte
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build and Run the Application

```bash
./mvnw spring-boot:run
```

The application will be available at:  
`http://localhost:8080`

## Project Structure

- `Lista.java` – Entity class mapped to the `lista` table
- `ListaRepository.java` – JPA repository interface
- `ListaService.java` – Business logic and service layer
- `ListaController.java` – Handles HTTP requests and API mapping
- `lista.html` – Main page for listing items
- `lista_form.html` – Form page for creating/editing items

## REST API

- `GET /api/lista` – Returns all wish list items in JSON format

## Author

- **Name:** Paun Alexandra  
- **Version:** January 10, 2025