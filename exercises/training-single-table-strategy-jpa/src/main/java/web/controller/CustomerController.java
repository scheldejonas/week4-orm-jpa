package web.controller;

import domain.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by scheldejonas on 23/02/2017.
 */
@WebServlet(name = "CustomerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet{

    private static CustomerController singleton = null;

    private CustomerService customerService = null;

    private CustomerController() {
        customerService = CustomerServiceImpl.getSingleton();
    }

    public static CustomerController getSingleton() {
        if (singleton == null) {
            singleton = new CustomerController();
        }
        return singleton;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.equals("/customers/add")) {
            sendToCustomerForm(req,resp);
        }
    }

    private void sendToCustomerForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html,charset=UFF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/templates/customer/form.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.equals("/customers/add")) {
            processAddCustomer(req,resp);
        }
    }

    private void processAddCustomer(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        String firstName = request.getHeader("first_name");
        int price = request.getIntHeader("price");
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setPrice(price);
    }
}
