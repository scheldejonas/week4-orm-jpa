package dao;

import config.DataConfig;
import domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by scheldejonas on 22/02/2017.
 */
public class CustomerDaoImpl implements CustomerDao {

    private static CustomerDao singleton = null;
    private EntityManagerFactory trainingJpaEntityManager = null;

    private CustomerDaoImpl() {
        this.trainingJpaEntityManager = DataConfig.getInstanceOfEntityManagerFactory();
    }

    public static CustomerDao getInstance() {
        if (singleton == null) {
            singleton = new CustomerDaoImpl();
        }
        return singleton;
    }

    @Override
    public void save(Customer customer) {
        EntityManager entityManager = trainingJpaEntityManager.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(customer);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public List<Customer> findAllCustomers() {
        EntityManager entityManager = trainingJpaEntityManager.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Customer> customerList = entityManager.createQuery("select c from Customer c order by c.id asc").getResultList();
        entityTransaction.commit();
        entityManager.close();
        return customerList;
    }


    // Start EntityManagerFactory
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("helloworld");
//        // First unit of work
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        Message message = new Message("Hello World");
//        em.persist(message);
//        tx.commit();
//        em.close();
//        // Second unit of work
//        EntityManager newEm = emf.createEntityManager();
//        EntityTransaction newTx = newEm.getTransaction();
//        newTx.begin();
//        List messages = newEm
//                .createQuery("select m from Message m
//                        ➥ order by m.text asc")
//                                .getResultList();
//
//        System.out.println( messages.size() + " message(s) found" );
//        for (Object m : messages) {
//            Message loadedMsg = (Message) m;
//            System.out.println(loadedMsg.getText());
//        }
//        newTx.commit();
//        newEm.close();
//        // Shutting down the application
//        emf.close();



}
