package mymall.controller;

import mymall.entity.Product;
import mymall.repository.ProductDBRepository;
import mymall.repository.ProductRepository;

import javax.servlet.RequestDispatcher;
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
public class ProductUpdateFormServlet extends HttpServlet {

    ProductRepository productRepository = ProductDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));


        Product product = productRepository.getProductById(id);

        if (product == null) {
            response.sendRedirect("/admin/productList");
        }

        request.setAttribute("product", product);

        //jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/admin/productUpdateForm.jsp");
        view.forward(request, response);
    }
}
