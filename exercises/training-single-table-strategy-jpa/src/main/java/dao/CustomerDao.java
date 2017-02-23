package dao;

import domain.Customer;

import java.util.List;

/**
 * Created by scheldejonas on 22/02/2017.
 */
public interface CustomerDao {
    void save(Customer customer);

    List<Customer> findAll();
}
