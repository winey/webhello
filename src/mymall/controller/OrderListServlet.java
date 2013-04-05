package mymall.controller;

import mymall.entity.Order;
import mymall.repository.OrderDBRepository;
import mymall.repository.OrderRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 3. 29
 * Time: 오후 4:58
 * To change this template use File | Settings | File Templates.
 */
public class OrderListServlet extends HttpServlet {

    OrderRepository orderRepository = OrderDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            response.sendRedirect("/login/loginForm");
            return;
        }
        int customerId = Integer.parseInt(session.getAttribute("LoginId").toString());
        System.out.println("customerId = " + customerId);

        //1. model에서 데이터 조회
        List<Order> orders = orderRepository.getOrder(customerId);
        System.out.println("orders = " + orders);

        //2. request에 데이터 셋팅
        request.setAttribute("orders",orders);

        //3. jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/mymall/orderList.jsp");
        view.forward(request, response);
    }

}
