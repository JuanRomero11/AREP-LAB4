# AREP-LAB4

# TALLER DE ARQUITECTURAS DE SERVIDORES DE APLICACIONES, META PROTOCOLOS DE OBJETOS, PATRÓN IOC, REFLEXIÓN
# Profesor: Luis Daniel Benavides
# AREP - Arquitecturas Empresariales 2021-1

En este proyecto mvn podra encontrar un servidor Web (tipo Apache) en Java. El servidor debe ser capaz de entregar páginas html e imágenes tipo PNG. Igualmente el servidor  provee un framework IoC para la construcción de aplicaciones web a partir de POJOS. Usando el servidor se construyo una aplicación Web de ejemplo y desplegarlo en Heroku. El servidor atiende múltiples solicitudes no concurrentes.

## Prerrequisitos

Como primera medida se debera intalar el JDK y maven y si es necesario un editor como ECLIPSE,NETBEANS,etc. Si solo se quiere ejecutar el proyecto de manera local solo se necesitara el JDK y maven. Para el JDK JAVA se instala la versión 8, a continuacion se adjuntara el link donde muestran las instrucciones detalladas de como descargar este y ademas en esta mismo link se podra realizar la descarga y futura instalacion, de igual forma se adjunta el link de la pagina oficial de maven en el cual esta el instructivo detallado y los paquetes necesarios para la version del sistema operativo en el cual se ejecutara, y por ultimo es recomdable descargar la aplicacion git tambien se anexara el link desde la pagina oficial, se anexan los links debido a que se especifican mas en cada uno con respecto a cada sistema operativo y no uno en especifico.

### Instalacion

Descargar JDK e instrucciones de instalacion
https://www.oracle.com/technetwork/es/java/javase/downloads/index.html
Descargar maven e instrucciones de instalacion
https://maven.apache.org/download.cgi
Descargar Git e instrucciones de instalacion
https://git-scm.com/downloads

## Construccion
Este proyecto basicamente esta construido en maven y el editor que se utilizo fue Visual Studio Code, teniendo el JDK antes mencionado, especificamente se utilizo el lenguaje Java, con el mini framework Spring propio.

## Diseño
Diagramas del diseño

![alt text](https://github.com/JuanRomero11/AREP-LAB4/blob/main/images/dise%C3%B1o1.PNG)

![alt text](https://github.com/JuanRomero11/AREP-LAB4/blob/main/images/dise%C3%B1o2.PNG)



## Descripcion del diseño
Esta se encuentra en el documento latex aqui se encuentra con extension pdf, es el unico archivo con esta extension en este repositorio.

## Como usar el Proyecto
En este mismo repositorio puede clonar o descargar el proyecto a traves de la aplicacion git ya instalada en su computador. Recomendacion, Si se clona utilizar el comando :

        git clone https://github.com/JuanRomero11/AREP-LAB4.git
        
Despues de que el proyecto esta clonado se accede a la consola del computador en este caso accedemos a la terminal de comandos de Windows(cmd) y entramos directamente en la carpeta en donde esta nuestro proyecto y como primer paso compilamos con el comando 

        mvn package

      
## Despliegue
Debido a que no tengo espacio en mi heroku no puedo realizar el despliegue se recomienda probar localmente con el siguiente comando como die en las pruebas.

        java -cp target/classes;target/dependency/* co.edu.eci.escuelaing.app.Spring.MicroSpringBoot co.edu.eci.escuelaing.app.Spring.tests.Controller

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)]()


## Integracion continua

[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/JuanRomero11/AREP-LAB3)

## Ejecución de Pruebas

Para ejecutar las pruebas se pueden utilizar dos comandos:

          mvn package
          
          mvn test

Despues de ello se ejecutan todas las pruebas realizadas en la aplicacion

resultados de las pruebas realizando directamente en la pagina local:

Pruebas de peticion de imagenes

![alt text](https://github.com/JuanRomero11/AREP-LAB4/blob/main/images/Imagenes.PNG)

pruebas de peticion de paths desde el controller con archivos html


![alt text](https://github.com/JuanRomero11/AREP-LAB4/blob/main/images/pathPruebas4.PNG)


Pruebas de peticion de paths desde el controllers

![alt text](https://github.com/JuanRomero11/AREP-LAB4/blob/main/images/pathPruebas.PNG)

![alt text](https://github.com/JuanRomero11/AREP-LAB4/blob/main/images/pathPruebas2.PNG)

![alt text](https://github.com/JuanRomero11/AREP-LAB4/blob/main/images/pathPruebas3.PNG)

pruebas de peticion de paths de arhicvos normales

![alt text](https://github.com/JuanRomero11/AREP-LAB4/blob/main/images/pathPruebas5.PNG)




pruebas de peticion de archivos normales




consulta en la base de datos fue efectiva :
https://immense-brook-58674.herokuapp.com/DescripcionCarros.html

## Autor
Juan Guillermo Romero 
## License
Este codigo tiene una licencia Apache License 2.0 la cual se detalla en https://github.com/JuanRomero11/AREP-LAB3/blob/main/LICENSE
