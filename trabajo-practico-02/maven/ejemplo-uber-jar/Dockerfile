FROM openjdk:8u171-jre-alpine

RUN apk add --no-cache bash

WORKDIR /opt

COPY target/ejemplo-uber-jar.jar .

ENV JAVA_OPTS="-Xms32m -Xmx128m"

ENTRYPOINT exec java $JAVA_OPTS -jar ejemplo-uber-jar.jar