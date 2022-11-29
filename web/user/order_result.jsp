<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>天天生鲜-订单结果页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="header_con">
    <%@include file="header.jsp"%>
</div>

<div>
  <c:if test="${res == true}">
      <p style="font-size: 30px" >订单提交成功！<a>去支付</a>
          或者<a href="${pageContext.request.contextPath}/FindIndexInfoServlet">继续购物</a></p>
  </c:if>
    <c:if test="${res == false}">
        <p style="font-size: 30px" >订单提交失败！</p>
    </c:if>
</div>

<div class="footer">
    <div class="foot_link">
        <a href="#">关于我们</a>
        <span>|</span>
        <a href="#">联系我们</a>
        <span>|</span>
        <a href="#">招聘人才</a>
        <span>|</span>
        <a href="#">友情链接</a>
    </div>
    <p>CopyRight © 2020北京天天生鲜信息技术有限公司 All Rights Reserved</p>
    <p>电话：010-****888    京ICP备*******8号</p>
</div>
</body>
</html>
