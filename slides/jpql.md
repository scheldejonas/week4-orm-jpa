#Day 4 - JPQL
### Quering with JPQL

[Reference material](https://en.wikibooks.org/wiki/Java_Persistence/JPQL)  
- JPA provides several querying mechanisms:
  - JPQL  
  - Criteria API
  - Native SQL Queries

- We will focus only on 
  - **JPQL ** (Java Persistence Query Language).

- JPQL is the query language defined by JPA. 
- It is similar to SQL, **BUT** operates on 
  - objects, 
  - attributes and 
  - relationships 
  - instead of tables and columns as in SQL

### JPQ queries - 2 kinds
- Named Queries 
  - Named queries are used for a static queries that will be used many times in the application. 
  - The advantage of a named query is that it can be defined once, in one place, and reused in the application.
  - Declaring a Named Query: 
```
@NamedQuery( 
  name="findAllEmployeesInCity", 
  query="Select emp from Employee emp where emp.address.city = :city" 
) 
public class Employee { ... }
```
Executing a Named Query:
```
EntityManager em = getEntityManager(); 
Query query = em.createNamedQuery("findAllEmployeesInCity"); 
query.setParameter("city", "Ottawa"); 
List<Employee> employees = query.getResultList();
```

- Dynamic Queries
  - Dynamic queries are normally used when the query depends on the context. 
  - For example, depending on which items in the query form were filled in, the query may have different parameters. 
  - Dynamic queries are also useful for uncommon queries.
  - [Tutorial for JPQL syntax and examples](https://en.wikibooks.org/wiki/Java_Persistence/JPQL)

### Lets Demo
<img align="right" src="img/demoman.png" />  



###Exercise 4 - JPQL
[Find the exercise here](exercises/JPQL_Exercise.docx)
