FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/del-backend-ordermanagementservice-0.0.1-SNAPSHOT.jar /app/
RUN apt-get update && apt-get install -y curl \
    && curl -L https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.28/mysql-connector-java-8.0.28.jar \
    -o /app/mysql-connector-java-8.0.28.jar

CMD ["java", "-jar", "/app/del-backend-ordermanagementservice-0.0.1-SNAPSHOT.jar"]