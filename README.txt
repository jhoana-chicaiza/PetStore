Automatización de Pruebas en Petstore
Descripción
Este proyecto implementa pruebas funcionales automatizadas para los endpoints de la API de Petstore. Se utiliza
Serenity BDD con el patrón Screenplay en Java y Gradle como gestor de dependencias.

Requerimientos
La automatización cubre los siguientes endpoints de la API de Petstore:
GET /v2/user/{username}: Obtener información de un usuario por su nombre de usuario.
POST /v2/user: Crear un nuevo usuario.
GET /v2/user/{username}: Obtener información de un usuario actualizado por su nombre de usuario.
PUT /v2/user/{username}: Actualizar la información de un usuario existente.
DELETE /v2/user/{username}: Eliminar un usuario por su nombre de usuario.

Tecnologías y Herramientas Utilizadas
Lenguaje: Java
Framework de automatización: Serenity BDD con Screenplay
Gestor de dependencias: Gradle
Patrón de diseño: Screenplay
Ejecutor de pruebas: Cucumber
Manejo de logs: SLF4J y Logback

Instalación y Configuración
Prerrequisitos
Asegúrate de tener instalado:
Java jdk 17
Gradle 7.0 o superior
Git 2.0 o superior

Estructura del Proyecto

petstore-test/
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- com.sofka.petstoretest
|   |   |   |   |-- models
|   |   |   |   |-- questions
|   |   |   |   |-- tasks
|   |   |   |   |-- utils
|   |   |   |   |   |-- Constants.java
|-- src
|   |-- test
|   |   |-- java
|   |   |   |-- com.sofka.petstoretest
|   |   |   |   |-- runners
|   |   |   |   |-- stepdefinitions

|-- resources
|   |-- features
|   |   |-- createuser.feature
|   |   |-- getuser.feature
|   |   |-- updateuser.feature
|   |   |-- deleteuser.feature
|   |-- logback.xml
|   |-- serenity.conf
|-- build.gradle
|-- gradle.properties
|-- gradle/wrapper/gradle-wrapper.jar
|-- gradle/wrapper/gradle-wrapper.properties

Clonar el Repositorio

git clone https://github.com/jhoana-chicaiza/PetStore.git
cd PetStore

Uso
Para ejecutar las pruebas dirigete a test/java/com/sofka/petstoretest/runners para ejecutar las pruebas individuales.
las pruebas individuales.

Reportes
Los reportes de Serenity se generarán en target/site/serenity/index.html después de ejecutar gradle aggregate.


Autora
Jhoana Chicaiza
