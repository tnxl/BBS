<%@ page import="com.skynet.action.UserAction" %><%--
  Created by IntelliJ IDEA.
  User: Lsy
  Date: 2019/6/4
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录处理</title>
</head>
<body>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username!=null&&password!=null){
        UserAction user = new UserAction(username,password);
        if (user.login()){
            request.getRequestDispatcher("welcom.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }
    }else {
        out.print("输入不完全");
    }
%>

</body>
</html>
