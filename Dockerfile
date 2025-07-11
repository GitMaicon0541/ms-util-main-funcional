# Etapa 1: Build com Gradle e Java 17
FROM eclipse-temurin:17-jdk-alpine AS builder
RUN apk add --no-cache curl tar bash
RUN curl -sSLo gradle.zip https://services.gradle.org/distributions/gradle-7.6.1-bin.zip \
	&& unzip gradle.zip -d /opt \
	&& ln -s /opt/gradle-7.6.1/bin/gradle /usr/bin/gradle

WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew clean build --no-daemon

# Etapa 2: Executar com imagem distroless (sem shell, segura e enxuta)
FROM gcr.io/distroless/java17-debian11

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

# Porta (se necessário)
EXPOSE 8080

# Executar diretamente o jar
CMD ["app.jar"]
