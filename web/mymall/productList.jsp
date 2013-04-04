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
                        <li class="active"><a href="#">상품목록</a></li>
                        <li><a href="#">나의주문내역</a></li>
                    </ul>
                </div>
            </div>
        </div><!-- /.navbar -->
    </div>

    <div class="jumbotron">
        <h2>상품목록</h2>

        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <td>번호</td>
                <td>상품명</td>
                <td>가격</td>
                <td>재고</td>
                <td>구매</td>

            </tr>
            <thead>
            <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.productId}</td>
                <td><a href="">${product.name}</a></td>
                <td>${product.price}</td>
                <td>${product.amount}</td>
                <td><a href="/mymall/order?id=${product.productId}">구매</a></td>
            </tr>
        </c:forEach>
            </tbody>
        </table>
    </div>


    <div class="footer">
        <p>&copy; Company 2013</p>
    </div>

</div> <!-- /container -->
</body>
</html>