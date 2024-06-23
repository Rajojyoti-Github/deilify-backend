FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/del-backend-vendorservice.jar /app/

ENTRYPOINT ["java", "-jar", "/app/del-backend-vendorservice.jar"]
