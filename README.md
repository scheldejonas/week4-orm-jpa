#ORM (Object Relational Mapping) with JPA (Java Persistence API)
##Step by step:
Purpose: Simple walk through of JPA Steps: 
1. Create the project.
2. Create a database and connect (for this demo I use mysql database: jpa1)
3. Add the MYSQL JDBC Driver to the project libraries 
4. Create a new Persistance Unit (right click project and choose new...) 
  - choose EclipseLink JPA 2.1 (Should be the default choice for the Persistence Provider) 
5. Create new file -> Entity Class. 
  - Name it Person. and give it fields (ID, age, name)
  - Run this class to create a db table from the entities:
```java
public class Creater {
    public static void main(String[] args) {
        Persistence.generateSchema("JPADemo1PU", null); //Change PU name
    }
}
```
  - Then create a class with an EntityManager based on the Persistence Unit See how running the persist() method creates a new table in the database called person with ID, Age and Name. 
  - To get the created SQL from EclipseLink insert the following 2 property lines in to the persistence.xml. : 
    - <property name="eclipselink.logging.level.sql" value="FINE"/><property name="eclipselink.logging.parameters" value="true"/>

Resources:  
[Tutorialspoint on JPA](http://tutorialspoint.com/jpa/)
[Simple JPA](https://hendrosteven.wordpress.com/2008/03/06/simple-jpa-application-with-netbeans)  
[More detailed JPA](http://www.javacodegeeks.com/2015/02/jpa-tutorial.html) - this one provides detailed information  

## Day 1: Introduction to ORM
[Tutorial for JPA](http://www.tutorialspoint.com/jpa/jpa_introduction.htm)
- Java Persistence API is a source to store business entities (java objects) as relational entities (db tables) 
- Challenges:  
  - Table structure in db vs graph structure in objects (references containing references ...)
  - Inheritance: Objects with inheritance hierarchy to be mirrored in tables
  - 
- JPA providers: 
  - Hybernate
  - **EclipseLink**
  - Toplink

- JPA architecture: javax.Persistence
  [!alt text](img/persistencePackage.png)
- Annotations
  - [See list of annotations](http://www.tutorialspoint.com/jpa/jpa_orm_components.htm)
- Persistence.xml
  - registers the database and specify the entity class
- Getting started: set up the first project.

##Day 2 - More JPA
- 
- 

