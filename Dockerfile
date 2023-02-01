FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=target/challenge-api-1.0-SNAPSHOT.jar

WORKDIR /opt/app

EXPOSE 8080

COPY ${JAR_FILE} challenge-api.jar

ENTRYPOINT ["java","-jar","challenge-api.jar"]