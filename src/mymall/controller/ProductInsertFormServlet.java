package mymall.controller;

import mymall.repository.ProductDBRepository;
import mymall.repository.ProductRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 29
 * Time: 오후 5:55
 * To change this template use File | Settings | File Templates.
 */
public class ProductInsertFormServlet extends HttpServlet {

    ProductRepository productRepository = ProductDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/admin/productInsertForm.jsp");
        view.forward(request, response);

    }
}
