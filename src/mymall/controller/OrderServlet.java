package mymall.controller;

import mymall.entity.Customer;
import mymall.entity.Order;
import mymall.entity.Product;
import mymall.repository.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 4. 5
 * Time: 오후 1:38
 * To change this template use File | Settings | File Templates.
 */
public class OrderServlet extends HttpServlet {

    OrderRepository orderRepository = OrderDBRepository.getInstance();
    CustomerRepository customerRepository = CustomerDBRepository.getInstance();
    ProductRepository productRepository = ProductDBRepository.getInstance();
    private final DBhandle dbHandle = new DBhandle();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            response.sendRedirect("/login/loginForm");
            return;
        }


        int productId = (int) parseInt(request.getParameter("productId"));
        Product product = productRepository.getProductById(productId);
        int amount = product.getAmount() - 1;
//        int amount = (int) parseInt(request.getParameter("amount")) - 1;
//        int price = (int) parseInt(request.getParameter("price"));


        int customerId = (int) parseInt (session.getAttribute("LoginId").toString());
        String customerName = session.getAttribute("LoginName").toString();
        Customer customer = customerRepository.getCustomerByName(customerName);
        int balance = customer.getBalance() - product.getPrice();
//        int balance = (int) parseInt(request.getParameter("balance")) - price;

        System.out.println("amount = " + amount);
        System.out.println("balance = " + balance);


        Product updateProduct = new Product();
        updateProduct.setProductId(productId);
        updateProduct.setAmount(amount);

        Customer updateCustomer = new Customer();
        updateCustomer.setId(customerId);
        updateCustomer.setBalance(balance);

        Order order = new Order();
        order.setProductId(productId);
        order.setCustomerId(customerId);
        order.setMemo(request.getParameter("memo"));

        Connection conn = null;

        try {
            conn = dbHandle.dbConnect();

            conn.setAutoCommit(false);
            orderRepository.addOrder(conn, order);
            productRepository.updateProduct(conn, updateProduct);
            customerRepository.updateCustomer(conn, updateCustomer);
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbHandle.dbDisconnect(conn);
        }

        response.sendRedirect("/mymall/orderList");

    }

}
