# Epik for Nuvve test app

Case study for nuvve

## Prerequisites

* Java 11+
* Maven 3+
* Git
* PostgreSQL 12+

## Installing

First we need to clone the project

````git clone https://github.com/datruq/epik.git````

When it finished clonning and have it in your local machine, just open it with IntelliJ IDE and import all the dependencies with Maven

## Create Database and tables

1. Create a new data base on your postgres. I call it mine "epik"
2. Excecute the user.sql and ev.sql queries. Those are inside the folder "sql"
  
## Building and running this application

1. Open a command line window or terminal.
2. Navigate to the root directory of the project, where the pom.xml resides.
3. Compile the project: ```mvn clean build ```.
4. Change into the target directory: cd build/libs
5. You should see the file name: epik-app-1.0.jar.
6. Execute the JAR: ``` java -jar epik-app-1.0.jar```.
7. The application should be available at http://localhost:8080/.

## REST API overview

With this Epik app we can get:
* User CRUD
* EV CRUD
* Basic stats from Users and EVs

**Get all users.**

````curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/user/````

**Get user by id.**

````curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/user/{userId}````

**Get all Evs.**

````curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/ev/````

**Get Ev by id.**

````curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/ev/{evId}````


### Targeting the REST API with Postman
Alternatively to curl, you can use Postman to target the REST API.


**Postman find all users**

![alt text](https://github.com/datruq/epik/blob/master/img/findAllUsers.png)

**Postman find all Evs**

![alt text](https://github.com/datruq/epik/blob/master/img/findAllEvs.png)


## Built With

* [Spring](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Junit](http://junit.org/junit4/) Java unit testing framework
* [Mockito](https://site.mockito.org/) Java Mocking framework
* [PostgreSQL](https://site.mockito.org/) Data Base management system


## Author

* **David Trujillo** - *Initial work* - [datruq](https://github.com/datruq)

