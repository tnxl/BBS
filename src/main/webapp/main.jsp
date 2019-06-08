<%--
  Created by IntelliJ IDEA.
  User: Lsy
  Date: 2019/6/4
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="Login" method="post" name="form1">
    账号：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    <input type="submit" value="登录">
    <input type="button" value="注册" onclick="reg()">
</form>

<script>
    function reg() {
        document.form1.action = "reg.jsp";
        document.form1.submit();
    }
</script>

</body>
</html>
