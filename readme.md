ghp_eGktiRhMEcXTdGDG
rtG2DVvbRVxAdu0m9LVY

## chapter 01 - eclipse workspace
- java-project
- dynamic-web-project

## chapter 02 - maven workspace

	#mvn archetype:generate -DgroupId=my.example -DartifactId=maven-java-project  
	-DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
	
maven-java-project
- maven
- maven-shade-plugin
- slf4j + log4j
- lombok

	# mvn archetype:generate -DgroupId=my.example -DartifactId=maven-web-project 
	 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

maven-web-project
- slf4j + logback
- maven-resources-plugin

## chapter 03 - soap web service
ws-client-jax-ws
- jax-ws web service client

ws-server-jax-ws
- jax-ws web service server
- maven profiles

## chapter 04 - object transformation
object-to-xml
- JAXBContext, Marshaller
- xmlunit-core  

object-to-json
- jackson
- jsonassert

## chapter 05 - rest web service
ws-server-rest
- jersey

ws-client-rest
- http url connection
- jersey client to xml , json

## chapter 06 - jpa
java-persistence-api

data-access-object
- dao example
- junit with dbunit 

## chapter 07 - jsf
java-server-face
- maven project with Hello JSF

jsf-primefaces
- maven project with Basic HTTP Submit Form
- example of CRUD form

## chapter 08 - cdi
interface-api
- NameServiceable interface and Model

impl-operator
- implement NameServiceable by operator

impl-concat
- implement NameServiceable by concat method

cdi-web
- @Inject NameServiceable chooses impl-operator or impl-concat by maven dependencies

## chapter 09 - jsf-primefaces-cdi
jsf-primefaces-cdi
- full example of CRUD form
- example of the composite component (JSF) , Primefaces Dialog

ws-server-rest-cdi
- example of web service with CDI

## chapter 10 - jakarta-EE-10
jsf-primefaces-jee10
- example of jsf-primefaces on Jakarta EE10

ws-server-rest-jee10
- example of web service on Jakarta EE10

