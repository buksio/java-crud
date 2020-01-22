FROM maven:3.6.3-jdk-8 as build
WORKDIR /workspace/app

COPY pom.xml .
COPY src src

RUN mvn install

FROM openjdk:8
WORKDIR /app

ARG DEPENDENCY=/workspace/app/target
COPY --from=build ${DEPENDENCY}/crud-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT [ "java", "-jar", "/app/crud-0.0.1-SNAPSHOT.jar"]
