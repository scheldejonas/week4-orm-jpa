##JPA Demo
**Denne demo er ikke færdig. Mangler at færdiggøre mappere til de 4 entiter samt junit test til alle mapper methoderne!!!!!!!!!!!!!!!!!!!!**



###This demo project contains JPA entity classes, Mapper classes, Persistence Unit and Junit tests.  

1. Open the project
2. Open persistence Unit and set connection to your own mysql database (use a new one) and set to Drop and Create for each run.
3. Run the testfile: TestPackages/data/PersonMapperTest.java
4. Verify that all tests run correctly
5. Verify that all entity tables were created in the database
6. Now inspect the following files:
	1. Person (this is the first entity class with all the annotations)
	2. Phone (this is the second) (oneToOne with Person)
	3. Book (Entity class with ManyToOne with Person)
	4. Address (Entity with ManyToMany with Person)
	5. DataMapper (this is the mapper class with all the CRUD operations on the entities)
	6. DataMapperTest.java (This is where all the mapper methods are tested)
	7. Dependency section in POM.xml
7. Pay special attention to all the annotations in the 4 entity classes.