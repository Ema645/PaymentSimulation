# Build Stage
FROM gradle:jdk21 as builder
WORKDIR /app
COPY . .
RUN ./gradlew build -x test --no-daemon

# Run Stage
FROM openjdk:21-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]