FROM node:8.11-alpine

RUN mkdir /appnode

#copia el codigo adentro de la imagen
ADD . /appnode

WORKDIR /appnode

#compila la aplicacion (adentro de un contenedor temporal)
RUN npm install

EXPOSE 3000

#ejecutamos la aplicacion, pero cuando el container se corre
CMD ["npm", "start"]
#ENTRYPOINT [ "npm", "start" ]


# docker build -t test-node .
# docker run -p 3000:3000 test-node

