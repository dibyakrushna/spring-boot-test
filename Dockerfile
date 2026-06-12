# Build stage
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jdk-jammy

ARG PROFILE=dev

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENV ACTIVE_PROFILE=${PROFILE}

ENTRYPOINT ["java","-Dspring.profiles.active=${ACTIVE_PROFILE}","-jar","app.jar"]