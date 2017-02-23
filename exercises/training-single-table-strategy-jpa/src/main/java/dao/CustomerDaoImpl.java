package dao;

import config.DataConfig;
import domain.Customer;
import org.omg.CORBA.DATA_CONVERSION;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scheldejonas on 22/02/2017.
 */
public class CustomerDaoImpl implements CustomerDao {

    private static CustomerDao singleton = null;
    private EntityManagerFactory trainingJpaEntityManager = null;

    private CustomerDaoImpl() {
        this.trainingJpaEntityManager = DataConfig.getSingleton().getEntityManagerFactory();
    }

    public static CustomerDao getSingleton() {
        if (singleton == null) {
            singleton = new CustomerDaoImpl();
        }
        return singleton;
    }

    @Override
    public void save(Customer customer) {
        EntityManager entityManager = trainingJpaEntityManager.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(customer);
            entityTransaction.commit();
        } catch (Exception exception) {
            entityTransaction.rollback();
            exception.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Customer> findAll() {
        EntityManager entityManager = trainingJpaEntityManager.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        List<Customer> customerList = new ArrayList<>();
        try {
            entityTransaction.begin();
            customerList = entityManager.createQuery("select c from Customer c order by c.id asc").getResultList();
            entityTransaction.commit();
        } catch (Exception exception) {
            entityTransaction.rollback();
            exception.printStackTrace();
        } finally {
            entityManager.close();
        }
        return customerList;
    }

}
