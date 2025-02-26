# My Javalin Blog API

## Overview

This project is a RESTful API for a social media blog, built using Javalin, Java, and Maven. It provides endpoints for managing users, posts, and comments. The API follows RESTful principles and incorporates security best practices, including password hashing and input validation.

## Features

*   **User Management:**
    *   Create user accounts.
    *   Retrieve user information.
    *   Update user profiles.
    *   Delete user accounts.
*   **Post Management:**
    *   Create new blog posts.
    *   Retrieve blog posts (individual and lists).
    *   Update blog posts.
    *   Delete blog posts.
*   **Comment Management:**
    *   Add comments to blog posts.
    *   Retrieve comments for a specific post.
    *   Update comments.
    *   Delete comments.
*   **Authentication and Authorization:**
    *   User authentication using JWT (JSON Web Tokens).
    *   Role-Based Access Control (RBAC) to manage user permissions.
*   **Input Validation:**
    *   Server-side validation of all input data to prevent malicious or malformed data.
    *   Use of Jakarta Bean Validation annotations for defining validation rules.
*   **Error Handling:**
    *   Global exception handling to prevent crashes and provide user-friendly error messages.
    *   Use of HTTP status codes to indicate the outcome of requests.
*   **Secure Password Handling:**
    *   Storage of only hashed passwords using bcrypt for enhanced security.

## Technologies Used

*   **Java:** The primary programming language.
*   **Javalin:** A lightweight web framework for Java and Kotlin.
*   **Maven:** A build automation tool for managing project dependencies and building the application.
*   **JUnit:** A unit testing framework for Java.
*   **Mockito:** A mocking framework for creating mock objects in tests.
*   **Jackson:** A library for serializing and deserializing JSON data.
*   **Hibernate Validator:** An implementation of the Jakarta Bean Validation API.
*   **Jakarta EL:** Jakarta Expression Language for evaluating validation message expression.
*   **jBCrypt:** A password hashing library.
*   **SLF4J:** Simple Logging Facade for Java
*   **H2 Database:** An in-memory database for testing

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) version 17 or higher.
*   Maven installed.
*   Git (for cloning the repository).

### Installation

1.  **Clone the repository:**

    ```bash
    git clone <repository-url>
    cd <project-directory>
    ```

    Replace `<repository-url>` with the actual URL of your Git repository (e.g., from GitHub). Replace `<project-directory>` with project name

2.  **Build the project with Maven:**

    ```bash
    mvn clean install
    ```

    This will download all the necessary dependencies and compile the project.

### Configuration

1.  **Database Configuration (if applicable):** If you're using a database (other than the in-memory H2 database for testing), configure the database connection settings in the `src/main/resources/application.properties` or `application.yml` file.

2.  **JWT Secret Key (if applicable):** If you're using JWT authentication, generate a strong, randomly generated secret key and configure it in your application.

### Running the Application

1.  **Run from Maven:**

    ```bash
    mvn compile exec:java -Dexec.mainClass="com.example.blog.BlogApplication"
    ```
   Change the class name if needed
    Alternatively, you can also run the project by running:

     ```bash
    mvn spring-boot:run
    ```

2.  **Access the API:**

    The API will be accessible at `http://localhost:7000` (or the port you configured).

## API Endpoints

_(This section should be populated with a list of your API endpoints, their HTTP methods, and a brief description of each.)_

Example:

| Endpoint          | Method | Description                                              |
| ----------------- | ------ | -------------------------------------------------------- |
| `/users`          | POST   | Creates a new user account.                                |
| `/users/{id}`       | GET    | Retrieves the information for a specific user.           |
| `/posts`          | GET    | Retrieves a list of all blog posts.                        |
| `/posts/{id}`       | GET    | Retrieves a specific blog post by its ID.                  |
| `/posts`          | POST   | Creates a new blog post.                               |
| `/login`          | POST   | Authenticates a user and returns a JWT.                 |

**Important:** Add all your end points here and what it returns

## Testing

To run the unit tests, use the following Maven command:

```bash
mvn test
