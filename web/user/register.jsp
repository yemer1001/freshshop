<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>天天生鲜-注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body>
<div class="register_con">
    <div class="l_con fl">
        <a class="reg_logo"><img src="${pageContext.request.contextPath}/images/logo02.png"></a>
        <div class="reg_slogan">足不出户 · 新鲜每一天</div>
        <div class="reg_banner"></div>
    </div>

    <div class="r_con fr">
        <div class="reg_title clearfix">
            <h1>用户注册</h1>
            <a href="#">登录</a>
        </div>
        <div class="reg_form clearfix">
            <form id="form01">
                <ul>
                    <li>
                        <label>用户名:</label>
                        <input type="text" name="user_name" id="user_name">
                        <span ></span>
                    </li>
                    <li>
                        <label>密码:</label>
                        <input type="password" name="pwd" id="pwd">
                        <span ></span>
                    </li>
                    <li>
                        <label>确认密码:</label>
                        <input type="password" name="cpwd" id="cpwd">
                        <span ></span>
                    </li>
                    <li>
                        <label>邮箱:</label>
                        <input type="text" name="email" id="email">
                        <span ></span>
                    </li>
                    <li class="agreement">
                        <input type="checkbox" name="allow" id="allow" checked="checked">
                        <label>同意”天天生鲜用户使用协议“</label>
                        <span class="error_tip2">提示信息</span>
                    </li>
                    <li class="reg_sub">
                        <input type="button" value="注 册" name="">
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
<div class="footer no-mp">
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
    <p>电话：010-****888 京ICP备*******8号</p>
</div>
<script>
    $(function(){
        $("#user_name").blur(function (){
            $.ajax({
                type: "post",
                url: "../CheckUserNameServlet",
                data: {"username": $("#user_name").val()},
                dataType: "json",
                success: function (msg) {
                    if (msg.result) {
                        $("#user_name").
                        next().css("color", "red").text("用户名被占用");
                    } else {
                        $("#user_name").
                        next().css("color", "green").text("用户名校验通过");
                    }
                },
                error: function () {
                    alert("网络访问失败");
                }
            });
        });
        //注册功能
        $("input[type='button']").click(function () {
            let $data = $("#form01").serialize();
            console.log($data);
            $.ajax({
                type: "post",
                url: "../RegisterServlet",
                data: $data,
                dataType: "json",
                success: function (msg) {
                    if (msg.result) {
                        let res = confirm("注册成功，跳转到登录页面");
                        if (res) {
                            window.location.href = 'login.jsp';
                        }
                    } else {
                        alert("注册失败")
                    }
                },
                error: function () {
                    alert("网络访问失败");
                }
            });
        });
    });
</script>
</body>
</html>