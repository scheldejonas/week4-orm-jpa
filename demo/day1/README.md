##JPA Demo

###This demo project contains a JPA entity class, Mapper class, Persistence Unit and Junit test.
1. Open the project
2. Open persistence Unit and set connection to your own mysql database (use a new one) and set to Drop and Create every time the entitymanager is running
3. Run the testfile: TestPackages/data/PersonMapperTest.java
4. Verify that all 7 tests run
5. Verify that Person table was created in database
6. Now inspect the following files:
	1. Person (this is the entity class with all the annotations)
	2. PersonMapper (this is the mapper class with all the CRUD operations on the Person entity)
	3. PersonMapperTest.java (This is where all the mapper methods are tested)
	4. Dependency section in POM.xml