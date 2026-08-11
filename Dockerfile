# ==============================================================================
# ETAPA 1: Build (Compilação)
# ==============================================================================
FROM maven:3.9-eclipse-temurin-22-alpine AS builder

WORKDIR /build

# Copia apenas os arquivos de dependência primeiro para aproveitar o cache do Docker
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte do projeto e realiza o build sem executar os testes unitários
COPY src ./src
RUN mvn package -DskipTests

# ==============================================================================
# ETAPA 2: Runtime (Execução em Produção)
# ==============================================================================
FROM alpine/java:22-jdk AS runner

WORKDIR /app

# Cria um usuário não-root por questões de segurança
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copia o JAR gerado na etapa de build
COPY --from=builder /build/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Executa o JAR diretamente com o perfil padrão do projeto
ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]