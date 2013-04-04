package mymall.controller;

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

    CustomerRepository userRepository = CustomerDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String remember = request.getParameter("rem");



        HttpSession session = request.getSession();
        session.setAttribute("isLogin", true);

        if ( remember != null && remember != "" ) {
            // 쿠키생성
            Cookie cookie = new Cookie("remember", id);
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
        if ( id.equals("admin") ) {
            response.sendRedirect("/admin/productList");
        } else {
            response.sendRedirect("/mymall/list");
        }
    }
}
