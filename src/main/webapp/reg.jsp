<%--
  Created by IntelliJ IDEA.
  User: Lsy
  Date: 2019/6/4
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>

<form action="doReg.jsp" method="post">

    账号：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    年龄：<input type="number" name="age"><br>
    性别：<input type="text" name="sex"><br>
    手机：<input type="text" name="phone"><br>
    <input type="submit" value="注册">

</form>

</body>
</html>
