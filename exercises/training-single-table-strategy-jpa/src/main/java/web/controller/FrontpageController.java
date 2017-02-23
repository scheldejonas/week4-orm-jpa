package web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by scheldejonas on 22/02/2017.
 */
@WebServlet(name = "FrontpageController", urlPatterns = { "/"})
public class FrontpageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccesGet(req,resp);
    }

    private void proccesGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;chartset=UTF-8");
        String requestURI = request.getRequestURI();
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/templates/index.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
