<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/22/022
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="header">
    <div class="welcome fl">欢迎来到天天生鲜!</div>
    <div class="fr">
        <%--<div class="login_info fl">
            欢迎您：<em>张 山</em>
        </div>--%>
        <div class="login_btn fl">
            <c:if test="${sessionScope.USER == null}">
                <a href="${pageContext.request.contextPath}/user/login.jsp">登录</a>
            </c:if>
            <c:if test="${sessionScope.USER != null}">
                <span>${sessionScope.USER.username}</span>
            </c:if>

            <span>|</span>
            <a href="${pageContext.request.contextPath}/user/register.jsp">注册</a>
        </div>
        <div class="user_link fl">
            <span>|</span>
            <a href="user_center_info.html">用户中心</a>
            <span>|</span>
            <a href="cart.jsp">我的购物车</a>
            <span>|</span>
            <a href="user_center_order.html">我的订单</a>
            <span>|</span>
            <a href="LogoutServlet">退出登录</a>
        </div>
    </div>
</div>
</body>
</html>
