# ==============================================================================
# ETAPA 1: Build (Compilação)
# ==============================================================================
FROM maven:3.9-eclipse-temurin-25-alpine AS builder

WORKDIR /build

# Copia os arquivos de dependência e código-fonte
COPY pom.xml .
COPY src ./src

# Realiza o build sem executar os testes unitários
RUN mvn clean package -DskipTests

# ==============================================================================
# ETAPA 2: Runtime (Execução em Produção)
# ==============================================================================
FROM alpine/java:25-jdk AS runner

WORKDIR /app

# Cria um usuário não-root por questões de segurança
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copia o JAR gerado na etapa de build
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]