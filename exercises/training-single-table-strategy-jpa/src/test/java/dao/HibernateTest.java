package dao;

import config.DataConfig;
import domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by scheldejonas on 23/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class HibernateTest {

    @InjectMocks
    private CustomerDao customerDao = CustomerDaoImpl.getSingleton();

    @Test
    public void findAllCustomersWithErrorShouldRollBackTransaction() {
        EntityManager entityManager = DataConfig.getSingleton().getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = null;

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Customer customer = new Customer();
            customer.setFirstName("Jonas");
            customer.setPrice(200);
            entityManager.persist(customer);
            throw new RuntimeException("Rollback test.");
            //entityTransaction.commit();
        } catch (Exception exception) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            System.err.println("Transaction rolled back: " + exception.getMessage());
        } finally {
            entityManager.close();
        }
    }

}
