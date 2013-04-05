package mymall.controller;

import mymall.entity.Customer;
import mymall.repository.CustomerDBRepository;
import mymall.repository.CustomerRepository;
import mymall.repository.ProductDBRepository;
import mymall.repository.ProductRepository;

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
public class LoginServlet extends HttpServlet {

    CustomerRepository customerRepository = CustomerDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String pw = request.getParameter("pw");
        String rem = request.getParameter("rem");


        Customer customer = customerRepository.getCustomerByName(name);
        if (!customer.getPw().equals(pw)) {
             response.sendRedirect("/login/loginForm");
        }


        HttpSession session = request.getSession();
        session.setAttribute("isLogin", true);
        session.setAttribute("LoginId", customer.getId());
        session.setAttribute("LoginName", customer.getName());

        System.out.println("session.getAttribute(\"LoginId\") = " + session.getAttribute("LoginId"));
        System.out.println("session.getAttribute(\"LoginName\") = " + session.getAttribute("LoginName"));

        if ( rem != null && rem != "" ) {
            // 쿠키생성
            Cookie cookie = new Cookie("remember", name);
            cookie.setMaxAge(30*24*60*60);
            response.addCookie(cookie);
        } else {
            // 쿠키 삭제
            Cookie[] cookies = request.getCookies();
            for (int i =0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("remember")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }

        }

        //list로 이동
        if ( name.equals("admin") ) {
            response.sendRedirect("/admin/productList");
        } else {
            response.sendRedirect("/mymall/list");
        }
    }
}
