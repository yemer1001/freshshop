<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

	<head>
		<title></title>
		<meta charset="utf-8">
		<link href="${pageContext.request.contextPath}/css/admin_main.css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
		<style>
			.b10 {
				width: 10%;
			}
			
			.b60 {
				width: 25%;
			}
		</style>
	</head>

	<body>
		<!-- 商品管理 -->
		<div class="AccountManagement_c" id="ColumnManagement_c">
			<h3>商品管理 
                    <div class="amcl fr">
                       <form id="searchform" action="" method="post">
                        <input type="text" placeholder="商品名" class="fl" name="goodsname"  value="">
                        <div class="search fl" onclick="seach()" ><img src="${pageContext.request.contextPath}/images/search.png"></div>
                       </form>
                    </div> 
                </h3>

			<div class="AM_ct text_center">
				<div class="AM_ct_in">
					<a href="${pageContext.request.contextPath}/admin/goodsadd.jsp">
						<div class="add_btn df_btn fl" id="add_column_btn">添加</div>
					</a>
				</div>
			</div>

			<div class="list">
				<ul class="list_h">
					<li class="b10"><label><input type="checkbox" name="newsId"><span>序号</span></label></li>
					<li class="b20"><label>商品名称</label></li>
					<li class="b20"><label>单价</label></li>
					<li class="b20"><label>单位</label></li>
					<li class="b20"><label>类型</label></li>
					<li class="b60"><label>操作</label></li>
				</ul>
				<div class="list_b_c">
					<c:forEach var="g" varStatus="num" items="${page.lists}">
					<ul class="list_b">
						<li class="b10"><label><input type="checkbox" name="">
							<span>${num.count}</span></label></li>
						<li class="b20"><label>${g.goodsname}</label></li>
						<li class="b20"><label>${g.price}</label></li>
						<li class="b20"><label>${g.unit}</label></li>
						<li class="b20"><label>${g.categoryname}</label></li>
						<li class="b60">
							<a href="goodsedit.html">
								<div class="edit_btn df_btn fl text_center">编辑</div>
							</a>
							<a href="goodsdetail.html">
								<div class="edit_btn df_btn fl text_center">详情</div>
							</a>
							<a href="javascript:;">
								<div class="delete_btn df_btn fl text_center">删除</div>
							</a>
						</li>
					</ul>
					</c:forEach>
				</div>

				<div class="pull_page">
					<div class="fl pull_page_up">当前第${page.currentPage}页，
						一共${page.totalCount}条数据，一共${page.totalPage}页</div>
					<div class="fl pull_page_up" onclick="location.href='${pageContext.request.contextPath}/goods/findAllGoods.do?currentPage=1'">首页</div>
					<c:if test="${page.currentPage != 1}">
					<div class="fl pull_page_up" onclick="location.href='${pageContext.request.contextPath}/goods/findAllGoods.do?currentPage=${page.currentPage-1}'">上一页</div>
					</c:if>
					<c:if test="${page.currentPage != page.totalPage}">
					<div class="fl pull_page_up" onclick="location.href='${pageContext.request.contextPath}/goods/findAllGoods.do?currentPage=${page.currentPage+1}'">下一页</div>
					</c:if>
					<div class="fl pull_page_up" onclick="location.href='${pageContext.request.contextPath}/goods/findAllGoods.do?currentPage=${page.totalPage}'">末页</div>
				</div>
	</body>

</html>