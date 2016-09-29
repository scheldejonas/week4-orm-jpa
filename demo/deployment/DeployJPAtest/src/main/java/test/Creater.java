package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 27, 2016 
 */
public class Creater {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        Persistence.generateSchema("PU", null);
    }
}
