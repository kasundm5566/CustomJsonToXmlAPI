# Converter
Spring Boot API to generate custom XMLs based on a JSON payload.
---

#### Available functionality
* Generate JMF XML
* Generate JDF XML

#### Pre-requisites
* Java Development Kit (JDK) 1.8
* Apache Maven 3.8

#### Environment used for developments
* OS: Windows 10
* IDE: Apache NetBeans IDE 12.3
* Back end technologies: Java with Spring Boot, JAXB

#### Config & Build
1. Goto the location of the project directory.

2. Run following command.

`mvn clean install`

#### Execute the program
1. Goto the project built directory.

`<project-directory>/target`

2. Execute the jar file as follows.

`java -jar library<project-version>.jar`

e.g: `java -jar converter-0.0.1-SNAPSHOT.jar`

i.e: Please refer the following link to find more ways to build and execute Spring Boot application.
https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html

#### Access the program
By default, program will start in port 5000. You may access index page of the web app as follows.

`<host>:<port>`

e.g: `localhost:5000`

Please refer to the following link to find the API documentation.
https://app.swaggerhub.com/apis-docs/kasundm5566/Converter/1.0.0