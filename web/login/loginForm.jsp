<%--
  Created by IntelliJ IDEA.
  User: winey
  Date: 13. 4. 4
  Time: 오후 6:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
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
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>
    <link href="/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <script>
        function checkLoginForm() {
            f = document.forms[0];
            if (f.name == null) {
                return false;
            }
            if (f.pw == null) {
                return false;
            }
            f.action = "/login/login"
            f.submit();
            return true;
        }
        function checkAddForm() {
            f = document.forms[0];
            if (f.name == null) {
                return false;
            }
            if (f.pw == null) {
                return false;
            }
            f.action = "/login/add"
            f.submit();
            return true;
        }
    </script>
</head>

<body>

<div class="container">

    <form class="form-signin" action="">
        <h2 class="form-signin-heading">로그인</h2>
        <input type="text" name="name" class="input-block-level" placeholder="이름">
        <input type="password" name="pw" class="input-block-level" placeholder="비밀번호">
        <label class="checkbox">
            <input type="checkbox" name="rem" value="remember-me">저장
        </label>
        <button class="btn btn-large btn-primary" type="submit" onclick="return checkLoginForm()">로그인</button>
        <button class="btn btn-large btn-success" type=submit onclick="return checkAddForm()">가입</button>
    </form>




</div> <!-- /container -->


</body>
</html>