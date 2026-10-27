# Ejecuta la suite en un contenedor. El navegador no vive aquí: corre en el servicio
# `chrome` de docker-compose.yml y esta imagen solo le envía comandos por HTTP.
FROM amazoncorretto:17

WORKDIR /app

# El wrapper de Gradle 9 invoca xargs; la imagen base de Amazon Linux no lo trae.
RUN dnf install -y findutils && dnf clean all

COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
RUN chmod +x gradlew && ./gradlew --version --no-daemon

COPY src ./src

CMD ["./gradlew", "test", "aggregate", "--no-daemon"]
