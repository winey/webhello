package mymall.controller;

import mymall.entity.Customer;
import mymall.entity.Product;
import mymall.repository.CustomerDBRepository;
import mymall.repository.CustomerRepository;
import mymall.repository.ProductDBRepository;
import mymall.repository.ProductRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 4. 5
 * Time: 오후 2:43
 * To change this template use File | Settings | File Templates.
 */
public class OrderFormServlet extends HttpServlet {

    CustomerRepository customerRepository = CustomerDBRepository.getInstance();
    ProductRepository productRepository = ProductDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            response.sendRedirect("/login/loginForm");
            return;
        }


        int customerId = (int) parseInt (session.getAttribute("LoginId").toString());
        String customerName = session.getAttribute("LoginName").toString();
        Customer customer = customerRepository.getCustomerByName(customerName);

        int productId = (int) parseInt(request.getParameter("id"));
        Product product = productRepository.getProductById(productId);


        request.setAttribute("product", product);
        request.setAttribute("customer", customer);

        //jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/mymall/orderForm.jsp");
        view.forward(request, response);

    }
}
