<%--
  Created by IntelliJ IDEA.
  User: winey
  Date: 13. 3. 29
  Time: 오후 5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-insert {

            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .form-insert .form-insert-heading,
        .form-inset .checkbox {
            margin-bottom: 10px;
        }
        .form-insert input[type="text"],
        .form-insert input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>
</head>
<body>

<div class="container">

    <div class="masthead">
        <h3 class="muted">간지쇼핑</h3>
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <ul class="nav">
                        <li class="active"><a href="/mymall/list">상품목록</a></li>
                        <li><a href="#">나의주문내역</a></li>
                    </ul>
                </div>
            </div>
        </div><!-- /.navbar -->
    </div>

    <div class="jumbotron">

        <form method=post action="/mymall/order" class="form-insert">
            <h2 class="form-insert-heading">주문</h2>
            번호 <input type="text" name="productId" class="input-block-level" placeholder="번호" value="${product.productId}" readonly="true">
            상품명 <input type="text" name="productName" class="input-block-level" placeholder="상품명" value="${product.name}" readonly="true">
            금액 <input type="text" name="price" class="input-block-level" placeholder="금액" value="${product.price}" readonly="true">
            재고<input type="text" name="amount" class="input-block-level" placeholder="재"value="${product.amount}" readonly="true">

            현재잔액 <input type="text" name="balance" class="input-block-level" placeholder="잔액"value="${customer.balance}" readonly="true">

            배송정보 <input type="text" name="memo" class="input-block-level" placeholder="배송정보">

            <button class="btn btn-large btn-primary" type="submit">구매</button>
        </form>

    </div>


    <div class="footer">
        <p>&copy; Company 2013</p>
    </div>

</div> <!-- /container -->
</body>
</html>