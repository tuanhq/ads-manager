FROM openjdk:8-jdk-alpine

ARG SPRING_PROFILE=dev
ENV PROFILE_ENV=$SPRING_PROFILE

WORKDIR app

COPY target/ads-managers.jar .
COPY src/main/resources config

ENTRYPOINT ["java", "-jar", "ads-managers.jar"]
