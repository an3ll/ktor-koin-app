FROM openjdk:8-jre-alpine

ENV APPLICATION_USER ktor
RUN adduser -D -g '' $APPLICATION_USER

RUN mkdir /app
RUN chown -R $APPLICATION_USER /app

USER $APPLICATION_USER

COPY ./build/libs/ktor-koin-app-0.0.1-all.jar /app/ktor-koin-app-0.0.1-all.jar
WORKDIR /app

EXPOSE 8080
EXPOSE 27017

CMD ["java", "-jar", "ktor-koin-app-0.0.1-all.jar"]
