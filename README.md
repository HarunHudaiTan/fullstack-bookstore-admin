# Bookstore Application

A full-stack web application for managing a bookstore, featuring user authentication, book catalog management, and administration features.

## Project Structure

The project consists of two main components:

- **api-bs**: Backend REST API built with Spring Boot
- **frontend-bs**: Frontend application built with Angular

## Backend (api-bs)

### Technologies Used

- Java 17
- Spring Boot 3.3.4
- Spring Security with JWT Authentication
- Spring Data JPA
- H2 In-Memory Database (for development)
- Maven

### Key Features

- RESTful API endpoints for books, authors, genres, publishers, and users
- JWT-based authentication and authorization
- Role-based access control (USER, ADMIN, MOD)
- Data models for Book, Author, Genre, Publisher, User, and more
- Exception handling and validation

### Setup and Installation

1. Ensure you have JDK 17 and Maven installed
2. Navigate to the `api-bs` directory
3. Run the application using Maven:

```bash
./mvnw spring:run
```

Alternatively, you can build and run the application:

```bash
./mvnw clean package
java -jar target/bookstore-0.0.1-SNAPSHOT.jar
```

### API Endpoints

- Authentication: `v1/auth/*`
  - `/login`: Authenticate user and get JWT tokens
  - `/addNewUser`: Register a new user
  - `/refresh`: Refresh JWT token
  - `/logout`: Invalidate JWT token

- Books: `v1/book/*`
  - GET `/`: Get all books
  - GET `/{id}`: Get book by ID
  - POST `/`: Add a new book
  - PUT `/update/{id}`: Update a book
  - DELETE `/{id}`: Delete a book

- Authors: `v1/author/*`
- Genres: `v1/genre/*`
- Publishers: `v1/publisher/*`
- Users: `v1/user/*`

## Frontend (frontend-bs)

### Technologies Used

- Angular
- Bootstrap
- Angular Material
- NGX Toastr for notifications
- JWT Authentication

### Key Features

- JWT-based authentication
- Responsive UI using Bootstrap
- Book catalog with search and filtering
- Book management (add, edit, delete)
- User management
- Dashboard with statistics

### Setup and Installation

1. Ensure you have Node.js and npm installed
2. Navigate to the `frontend-bs` directory
3. Install dependencies:

```bash
npm install
```

4. Start the development server:

```bash
ng serve
```

5. The application will be available at `http://localhost:4200`

### Main Components

- **Authentication**: Login and signup components
- **Book Management**: Component for listing, adding, editing books
- **User Management**: Component for managing users
- **Dashboard**: Display statistics and information

## Docker Support

The application includes Docker support for easy deployment:

1. Build the Docker image:

```bash
docker build -t bookstore-app .
```

2. Run the container:

```bash
docker run -p 8080:8080 bookstore-app
```

Alternatively, use Docker Compose:

```bash
docker-compose up
```

## Database Configuration

The application uses H2 in-memory database by default. To configure a different database:

1. Update `src/main/resources/application.properties` with your database configuration
2. Add the appropriate database driver dependency in `pom.xml`

## Security

The application uses JWT for authentication with the following features:

- Token-based authentication
- Refresh tokens
- Token blacklisting for logout
- Role-based access control

## Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature-name`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature-name`
5. Submit a pull request

