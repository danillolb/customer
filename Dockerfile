FROM openjdk:17-jdk-slim

WORKDIR /customer

COPY /build/libs/customer-0.0.1-SNAPSHOT.jar customer.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "customer.jar"]
