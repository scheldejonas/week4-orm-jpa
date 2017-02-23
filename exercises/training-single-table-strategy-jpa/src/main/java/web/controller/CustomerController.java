package web.controller;

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

    private CustomerController() {
    }

    public static CustomerController getSingleton() {
        if (singleton == null) {
            singleton = new CustomerController();
        }
        return singleton;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
