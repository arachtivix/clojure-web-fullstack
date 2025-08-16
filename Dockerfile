# Build stage
FROM clojure:openjdk-17-lein-alpine AS builder

WORKDIR /app

COPY project.clj .
RUN lein deps

COPY . .
RUN lein cljsbuild once prod
RUN lein uberjar

# Runtime stage
FROM openjdk:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/web-app-*-standalone.jar app.jar

EXPOSE 3000

CMD ["java", "-jar", "app.jar"]