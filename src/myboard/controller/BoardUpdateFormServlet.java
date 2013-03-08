package myboard.controller;

import myboard.entity.Board;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * User: HolyEyE
 * Date: 13. 2. 22. Time: 오후 4:37
 */
public class BoardUpdateFormServlet extends HttpServlet{

    BoardRepository boardRepository = BoardMemoryRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            response.sendRedirect("/board/loginform");
            return;
        }


        int id = Integer.parseInt (request.getParameter("id"));
        Board board = boardRepository.getBoardById(id);


        if (board == null) {
            response.sendRedirect("/board/list");
        }

        request.setAttribute("board", board);

        // jsp찾아서 이동
        RequestDispatcher view = request.getRequestDispatcher("/board/boardUpdateForm.jsp");
        view.forward(request, response);
    }
}
