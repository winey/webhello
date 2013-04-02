package mymall.controller;

import myboard.entity.Board;
import mymall.entity.Product;
import mymall.repository.ProductDBRepository;
import mymall.repository.ProductRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 29
 * Time: 오후 4:58
 * To change this template use File | Settings | File Templates.
 */
public class AdminProductListServlet extends HttpServlet {

    ProductRepository productRepository = ProductDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. model에서 데이터 조회
        List<Product> products = productRepository.getProduct();

//        for (Product product : products) {
//            System.out.println("product = " + product);
//        }

        //2. request에 데이터 셋팅
        request.setAttribute("products",products);

        //3. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/admin/productList.jsp");
        view.forward(request, response);
    }

}
