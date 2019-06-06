<%@ page import="com.skynet.action.UserAction" %><%--
  Created by IntelliJ IDEA.
  User: Lsy
  Date: 2019/6/4
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册处理</title>
</head>
<body>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String age1 = request.getParameter("age");
    int age = Integer.parseInt(age1);
    String sex = request.getParameter("sex");
    String phone = request.getParameter("phone");

    if (username!=null&&password!=null&&age1!=null&&sex!=null&&phone!=null){
        UserAction user = new UserAction(username,password,age,sex,phone);
        if (user.register()){
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("reg.jsp").forward(request,response);
        }
    }else {
        out.print("输入不完全");
    }
%>


</body>
</html>
