package service;

import dao.CustomerDao;
import domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by scheldejonas on 23/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private CustomerService customerService = CustomerServiceImpl.getSingleton();

    @Test
    public void findAllCustomersShouldReturnTwo() {
        List<Customer> customerList = Arrays.asList(
                new Customer(),
                new Customer()
        );
        when(customerDao.findAll()).thenReturn(customerList);
        assertEquals("Find all Customers Should Return Two Customers",2,customerService.findAll().size());

        verify(customerDao).findAll();
    }
}
