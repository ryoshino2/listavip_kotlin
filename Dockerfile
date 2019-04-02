FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /build/libs/listavip_kotlin-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker","-jar", "/app.jar"]