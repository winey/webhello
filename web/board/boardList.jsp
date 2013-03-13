<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

       <c:forEach var="board" items="${boards}">
<tr>
       <td>${board.id}</td>
       <td><a href="/board/detail?id=${board.id}">${board.title}</a></td>
       <td>${board.writer}</td>
       <td>${board.pw}</td>
       <td><a href="/board/updateform?id=${board.id}">수정</a></td>
       <td><a href="/board/delete?id=${board.id}">삭제</a></td>
   </tr>
       </c:forEach>
   </table>
   </div>
   <div><input type="button" value="등록" onclick="goSaveForm()" /></div>
   <div></div>
  <div>방문자수 : ${loginCount}</div>
  <c:if test="${sessionScope.isLogin eq true}"><div><a href="/board/logout">로그아웃</a></div></c:if>
  <%@ include file="/board/boardFooter.jsp"%>
  </body>
</html>