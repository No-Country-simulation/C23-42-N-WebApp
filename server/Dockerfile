FROM openjdk:17-slim

WORKDIR /app

COPY target/server-0.0.1-SNAPSHOT.jar /app/server-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/server-0.0.1-SNAPSHOT.jar"]