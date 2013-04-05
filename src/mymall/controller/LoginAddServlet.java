package mymall.controller;

import mymall.entity.Customer;
import mymall.repository.CustomerDBRepository;
import mymall.repository.CustomerRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 4. 4
 * Time: 오후 5:49
 * To change this template use File | Settings | File Templates.
 */
public class LoginAddServlet extends HttpServlet {

    CustomerRepository customerRepository = CustomerDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String pw = request.getParameter("pw");
        String remember = request.getParameter("rem");


        Customer customer = new Customer();
        customer.setName(name);
        customer.setPw(pw);
        customerRepository.addCustomer(customer);

        response.sendRedirect("/login/loginForm");
    }
}
