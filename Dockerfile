# Use a imagem oficial do OpenJDK 21 como base
FROM openjdk:21-jdk-slim

# Adicione um volume apontando para /tmp
VOLUME /tmp

# Permitir que variáveis de ambiente sejam passadas durante o build
ARG DB_URL
ARG JAR_FILE
ENV MONGO_URI=${DB_URL}

# Copie o jar do seu projeto para o contêiner
COPY target/${JAR_FILE} app.jar

# Exponha a porta em que a aplicação irá rodar
EXPOSE 8080

# Defina o comando para executar a aplicação com argumentos JVM
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]