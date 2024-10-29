# Use uma imagem oficial do Maven com OpenJDK 17 para o build
FROM maven:3.8.5-openjdk-17 AS build

# Configurações do Quarkus
WORKDIR /app

# Copie o arquivo pom.xml para baixar dependências do Maven
COPY ./pom.xml .
RUN mvn -B dependency:go-offline

# Instale o Quarkus CLI
RUN curl -Ls https://sh.jbang.dev | bash -s - app setup
RUN export PATH=$PATH:~/.jbang/bin

# Copie todo o código-fonte necessário
COPY ./src ./src

# Construa o projeto Quarkus
RUN mvn -B package -DskipTests -Dquarkus.package.type=uber-jar

# Etapa de Execução
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copie o artefato construído da etapa anterior
COPY --from=build /app/target/*-runner.jar ./app.jar

# Porta que o contêiner expõe
EXPOSE 8001

# Comando para executar o aplicativo quando o contêiner for iniciado
CMD ["java", "-jar", "./app.jar"]