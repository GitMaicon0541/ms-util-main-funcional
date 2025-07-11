# Etapa de build com Gradle + Java 17 (imagem mais leve e segura)
FROM gradle:7.6.1-jdk17-alpine as builder

WORKDIR /app
COPY . .

# Garante que o wrapper tem permissão de execução
RUN chmod +x ./gradlew

# Usa o wrapper gradlew para compilar
RUN ./gradlew build --no-daemon

# Etapa de execução com JRE otimizado (Alpine)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
