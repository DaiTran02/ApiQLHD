FROM openjdk:20-jdk

COPY target/api-0.0.1-SNAPSHOT.jar api-0.0.1-SNAPSHOT.jar

COPY src/main/resources/application.properties .

ENTRYPOINT ["java","-jar","/api-0.0.1-SNAPSHOT.jar"]

