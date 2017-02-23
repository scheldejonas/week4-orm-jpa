package service;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import domain.Customer;

import java.util.List;

/**
 * Created by scheldejonas on 23/02/2017.
 */
public class CustomerServiceImpl implements CustomerService {

    private static CustomerService singleton = null;
    private CustomerDao customerDao = CustomerDaoImpl.getSingleton();

    private CustomerServiceImpl() {
    }

    public static CustomerService getSingleton() {
        if (singleton == null) {
            singleton = new CustomerServiceImpl();
        }
        return singleton;
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }
}
