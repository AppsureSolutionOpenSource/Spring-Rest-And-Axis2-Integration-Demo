# Spring-Rest-And-Axis2-Integration-Demo
This is a demo project, containig both rest and soap web services. 

## Prerequisites

IDE: IntelliJ IDEA Community 2020 (maven support required).
JDK: Oracle JDK 13 (might work with Open JDK, not tested yet).
OS : Windows 10 (might work with Linux distros too, not tested yet).
TESTING : SoapUI 5.5.0
DATABASE : H2 (in-memory, no configuration required)

## Technologies
* Spring Boot (latest, 15.04.2019)
* Axis 2 (latest, 15.04.2019)
* JPA (latest, 15.04.2019)
* Hibernate (latest, 15.04.2019)

## Rest services

* http://localhost:8080/api/rest/getRandom -> HTTP GET -> Obtain a random number between 0 and 1000.
* http://localhost:8080/api/rest/createError -> HTTP POST -> Create an error Event into a database.
* http://localhost:8080/api/rest/createWarn -> HTTP POST -> Create a warning Event into a database.
* http://localhost:8080/api/rest/createInfo -> HTTP POST -> Create an info Event into a database.
* http://localhost:8080/api/rest/getEvents -> HTTP GET -> Get a configurable number of events from the database.

## Soap services
WSDL files were generated from classes using maven plugin Wsdl2Java.
* http://localhost:8080/axis2/services/EventLoggingServiceSoapController?wsdl -> Description of the Event creation/listing methods.
* http://localhost:8080/axis2/services/RandomNumbersSoapController?wsdl -> Description for the random number generator.


## Rest services client
A simple rest client implementation can be found in class JUnitTests.

## Soap services client
Some service calls can be found in class JUnitTests. Client stubs were generated automatically from wsdl using SoapUI.

## Unit testing
Unit testing was implemented using JUNIT. I order to pass tests, the web app must be started.

## Exteral testing
All the methods exposed through SOAP and REST were tested externally using SoapUI. The soap ui project file is SoapUI.xml.


