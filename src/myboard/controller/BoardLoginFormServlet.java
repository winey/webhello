package myboard.controller;

import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class BoardLoginFormServlet extends HttpServlet{

    BoardRepository boardRepository = BoardMemoryRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

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
        RequestDispatcher view = request.getRequestDispatcher("/board/boardLoginForm.jsp");
        view.forward(request, response);

    }
}
