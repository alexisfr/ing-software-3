## Trabajo Práctico 11 - Métricas de código
### 1- Objetivos de Aprendizaje
 - Adquirir conocimientos acerca del uso de herramientas para análisis estático de código.
 - Configurar este tipo de herramientas.
 - Prevención y corrección de errores.

### 2- Unidad temática que incluye este trabajo práctico
Este trabajo práctico corresponde a la unidad Nº: 6 (Libro Ingeniería de Software: Cap 24)

### 3- Consignas a desarrollar en el trabajo práctico:
 - Los ejercicios se realizarán en clase con asistencia del Jefe de trabajos prácticos.
 - Para una mejor evaluación del trabajo práctico, incluir capturas de pantalla de los pasos donde considere necesario.
 - En este caso existen varias herramientas con funcionalidades similares en la nube:
   - [SonarClould](https://sonarcloud.io)   
   - [Codacy](https://www.codacy.com/)

### 4- Desarrollo:

#### 1- Configurando SonarCloud
  - Crear una cuenta en SonarCloud, se puede utilizar el usuario de GitHub.
  - Hacer un fork del repositorio https://github.com/alexisfr/java-projects
  - Clonar el repositorio al que se le hizo el fork.
  - En SonarCloud crear un nuevo proyecto (haciendo click en el botón +)
  - Elegir la opción de analizar nuevo projecto.
  - Completar las opciones para crear una nueva Organización (se puede usar su cuenta de github).
  - Seleccionar el repositorio java-projects de su usuario y presionar **Set up**

#### 2- Correr Análisis de código
  - Una vez creado el proyecto, se debe elegir la opción de análisis manual
  - Seleccionar Maven.
  - Correr el comando generado en la raíz del repositorio clonado locamente, hay que agregar la opción **-Dmaven.test.failure.ignore=true** al final del comando, algo similar a esto:
```bash
mvn sonar:sonar \
  -Dsonar.projectKey=alexisfr_java-projects \
  -Dsonar.organization=alexisfr-github \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.login=XXX \
  -Dmaven.test.failure.ignore=true
```
  - Esta ejecución puede tomar varios minutos.
  - Guardar este comando, que luego será utilizado.

#### 3- Analizar los resultados de Fiabilidad
  - Encontrar los 3 Bugs en la clase **basics/swing/FileIO** referidos a Fiabilidad (Reliability).
  - Explicar porque se consideran errores y posible solución a los mismos.

#### 4- Analizar las Vulnerabilidades de Seguridad
  - Encontrar los 4 Errores de seguridad en la clase **basics/jdbc/mysql/MySQLAccess.java**
  - Explicar porque se considera código vulnerable y posible solución a los mismos.

#### 5- Analizar costo de Mantenimiento
  - Describir alguno de los "Code Smells" en la clase basics/swing/demo/calculator/Calculator.java
  - ¿Cuánto tiempo estimado es necesario para llevar esta clase de calificación **B** a calificación **A** de acuerdo a esta herramienta?

#### 6- Analizar Complejidad
  - Encontrar la función que posee la mayor complejidad ciclomática en la clase basics/xml/EvalXML.java
  - ¿Qué significa complejidad ciclomática y complejidad cognitiva?
  - ¿Cuánto son los valores para esta clase?

#### 7- Corregir Errores
  - Encontrar el código duplicado en en la clase scheduler/TaskScheduler.java
  - Refactorizar el código para eliminar este código duplicado.
  - Hacer commit y push del código corregido.
  - Volver a correr el análisis de código con el comando ejecutado en el ejercicio 2.
  - Comprobar que la en esta clase no se reporta más dicho problema.

#### 8- Analizar código de la applicación Payroll
  - Utilizando los pasos de punto 2 correr el análisis para el proyecto **./proyectos/spring-boot**
  - Analizar resultados

#### 9- Incluir el analisis en el Pipeline
  - Agregar el paso de análisis automático de código en Jenkins u otra herramienta de CI/CD para el proyecto  **./proyectos/spring-boot**
