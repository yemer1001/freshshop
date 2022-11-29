<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-用户中心</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
	<div class="header_con">
		<%@ include file="header.jsp"%>
	</div>

	<div class="search_bar clearfix">
		<a href="index.jsp" class="logo fl"><img src="${pageContext.request.contextPath}/images/logo.png"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
		<div class="search_con fr">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>		
	</div>

	<div class="main_con clearfix">
		<div class="left_menu_con clearfix">
			<h3>用户中心</h3>
			<ul>
				<li><a href="user_center_info.html">· 个人信息</a></li>
				<li><a href="user_center_order.jsp" class="active">· 全部订单</a></li>
				<li><a href="user_center_site.html">· 收货地址</a></li>
			</ul>
		</div>
		<div class="right_content clearfix">
				<h3 class="common_title2">全部订单</h3>
			<c:forEach var="order" items="${orders}">
				<ul class="order_list_th w978 clearfix">
					<li class="col01">${order.createtime}</li>
					<li class="col02">订单号：${order.ordernum}</li>
					<c:if test="${order.status == 1}">
					<li class="col02 stress">未支付</li>
					</c:if>
					<c:if test="${order.status == 2}">
						<li class="col02 stress">代发货</li>
					</c:if>
					<c:if test="${order.status == 3}">
						<li class="col02 stress">待收货</li>
					</c:if>
					<c:if test="${order.status == 4}">
						<li class="col02 stress">待评论</li>
					</c:if>
				</ul>

				<table class="order_list_table w980">
					<tbody>
						<tr>
							<td width="55%">
								<c:forEach var="d" items="${order.lists}">
								<ul class="order_goods_list clearfix">					
									<li class="col01"><img src="${d.imgpath}"></li>
									<li class="col02">${d.goodsname}<em>${d.price}元/${d.unit}</em></li>
									<li class="col03">${d.count}</li>
									<li class="col04">${d.count*d.price}</li>
								</ul>
								</c:forEach>
							</td>
							<td width="15%">${order.totalprice}元</td>
							<td width="15%">
								<c:if test="${order.status == 1}">
									未支付
								</c:if>
								<c:if test="${order.status == 2}">
									代发货
								</c:if>
								<c:if test="${order.status == 3}">
									待收货
								</c:if>
								<c:if test="${order.status == 4}">
									待评论
								</c:if>
							</td>
							<td width="15%"><a href="#" class="oper_btn">
								<c:if test="${order.status == 1}">
									<li class="col02 stress">去付款</li>
								</c:if>
								<c:if test="${order.status == 2}">
									<li class="col02 stress">待发货</li>
								</c:if>
								<c:if test="${order.status == 3}">
									<li class="col02 stress">确认收货</li>
								</c:if>
								<c:if test="${order.status == 4}">
									<li class="col02 stress">去评论</li>
								</c:if>
							</a></td>
						</tr>
					</tbody>
				</table>
			</c:forEach>

				<div class="pagenation">
					<a href="#">上一页</a>
					<a href="#" class="active">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#">下一页></a>
				</div>
		</div>
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
		<p>CopyRight © 2020 北京天天生鲜信息技术有限公司 All Rights Reserved</p>
		<p>电话：010-****888    京ICP备*******8号</p>
	</div>
	
</body>
</html>