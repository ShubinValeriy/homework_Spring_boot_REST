FROM openjdk:20-jdk

EXPOSE 8080

COPY target/AuthorizationService-0.0.1-SNAPSHOT.jar my_auth_app.jar

CMD ["java", "-jar", "my_auth_app.jar"]