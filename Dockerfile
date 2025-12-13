FROM gradle:jdk17-corretto AS builder
WORKDIR /app


COPY . .

RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon

FROM amazoncorretto:17
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]