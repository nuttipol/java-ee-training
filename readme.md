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

## future chapter

- JSF

