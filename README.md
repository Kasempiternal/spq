**Base de datos**

Crear una base de datos llamada *jersey* y dar permisos al usuario por defecto

	DROP SCHEMA IF EXISTS ParkingDB;
	DROP USER IF EXISTS 'spq'@'localhost';
	CREATE SCHEMA ParkingDB;
	CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
	GRANT ALL ON productosDB.* TO 'spq'@'localhost';

La configuración por defecto para la base de datos y los usuarios puede ser actualizada en el fichero *resources/datanucleus.properties*.

**Construcción del proyecto**

Para limpiar el directorio _target_ y compilar el proyecto.

	mvn clean compile

**Creación de las tablas**

Para la creación de las tablas se debe ejecutar el comando de maven

	mvn compile datanucleus:schema-create

**Test Unitarios**

Para la ejecucuión de los tests unitarios

    mvn test

**Test GUI**

Para la ejecucuión de los tests de las ventanas

    mvn verify -P gui

**Test Integración**

Para la ejecucuión de los tests de integración

    mvn verify -P integration

**Code coverage (JaCoCo)**

Generación de reporte de la cobertura de los test en HTML

    mvn jacoco:report

**Documentación (DOxygen)**

Generación de reporte de la documentación en HTML y TeX

    mvn doxygen:report

**Inicio del servidor**

El servidor REST de la aplicación se lanza utilizando el comando

    mvn exec:java

Para iniciar la aplicación

    mvn exec:java -P ventana
