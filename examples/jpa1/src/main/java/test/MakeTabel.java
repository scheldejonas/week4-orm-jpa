package test;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MakeTabel {
  public static void main(String[] args) {
    Persistence.generateSchema("pu", null);
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Book b1 = new Book("Learn JPA");
     em.persist(b1);
    em.getTransaction().commit();
    
  
    
  }
}
