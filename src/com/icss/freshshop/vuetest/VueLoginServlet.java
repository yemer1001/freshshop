package com.icss.freshshop.vuetest; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/10/010 17:27
 * @Description :
 */

import com.alibaba.fastjson.JSONObject;
import com.icss.freshshop.entity.UserEntity;
import com.icss.freshshop.service.IUserService;
import com.icss.freshshop.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VueLoginServlet", value = "/VueLoginServlet")
public class VueLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受页面数据
        String userName = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        IUserService service = new UserServiceImpl();
        //调用service中登录的方法，类型entity
        UserEntity user = service.login(userName,pwd);
        //判断是否登录成功
            response.getWriter().print(user==null?false:true);


    }
}
