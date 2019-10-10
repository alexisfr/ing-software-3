FROM openjdk:8u171-jre-alpine
#instalar la utilidad bash
RUN apk add --no-cache bash

#setea el directorio de trabajo 
WORKDIR /opt

#copia el archivo compilado (por maven) adentro de la imagen en /opt
COPY target/ejemplo.jar .

#esto no es importante ( solo de ejemplo )
ENV JAVA_OPTS="-Xms32m -Xmx128m"

#Esto es lo que ejecuta el contenedor cuando inicia
ENTRYPOINT exec java $JAVA_OPTS -jar ejemplo.jar