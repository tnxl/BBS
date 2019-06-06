<%--
  Created by IntelliJ IDEA.
  User: Lsy
  Date: 2019/6/5
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传结果</title>
</head>
<body>
<center>
    <%
        String message = (String) request.getAttribute("message");
    %>
    <h2><%=message%>
    </h2>
</center>
</body>
</html>
