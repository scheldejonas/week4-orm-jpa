package service;

import domain.Customer;

import java.util.List;

/**
 * Created by scheldejonas on 23/02/2017.
 */
public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);
}
