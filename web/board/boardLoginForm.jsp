<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>등록</title>
  </head>
  <body>
  <form method=get action="/board/login">
   <table>
       <tr>
           <td>아이디</td><td><input type="text" name="id" /></td>
       </tr>
       <tr>
           <td>비번</td><td><input type="password" name="pw" /></td>
       </tr>
       <tr>
           <td>아이디저장</td><td><input type="checkbox" name="rem" value=1 <%
           if (request.getAttribute("rem").equals("1")) {%> checked <% }
           %>/></td>
       </tr>
     </table>

   <input type="submit" value="로그인" />
   </form>
  </body>
</html>