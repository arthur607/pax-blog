# Use a imagem oficial do OpenJDK 21 como base
FROM openjdk:21-jdk-slim

# Adicione um volume apontando para /tmp
VOLUME /tmp

# O argumento JAR_FILE será passado no momento de build
ARG JAR_FILE=target/*.jar

# Copie o jar do seu projeto para o contêiner
COPY ${JAR_FILE} blog-backend-0.0.1-SNAPSHOT.jar

# Exponha a porta em que a aplicação irá rodar
EXPOSE 8080

ENV MONGO_URI=${DB_URL}

# Defina o comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/blog-backend-0.0.1-SNAPSHOT.jar"]
