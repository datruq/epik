# Epik for Nuvve test app

Case study for nuvve

## Prerequisites

* Java 11+
* Maven 3+
* Git
* PostgreSQL 12+

## Installing

First we need to clone the project

````git clone git@github.com:datruq/epik.git````

When it finished clonning and have it in your local machine, just open it with your preferred IDE and import all the dependencies with Maven

## Create Database and tables

1. Create a new data base on your local postgreSQL. In this case I named it "epik"
2. Excecute the user.sql and ev.sql queries to create both tables. Those are inside the "sql" folder
  
## Building and running this application

1. Open a command line window or terminal.
2. Navigate to the root directory of the project, where the pom.xml resides.
3. Compile the project: ```mvn clean install -pl user_ev ```.
4. Change into the target directory: user_ev/target/  Or you can use the one already generated inside the "jars" folder
5. You should see the file name: user_ev-0.0.1-SNAPSHOT.jar.
6. Execute the JAR: ``` java -user_ev-0.0.1-SNAPSHOT.jar```.
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


**Postman users**

[GET] http://localhost:8080/users/

![alt text](https://github.com/datruq/epik/blob/master/img/findAllUsers.png)

[POST] http://localhost:8080/users/

![alt text](https://github.com/datruq/epik/blob/master/img/createUser.jpg)

[PUT] http://localhost:8080/users/

![alt text](https://github.com/datruq/epik/blob/master/img/updateUser.jpg)

[DELETE] http://localhost:8080/users/{userId}

![alt text](https://github.com/datruq/epik/blob/master/img/deleteUser.jpg)


**Postman Evs**

[GET] http://localhost:8080/ev/

![alt text](https://github.com/datruq/epik/blob/master/img/findAllEvs.png)


**Postman find out which are the best-selling models!**

[GET] http://localhost:8080/ev/findMostPopularEv/

![alt text](https://github.com/datruq/epik/blob/master/img/getMostPopularModels.png)


## Built With

* [Spring](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Junit](http://junit.org/junit4/) Java unit testing framework
* [Mockito](https://site.mockito.org/) Java Mocking framework
* [PostgreSQL](https://site.mockito.org/) Data Base management system


## Author

* **David Trujillo** - *Initial work* - [datruq](https://github.com/datruq)

