<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/20/020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
</head>
<body>
    <%request.getRequestDispatcher("FindIndexInfoServlet").forward(request,response);%>
</body>
</html>
