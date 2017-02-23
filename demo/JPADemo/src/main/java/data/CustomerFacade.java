package data;

import entity.Address;
import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Feb 22, 2017
 */
public class CustomerFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU", null);
    
    public static void main(String[] args) {
        //Persistence.generateSchema("PU", null);
        //new CustomerFacade().insertData();
        EntityManager em = new CustomerFacade().getManager();
        
        //SELECT Single object
        Customer c = em.find(Customer.class, 4L);
        System.out.println(c);
        
        System.out.println("SELECT Single result");
        Query q1 = em.createQuery("SELECT c FROM Customer c");
        List<Customer> customers = q1.getResultList();
        for (Customer customer : customers) {
            List<Address> addresses = customer.getAddresses();
            System.out.println(customer);
            for (Address addresse : addresses) {
                System.out.println(addresse);
            }
        }
        
        System.out.println("Select customer from zip (in address object)");
        Query q2 = em.createQuery("SELECT c FROM Customer c JOIN c.addresses a WHERE a.zip = :zip");
        q2.setParameter("zip", 23030);
        customers = q2.getResultList();
        customers.stream().forEach((x)->{System.out.println(x);});
        
        System.out.println("SELECT Addresses based on a customer");
        Query q3 = em.createQuery("SELECT a FROM Address a JOIN a.customer c WHERE c.firstname = :fname");
        q3.setParameter("fname", "Henning");
        List<Address> addresses = q3.getResultList();
        addresses.stream().forEach((x)->System.out.println(x));
        
        System.out.println("SELECT Avarage salery");
        Query q4 = em.createQuery("SELECT AVG(c.salary) FROM Customer c");
        double average = Double.parseDouble(q4.getSingleResult().toString());
        System.out.println("Average salary: "+average);

        em.close();
    }
    private void insertData(){
    EntityManager em = getManager();
        em.getTransaction().begin();
        Customer cus1 = new Customer("Henning", "Hansen", 233000);
        Customer cus2 = new Customer("Hassen", "Hasibi", 350000);
        Customer cus3 = new Customer("Huang", "Hailong", 670000);
        Address address1 = new Address("2303 West Avenue", 23030);
        Address address2 = new Address("31 Beach Road", 23030);
        Address address3 = new Address("2 Forest Lane", 23040);
        Address address4 = new Address("55 Oldstreet", 23040);
        cus1.addAddress(address4);
        cus1.addAddress(address3);
        cus2.addAddress(address2);
        cus3.addAddress(address1);
        em.persist(cus1);
        em.persist(cus2);
        em.persist(cus3);
        em.getTransaction().commit();
        em.close();
    }
    
    private EntityManager getManager(){
        return emf.createEntityManager();
    }
}
