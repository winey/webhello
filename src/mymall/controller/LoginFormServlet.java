package mymall.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 4. 4
 * Time: 오후 5:44
 * To change this template use File | Settings | File Templates.
 */
public class LoginFormServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String remember = null;
        String id = "";
        Cookie[] cookies = request.getCookies();

        for (int i =0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("remember")) {
                remember = cookie.getValue();
                id = remember;
                break;
            }
        }

        request.setAttribute("id",id);
        request.setAttribute("rem", remember);


        //jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/login/loginForm.jsp");
        view.forward(request, response);

    }
}