<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>보기</title>
  </head>
  <body>
  <%

      Board board = (Board) request.getAttribute("board");
  %>
  <table>
          <tr>
              <td>id</td><td><%=board.getId()%></td>
          </tr>
          <tr>
              <td>title</td><td><%=board.getTitle()%></td>
          </tr>
          <tr>
              <td>writer</td><td><%=board.getWriter()%></td>
          </tr>
          <tr>
              <td>pw</td><td><%=board.getPw()%></td>
          </tr>
          <tr>
              <td>content</td><td><textarea name="content"><%=board.getContent()%></textarea> </td>

          </tr>
      </table>
      <div><a href="/board/list">목록으로</a></div>
  </body>
</html>