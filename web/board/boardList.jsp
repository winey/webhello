<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>목록</title>
    <script>
        function goSaveForm() {
            document.location.href="/board/insertform";
            return;
        }
    </script>
  </head>
  <body>
   <div>
   <table>
       <tr>
           <td>id</td>
           <td>title</td>
           <td>writer</td>
           <td>pw</td>
           <td></td>
           <td></td>
       </tr>
  <%

      List<Board> boards = (List<Board>) request.getAttribute("boards");

      for (Board board : boards) {
  %><tr>
       <td><%=board.getId()%></td>
       <td><a href="/board/detail?id=<%=board.getId()%>"><%=board.getTitle()%></a></td>
       <td><%=board.getWriter()%></td>
       <td><%=board.getPw()%></td>
       <td><a href="/board/updateform?id=<%=board.getId()%>">수정</a></td>
       <td><a href="/board/delete?id=<%=board.getId()%>">삭제</a></td>
   </tr><%
      }
  %>
   </table>
   </div>
   <div><input type="button" value="등록" onclick="goSaveForm()" /></div>
   <div></div>
  <div>방문자수 : <%=request.getAttribute("loginCount")%></div>
   <div><a href="/board/logout">로그아웃</a></div>
  </body>
</html>