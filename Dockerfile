FROM openjdk:11-jdk
COPY ./user_ev/target/user_ev-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "user_ev-0.0.1-SNAPSHOT.jar"]