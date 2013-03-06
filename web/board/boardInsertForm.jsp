<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>등록</title>
  </head>
  <body>
  <form method=post action="/board/save">
   <table>
       <tr>
           <td>title</td><td><input type="text" name="title" /></td>
       </tr>
       <tr>
           <td>writer</td><td><input type="text" name="writer" /></td>
       </tr>
       <tr>
           <td>pw</td><td><input type="password" name="pw" /></td>
       </tr>
       <tr>
           <td>content</td><td><textarea name="content"></textarea> </td>

       </tr>
   </table>

   <input type="submit" value="등록" />
   </form>
  </body>
</html>