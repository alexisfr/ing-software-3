## Trabajo Práctico 7 - Herramientas de construcción en la nube
### 1- Objetivos de Aprendizaje
 - Adquirir conocimientos acerca de las herramientas de integración continua en la nube.
 - Configurar este tipo de herramientas.
 - Implementar procesos simples de construcción automatizada.

### 2- Unidad temática que incluye este trabajo práctico
Este trabajo práctico corresponde a la unidad Nº: 3 (Libro Continuous Delivery: Cap 3)

### 3- Consignas a desarrollar en el trabajo práctico:
 - Para una mejor evaluación del trabajo práctico, incluir capturas de pantalla de los pasos donde considere necesario.
 - En este caso existen varias herramientas con funcionalidades similares en la nube:
   - [AppVeyor](https://www.appveyor.com/)   
   - [CircleCI](https://circleci.com/)
   - [Travis CI](https://travis-ci.com/)
   - [Codefresh](https://codefresh.io/)
   - [Gitlab](https://about.gitlab.com/) - Trial de 30 días

## 4- Desarrollo:

#### 1- Pros y Contras
  - Listar los pros y contras de este tipo de herramientas
  - Sacar conclusiones

#### 2- Configurando AppVeyor
  - Crear una cuenta en AppVeyor, se puede utilizar el usuario de GitHub
  - Configurar un proyecto utilizando un repositorio que contenga el código del proyecto Maven **spring-boot**.
  - Ir a la opción **SETTINGS**
  - Dejar el entorno por defecto (Visual Studio 2015)
  - En la opción **Build** configurar un script de línea de comando (CMD), para que genere los artefactos. Es posible que tenga que cambiar de directorio para generación:
```
cd <lugar donde está el pom.xml>
mvn clean package
```
  - En la opción **Artifacts** especificar la ruta relativa para capturar los jar files de salida.
  - En la opción **Tests** agregar el siguiente código Powershell
  ```powershell
      $url = "https://ci.appveyor.com/api/testresults/junit/$($env:APPVEYOR_JOB_ID)"
      $wc = New-Object 'System.Net.WebClient'
      $dirs = Get-ChildItem -Filter surefire-reports -Recurse
      ForEach ($dir in $dirs)
      {
        $files = Get-ChildItem -Path $dir.FullName -Filter TEST-*.xml
        ForEach ($file in $files)
        {
          $wc.UploadFile($url, (Resolve-Path $file.FullName))
        }
      }
  ```
  - Verificar que el Job se ejecuta con nuevos commits en el repositorio configurado.
  - Opcional: Agregar Badges al repositorio para mostrar estado actual del build en GitHub.
  - Como resultado de este ejercicio, exportar el yaml generado y subirlo en **spring-boot/appveyor.yml**. Y mostrar capturas de pantalla con los artefactos y/o la historia de los builds ejecutados.

#### 3- Opcional: Configurando CircleCI
  - De manera similar al ejercicio 2, configurar un build job para el mismo proyecto, pero utilizando CircleCI
  - Para capturar artefactos, utilizar esta referencia: https://circleci.com/docs/2.0/artifacts/
  - Como resultado de este ejercicio, subir el config.yml a la carpeta **spring-boot**

#### 4- Opcional: Configurando TravisCI
  - Configurar el mismo proyecto, pero para TravisCI. No es necesario publicar los artefactos porque TravisCI no dispone de esta funcionalidad.
  - Como resultado de este ejercicio subir el archivo .travis.yml a la carpeta **spring-boot**

#### 5- Opcional: Configurando Codefresh
  - Configurar el mismo proyecto, pero para Codefresh. 
  - Como resultado de este ejercicio subir el archivo codefresh.yml a la carpeta **spring-boot**

#### 6- Opcional: Configurando Gitlab
  - Configurar el mismo proyecto, pero para Gitlab. 
  - Como resultado de este ejercicio subir el archivo .gitlab-ci.yml a la carpeta **spring-boot**

#### 7- Conclusiones.
  - Hacer una breve descripción comparativa entre AppVeyor, CircleCI y TravisCI