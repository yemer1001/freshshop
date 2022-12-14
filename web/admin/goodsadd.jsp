<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<title></title>
		<meta charset="utf-8">
		<link href="${pageContext.request.contextPath}/css/admin_main.css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script type="text/javascript">
			/* 点击按钮 ，添加图片选择框 */
			function addImg() {
				var input = $("#img input"); //获取id为img的div标签下所有的input对象
				var index = input.length - 1; //最后一个input对象的索引
				var html = "<div class='news_title'> <label class='text_center'>图片</label>" + "<input type='file' placeholder='选择图片' name='imgpath" + index + "'></div>";
				$("#img").append(html); //在img的div下追加图片选择框
			}
		</script>
		<script>
			$(function (){
				$.ajax({
					url:"${pageContext.request.contextPath}/FindAllCategoryServlet",
					type:"get",
					dataType:"json",
					success:function (msg){
						let lists = msg.categories;
						let html = "";
						for (let c of lists){
							html+="<option value='"+c.categoryid+"'>"+c.categoryname+"</option>";
						}
						$("select[name='categoryid']").empty().html(html);
					}
				})
			});
		</script>
	</head>

	<body>
		<!-- 商品管理 -->
		<div class="AccountManagement_c" id="NewsManagement_c">
			<h3>商品管理</h3>
			<div class="list" id="release_news" style="overflow: visible;">
				<ul class="list_h">
					<li class="b80"><label>添加商品</label></li>
				</ul>
				<form id="infoform" action="${pageContext.request.contextPath}/AddGoodsServlet" method="post" enctype="multipart/form-data">
					<div class="list_b_c" id="release_news_in">
						<div class="release_news">
							<div class="news_title">
								<label class="text_center">名字</label> <input type="text" placeholder="填写商品名" name="goodsname">
							</div>
							<br>
							<div class="news_title">
								<label class="text_center">单价</label> <input type="text" placeholder="填写单价" name="price">
							</div>
							<div class="column_name">
								<label class="text_center">类型</label>
								<select name="categoryid" class="column_name_release">
							   <option value="">新鲜水果</option>
							</select>
							</div>
							<br>
							<div class="news_title">
								<label class="text_center">单位</label> <input type="text" placeholder="填写单位" name="unit">
							</div>
							<br>
							<div class="news_title">
								<label class="text_center">商品描述</label> <input type="text" placeholder="填写商品描述" name="goodsinfo">
							</div>
							<br>
							<div class="news_title">
								<label class="text_center">库存</label> <input type="text" placeholder="填写单库存" name="stock">
							</div>
							<br>
							<div id="img">
								<!--点击+ 追加一个图片的选择框  -->
								<button type="button" onclick="addImg()">+</button>
								<div class="news_title">
									<label class="text_center">图片</label>
									<input type="file" placeholder="选择图片" name="imgpath">
								</div>
							</div>

							<div class="release_news_ok_btn text_center">
								<input type="submit" value="保存">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>

</html>