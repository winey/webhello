<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>수정</title>
  </head>
  <body>
  <%

      Board board = (Board) request.getAttribute("board");
  %>
  <form method=post action="/board/update">
      <table>
          <tr>
              <td>id</td><td><input type="text" name="id" value="<%=board.getId()%>" readonly /></td>
          </tr>
          <tr>
              <td>title</td><td><input type="text" name="title" value="<%=board.getTitle()%>" /></td>
          </tr>
          <tr>
              <td>writer</td><td><input type="text" name="writer" value="<%=board.getWriter()%>" /></td>
          </tr>
          <tr>
              <td>pw</td><td><input type="password" name="pw" value="<%=board.getPw()%>"/></td>
          </tr>
          <tr>
              <td>content</td><td><textarea name="content"><%=board.getContent()%></textarea> </td>

          </tr>
      </table>

      <input type="submit" value="수정" />
  </form>
  </body>
</html>