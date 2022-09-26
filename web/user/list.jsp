<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-商品列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
	<div class="header_con">
	<%@include file="header.jsp"%>
	</div>

	<div class="search_bar clearfix">
		<a href="index.jsp" class="logo fl"><img src="${pageContext.request.contextPath}/images/logo.png"></a>
		<div class="search_con fl">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>
		<div class="guest_cart fr">
			<a href="#" class="cart_name fl">我的购物车</a>
			<div class="goods_count fl">1</div>
		</div>
	</div>

	<div class="navbar_con">
		<div class="navbar clearfix">
			<div class="subnav_con fl">
				<h1>全部商品分类</h1>	
				<span></span>			
				<ul class="subnav">
					<li><a href="#" class="fruit">新鲜水果</a></li>
					<li><a href="#" class="seafood">海鲜水产</a></li>
					<li><a href="#" class="meet">猪牛羊肉</a></li>
					<li><a href="#" class="egg">禽类蛋品</a></li>
					<li><a href="#" class="vegetables">新鲜蔬菜</a></li>
					<li><a href="#" class="ice">速冻食品</a></li>
				</ul>
			</div>
			<ul class="navlist fl">
				<li><a href="">首页</a></li>
				<li class="interval">|</li>
				<li><a href="">手机生鲜</a></li>
				<li class="interval">|</li>
				<li><a href="">抽奖</a></li>
			</ul>
		</div>
	</div>

	<div class="breadcrumb">
		<a href="#">全部分类</a>
		<span>></span>
		<a href="#">新鲜水果</a>
	</div>

	<div class="main_wrap clearfix">
		<div class="l_wrap fl clearfix">
			<div class="new_goods">
				<h3>新品推荐</h3>
				<ul>
					<li>
						<a href="#"><img src="${pageContext.request.contextPath}/images/goods/goods001.jpg"></a>
						<h4><a href="#">进口柠檬</a></h4>
						<div class="prize">￥3.90</div>
					</li>
					<li>
						<a href="#"><img src="${pageContext.request.contextPath}/images/goods/goods002.jpg"></a>
						<h4><a href="#">玫瑰香葡萄</a></h4>
						<div class="prize">￥16.80</div>
					</li>
				</ul>
			</div>
		</div>

		<div class="r_wrap fr clearfix">
			<div class="sort_bar">
				<a href="#" class="active">默认</a>
				<a href="#">价格</a>
				<a href="#">人气</a>
			</div>

			<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
			<script>
				$(function (){
					$.ajax({
						type:"get",
						data:{"categoryid":${param.categoryid}},
						url:"${pageContext.request.contextPath}/FindMoreGoodsServlet",
						dataType:"json",
						success:function (msg){
							if (msg!=null&&msg!=""){
								console.log(msg.lists);
								let html = "";
								for (let g of msg.lists){
									html+="<li> <a href='detail.jsp'>";
									html+="<img src='"+g.imgpath+"'></a>";
									html+="<h4><a href='detail.jsp'>"+g.goodsname+"</a></h4>";
									html+="<div class='operate'>";
									html+="<span class='prize'>￥"+g.price+"</span>";
									html+="<span class='unit'>"+g.price+"/"+g.unit+"</span>";
									html+="<a href='#' class='add_goods' title='加入购物车'></a> </div></li>"
								}
								$("#goodslists").empty();
								$("#goodslists").html(html);
							}else {
								alert()
							}
						},
						error:function (){
							alert("网络访问失败");
						}
					})
				});
			</script>


			<ul class="goods_type_list clearfix" id="goodslists">
				<li>
					<a href="detail.jsp"><img src="${pageContext.request.contextPath}/images/goods/goods003.jpg"></a>
					<h4><a href="detail.jsp">大兴大棚草莓</a></h4>
					<div class="operate">
						<span class="prize">￥16.80</span>
						<span class="unit">16.80/500g</span>
						<a href="#" class="add_goods" title="加入购物车"></a>
					</div>
				</li>
			</ul>

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
		<p>CopyRight © 2016 北京天天生鲜信息技术有限公司 All Rights Reserved</p>
		<p>电话：010-****888    京ICP备*******8号</p>
	</div>
	
</body>
</html>