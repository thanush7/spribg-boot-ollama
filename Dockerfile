FROM openjdk:17-jdk-slim
WORKDIR /aidemo
COPY target/aidemo.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
