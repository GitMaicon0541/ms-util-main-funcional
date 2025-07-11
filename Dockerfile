# Etapa de build
FROM gradle:7.6.1-jdk17-slim as builder
WORKDIR /app

# Copia o projeto e dá permissão ao gradlew
COPY . .
RUN chmod +x ./gradlew

# Executa o build usando o wrapper do Gradle
RUN ./gradlew build --no-daemon

# Etapa de runtime com Java apenas (mais leve)
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copia o jar gerado do builder
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
