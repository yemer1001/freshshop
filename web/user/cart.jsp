<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-购物车</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body>
	<div class="header_con">
		<%@include file="header.jsp"%>
	</div>

	<div class="search_bar clearfix">
		<a href="index.jsp" class="logo fl"><img src="${pageContext.request.contextPath}/images/logo.png"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;购物车</div>
		<div class="search_con fr">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>		
	</div>
	<form action="${pageContext.request.contextPath}/cart/checkOut.do" method="post">
	<div class="total_count">全部商品<em>${totalCount}</em>件</div>
	<ul class="cart_list_th clearfix">
		<li class="col01">商品名称</li>
		<li class="col02">商品单位</li>
		<li class="col03">商品价格</li>
		<li class="col04">数量</li>
		<li class="col05">小计</li>
		<li class="col06">操作</li>
	</ul>
	<ul class="cart_list_td clearfix">
		<c:forEach var="c" items="${carts}">
		<li class="col01"><input type="checkbox" name="goodsids" checked value="${c.goodsid}"></li>
		<li class="col02"><img src="${c.imgpath}"></li>
		<li class="col03">${c.goodsname}<br><em>${c.price}元/${c.unit}</em></li>
		<li class="col04">${c.unit}</li>
		<li class="col05">${c.price}元</li>
		<li class="col06">
			<div class="num_add">
				<a href="javascript:;" class="add fl" onclick="updateCart('add',${c.cartid})">+</a>
				<input type="text" class="num_show fl" id="${c.cartid}" value="${c.count}">
				<a href="javascript:;" class="minus fl" onclick="updateCart('sub',${c.cartid})">-</a>
			</div>
		</li>
		<li class="col07">${c.count*c.price}元</li>
		<li class="col08"><a href="javascript:;" onclick="delCart(${c.cartid})">删除</a></li>
<%--存储总金额和总件数--%>
		<c:set var="totalPrice" value="${totalPrice+c.count*c.price}"></c:set>
		<c:set var="totalCount" value="${totalCount+c.count}"></c:set>
	</ul>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script>
		function updateCart(type,cartid){
			console.log(type+" "+cartid);
			let countObj = $("#"+cartid)
		let count = countObj.val();
		if (type=='sub'&& count <= 1){
			alert("不能再减了");
			return false;
		}
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/cart/updateCart.do",
				data:{"type":type,"cartid":cartid},
				dataType:"json",
				success:function (msg){
					if (msg==true){
						if (type=="sub"){
							countObj.val(parseInt(count)-1);
						}else {
							countObj.val(parseInt(count)+1);
						}
					}else {
						alert("数量修改失败");
					}
				},
				error:function (){
					alert("网络失败")
				}
			})
		}
		//删除购物车
		function delCart(cartid){
			let _this = $(this);
			$.ajax({
				type:"get",
				url: "${pageContext.request.contextPath}/cart/delCart.do",
				data: {"cartid":cartid},
				dataType: "json",
				success:function (msg){
					if (msg==true){
						alert("购物车删除成功");
						window.location.href="${pageContext.request.contextPath}/cart/findMyCart.do";
					}else {
						alert("购物车删除失败");
					}
				},
				error:function (){
					alert("网络失败")
				}
			})
		}
	</script>
	</c:forEach>
	<ul class="settlements">
		<li class="col01"><input type="checkbox" name="" checked=""></li>
		<li class="col02">全选</li>
		<li class="col03">合计(不含运费)：<span>¥</span><em>${totalPrice}</em><br>共计<b>${totalCount}</b>件商品</li>
		<li class="col04">
			<input type="submit" value="去结算">
		</li>
	</ul>
	</form>
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