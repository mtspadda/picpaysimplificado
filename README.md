# PicPay Backend Challenge Project

## Description
This project is developed as part of the [PicPay backend challenge](https://github.com/PicPay/picpay-desafio-backend).
The main objective is to create an application using Java 17, Spring Boot 3.15, and the H2 in-memory database. 
The project aims to explore tool versions that might not be commonly used in everyday work, apply SOLID principles, and implement user authentication.

## Requirements
Make sure to have the following tools installed on your machine before running the project:

- Java 17
- Spring Boot 3.15
- H2 in-memory database

## Environment Setup
1. Install Java 17 on your machine. You can download it from [java.com](https://www.java.com/).
2. Install Spring Boot 3.15 by following the instructions on [spring.io](https://spring.io/projects/spring-boot).
3. Download and configure the H2 in-memory database from [h2database.com](https://www.h2database.com/html/main.html).

## Project Configuration
1. Clone this repository to your local machine.
   ```bash
   git clone https://github.com/PicPay/picpay-desafio-backend.git
   ```

2. Open the project in your preferred IDE (e.g., IntelliJ, Eclipse).

3. Configure the H2 database properties in the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   ```

4. Run the project.

---
