# Theatre
This is a simple web-application which helps you to buy tickets to the theatre.

## Structure

#### This project has a multi-layer architecture and consists of:
* Database layer
* DAO layer
* Service layer
* Controller layer

Communication between back-end and front-end is performed via DTO and JSON.
## Available functionality

### User
* Register in the system
* Log in to the system
* Browse available topics
* Browse available intensive courses
* Add multiple tickets to the shopping cart
* Place an order

### Admin

* View the information about registered users
* Add new theatre stages
* Add new performances
* Add new performance sessions
* Delete theatre stages, performances, performance sessions
* Update theatre stages, performances, performance sessions

## Technologies

* Java 8
* Maven
* Hibernate
* MySQL
* Spring MVC
* Spring Security
* Apache Tomcat

## Requirements for launching the application

1. Download and install JDK 8 or later
2. Download and install Apache Tomcat web server
3. Download and install MySQL.
4. Configure the database connection properties in the **db.properties** file
* user: "your username"
* password: "your password"
* db.url=jdbc:mysql://localhost/*<your_database>*?currentSchema=*<your_schema>*
5. Run a project using the IDE
