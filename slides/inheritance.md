#Day3 - Inheritance  
Look at this example
![alt text](../img/inheritance.png)

```
//ITEM:
Item item = new Item();
item.setTitle("Title for an Item");
//BOOK:   
Book book = new Book();
book.setIsbn("9780828815130");
book.setTitle("The Da Vinci Code");
//CD:
CD cd = new CD();
cd.setTitle("Mylo Xyloto");
cd.setNumbersOnCD(11);
```

###3 strategies  
  - Single table
    - DTYPE collumn and null values
  - Joined
    - One table for the super class and one for each sub class containing the extended data
  - Table per Class   

### Single-Table strategy: 

- Single table inheritance is the simplest, and default, and often the best performing solution
- A single table is used to store all of the instances of the entire inheritance hierarchy. 
- The table will have a column for every attribute of every class in the hierarchy. 
- A discriminator column is used to determine which class the particular row belongs to.
![alt](../img/singleTable.png)

#### Single-Table example code:
ITEM: 
```
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  //Getters Setters
}
```
BOOK:  
``` @Entity
public class Book extends Item{
 private String isbn;
//Getters Setters
}
```
CD:
```@Entity
public class CD extends Item {
private int numbersOnCd;
//Getters Setters
}
```
SQL (in DB):
```
CREATE TABLE ITEM (
  ID BIGINT NOT NULLPRIMARY KEY, 
  DTYPE VARCHAR(31), -- Here is the discriminator collumn.
  TITLE VARCHAR(255), 
  ISBN VARCHAR(255), 
  NUMBERSONCD INTEGER
);
```
#### PROs
- The default 
- Simple to understand
- Works well when the hierarchy is relatively simple and stable. 

#### CONs
- Adding new entities to the hierarchy, or adding attributes to existing entities, involves adding new columns to the table, migrating data, and changing indexes. 
- All columns of the child entities must be Nullable.
- If mapping to an existing database schema, our table may not have a class discriminator column 

### Joined table strategy
- Joined inheritance is the inheritance strategy that most closely mirrors the object model into the data model
- A table is defined for each class in the inheritance hierarchy to store only the local attributes of that class
- Each table in the hierarchy must also store the object's id (primary key), defined in the root class
- All classes in the hierarchy must share the same id attribute
- A discriminator column is used to determine which class the particular row belongs to.
![alt](../img/joinedTable.png)
![alt](../img/inheritance.png)


### Joined table example code
```
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  //Getters Setters
}
```
```
@Entity
public class Book extends Item{
 private String isbn; // No id (only relevant for the tables)
//Getters Setters
}
```
```@Entity
public class CD extends Item {
  private int numbersOnCd;
//Getters Setters
}
```
<div align="right"> 
```sql
CREATE TABLE ITEM (
  ID BIGINT NOT NULL PRIMARY KEY, 
  DTYPE VARCHAR(31), 
  TITLE VARCHAR(100)
);
CREATE TABLE CD (
  ID BIGINT NOT NULL PRIMARY KEY, 
  NUMBERSONCD INTEGER,
  CONSTRAINT FK_CD_ID FOREIGN KEY (ID) REFERENCES ITEM(ID)
);
CREATE TABLE BOOK (
  ID BIGINT NOT NULL PRIMARY KEY ,  
  ISBN VARCHAR(14), 
  CONSTRAINT FK_BOOK_ID FOREIGN KEY (ID) REFERENCES ITEM(ID)
);
```
</div> 

#### PROs and CONs
- PROs
  - The joined-subclass strategy is intuitive and is close to what we know from OO-inheritance
- CONs
  - Querying can have a performance impact. The strategy is called joined because, to reassemble an instance of a subclass, the subclass table has to be joined with the root class table. The deeper the hierarchy, the more joins needed to assemble a leaf entity
-  If mapping to an existing database schema, our table may not have a class discriminator column 

### Inheritance strategy: Table-Per-Class
- From a database point of view, this strategy denormalizes the model 
- Causes all root entity attributes to be redefined in the tables of all leaf entities that inherit from it.  
![alt](../img/tablePerClass.png)

With the table-per-concrete-class strategy, there is:
- no shared table
- no shared columns
- no discriminator column

#### PROs and CONs
- Pros
  - Performs well when querying instances of one entity 
- Cons
  - Polymorphic queries across a class hierarchy more expensive than the other strategies (e.g., finding all the items, including CDs and books); it must query all subclass tables using a UNION operation, which is expensive when a large amount of data is involved.
  - Entity Support for this strategy is optional in JPA 2.0.


![alt text](../img/tablePerClass.png)

### Lets Demo
<img align="right" src="../img/demoman.png" />  


###Exercise 3 - Inheritance
[Find the exercise here](../exercises/JPA_MappingExercise-3.pdf)
