<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-提交订单</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
	<div class="header_con">
		<%@include file="header.jsp"%>
	</div>

	<div class="search_bar clearfix">
		<a href="index.jsp" class="logo fl"><img src="${pageContext.request.contextPath}/images/logo.png"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;提交订单</div>
		<div class="search_con fr">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>		
	</div>
	<form action="${pageContext.request.contextPath}/order/submitOrder.do" method="post">
	<h3 class="common_title">确认收货地址</h3>

	<div class="common_list_con clearfix">
		<dl>
			<dt>寄送到：</dt>
			<c:forEach var="r" items="${recps}">
			<dd>
				<input type="radio" name="recipientid" checked="" value="${r.recipientid}">
				${r.address} (${r.recipientname} 收) ${r.phone}
			</dd>
			</c:forEach>
		</dl>
		<a href="user_center_site.html" class="edit_site">编辑收货地址</a>

	</div>
	
	<h3 class="common_title">支付方式</h3>	
	<div class="common_list_con clearfix">
		<div class="pay_style_con clearfix">
			<input type="radio" name="pay_style" value="1" checked>
			<label class="cash">货到付款</label>
			<input type="radio" name="pay_style" value="2">
			<label class="weixin">微信支付</label>
			<input type="radio" name="pay_style" value="3">
			<label class="zhifubao"></label>
			<input type="radio" name="pay_style" value="4">
			<label class="bank">银行卡支付</label>
		</div>
	</div>

	<h3 class="common_title">商品列表</h3>
	
	<div class="common_list_con clearfix">
		<ul class="goods_list_th clearfix">
			<li class="col01">商品名称</li>
			<li class="col02">商品单位</li>
			<li class="col03">商品价格</li>
			<li class="col04">数量</li>
			<li class="col05">小计</li>		
		</ul>
		<c:forEach var="c" varStatus="num" items="${carts}">
		<ul class="goods_list_td clearfix">
			<li class="col01">${num.count}</li>
			<li class="col02"><img src="${cookie.imgpath}"></li>
			<li class="col03">${c.goodsname}</li>
			<li class="col04">${c.unit}</li>
			<li class="col05">${c.price}元</li>
			<li class="col06">${c.count}</li>
			<li class="col07">${c.count*c.price}元</li>

			<input type="hidden" name="goodsids" value="${c.goodsid}"/>
			<input type="hidden" name="prices" value="${c.price}"/>
			<input type="hidden" name="counts" value="${c.count}"/>
		</ul>
	</c:forEach>
	</div>

	<h3 class="common_title">总金额结算</h3>

	<div class="common_list_con clearfix">
		<div class="settle_con">
			<div class="total_goods_count">共<em>${totalCount}</em>件商品，总金额<b>${totalPrice}元</b></div>
			<div class="transit">运费：<b>10元</b></div>
			<div class="total_pay">实付款：<b>${totalPrice+10}元</b></div>
			<input type="hidden" name="totalPrice" value="${totalPrice}">
		</div>
	</div>

	<div class="order_submit clearfix">
		<input type="submit" value="提交表单">
	</div>	
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
		<p>CopyRight © 2020北京天天生鲜信息技术有限公司 All Rights Reserved</p>
		<p>电话：010-****888    京ICP备*******8号</p>
	</div>

	<div class="popup_con">
		<div class="popup">
			<p>订单提交成功！</p>
		</div>
		
		<div class="mask"></div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.2.js"></script>
	<script type="text/javascript">
		$('#order_btn').click(function() {
			localStorage.setItem('order_finish',2);

			$('.popup_con').fadeIn('fast', function() {

				setTimeout(function(){
					$('.popup_con').fadeOut('fast',function(){
						window.location.href = 'index.html';
					});	
				},3000)
				
			});
		});
	</script>
</body>
</html>