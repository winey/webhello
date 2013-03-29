<%--
  Created by IntelliJ IDEA.
  User: winey
  Date: 13. 3. 29
  Time: 오후 5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <div class="masthead">
        <h3 class="muted">간지쇼핑</h3>
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <ul class="nav">
                        <li class="active"><a href="#">상품관리</a></li>
                        <li><a href="#">주문관리</a></li>
                    </ul>
                </div>
            </div>
        </div><!-- /.navbar -->
    </div>

    <div class="jumbotron">
        <a class="btn btn-large btn-success" href="/admin/productInsertForm">상품등록</a>

        <table>
            <tr>
                <td>번호</td>
                <td>상품명</td>
                <td>가격</td>
                <td>수량</td>
                <td></td>
                <td></td>
            </tr>
        <c:forEach var="board" items="${boards}">
            <tr>
                <td>${product.product_id}</td>
                <td><a href="">${product.name}</a></td>
                <td>${product.price}</td>
                <td>${product.amount}</td>
                <td><a href="/admin/updateform?id=${product.product_id}">수정</a></td>
                <td><a href="/admin/delete?id=${product.product_id}">삭제</a></td>
            </tr>

        </c:forEach>
        </table>
    </div>


    <div class="footer">
        <p>&copy; Company 2013</p>
    </div>

</div> <!-- /container -->
</body>
</html>