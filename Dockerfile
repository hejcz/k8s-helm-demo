FROM openjdk:8-alpine
ARG VERSION
COPY build/libs/demo-${VERSION}.jar /app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]