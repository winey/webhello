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
        if ( remember == null) {
            remember = "0";
        }

        HttpSession session = request.getSession();
        session.setAttribute("isLogin", true);

        if ( remember == "1") {
            Cookie cookie = new Cookie("remember", remember);
            cookie.setMaxAge(30*60);
            response.addCookie(cookie);
        }

        //list로 이동
        response.sendRedirect("/board/list");
    }
}
