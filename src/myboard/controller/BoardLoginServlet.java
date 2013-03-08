package myboard.controller;

import myboard.entity.Board;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class BoardLoginServlet extends HttpServlet{

    BoardRepository boardRepository = BoardMemoryRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String remember = request.getParameter("rem");

        HttpSession session = request.getSession();
        session.setAttribute("isLogin", true);

        //접속자수 추가
        if (request.getServletContext().getAttribute("loginCount") == null) {
            request.getServletContext().setAttribute("loginCount", 1);
        } else {
            request.getServletContext().setAttribute("loginCount", ((Integer) request.getServletContext().getAttribute("loginCount")) + 1);
        }


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
        response.sendRedirect("/board/list");
    }
}
