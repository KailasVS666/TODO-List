# 📝 TODO-List Application

A simple, robust web application built using the Spring Boot framework to manage daily tasks. This project demonstrates core principles of the Model-View-Controller (MVC) architecture, Persistence (JPA), and Thymeleaf templating.

---

## ✨ Features

The application provides full **CRUD (Create, Read, Update, Delete)** functionality for managing tasks:

* **Create:** Add new tasks with input validation (task description cannot be empty).
* **Read:** Display all tasks in a sequentially numbered list (1, 2, 3...) for clean UI, regardless of internal database IDs.
* **Update:** Toggle a task's status between **Pending** and **Completed** (Mark Complete).
* **Delete:** Permanently remove a task from the list and database.
* **Timestamping:** Automatically records the date and time a task was created using the `@PrePersist` JPA annotation.
* **UI Polish:** Completed tasks are visually highlighted with a light green row background and strikethrough text.

---

## 🚀 Technology Stack

| Category | Component | Version | Role |
| :--- | :--- | :--- | :--- |
| **Backend Language** | **Java** | 17+ | Core language for business logic. |
| **Framework** | **Spring Boot** | 3.5.6 | Simplifies application setup and configuration. |
| **Web** | **Spring Web MVC** | Included | Handles HTTP requests and routing. |
| **View Layer** | **Thymeleaf** | Included | Server-side template engine for dynamic HTML rendering. |
| **Persistence (ORM)** | **Spring Data JPA** | Included | Maps Java entities to database tables (ORM). |
| **Database** | **MySQL** | Connector-J | Relational database for storing data. |
| **Build Tool** | **Maven** | Included | Dependency management and build automation. |

---

## ⚙️ Setup and Configuration

### Prerequisites

* Java Development Kit (JDK) 17 or higher
* MySQL Server (Version 8.0+ recommended)
* Eclipse IDE (or any IDE with Spring Boot support)

### Database Configuration

The application is configured to connect to a local MySQL instance.

1.  **Stop** the application if it is running.
2.  Ensure your MySQL service is running on the standard port (`3306`).
3.  The database configuration is managed in `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
# ... other properties
spring.jpa.hibernate.ddl-auto=create-drop
