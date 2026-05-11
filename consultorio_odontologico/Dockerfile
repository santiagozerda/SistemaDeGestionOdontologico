FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/consultorio_odontologico-0.0.1.jar
COPY ${JAR_FILE} app_consultorio.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_consultorio.jar"]