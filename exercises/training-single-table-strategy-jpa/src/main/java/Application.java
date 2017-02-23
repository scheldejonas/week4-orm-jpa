import com.fasterxml.classmate.AnnotationConfiguration;
import dao.CustomerDaoImpl;
import domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scheldejonas on 22/02/2017.
 */
public class Application {
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<>();
        customerList = new CustomerDaoImpl().findAllCustomers();
    }
}
