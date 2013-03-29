package mymall.controller;

import mymall.entity.Product;
import mymall.repository.ProductDBRepository;
import mymall.repository.ProductRepository;

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
 * Date: 13. 3. 29
 * Time: 오후 5:55
 * To change this template use File | Settings | File Templates.
 */
public class ProductSaveServlet  extends HttpServlet {


    ProductRepository productRepository = ProductDBRepository.getInstance();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //데이터 저장
        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setPrice((int) parseInt(request.getParameter("price")));
        product.setAmount((int) parseInt(request.getParameter("amount")));
        productRepository.addProduct(product);

        //list로 이동
        response.sendRedirect("/admin/productList");
    }
}
