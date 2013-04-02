package mymall.controller;

import com.sun.net.httpserver.HttpServer;
import mymall.repository.ProductDBRepository;
import mymall.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 4. 2
 * Time: 오후 3:10
 * To change this template use File | Settings | File Templates.
 */
public class ProductDeleteServlet extends HttpServlet {

    ProductRepository productRepository = ProductDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        productRepository.deleteProduct(id);
        response.sendRedirect("/admin/productList");
    }
}
