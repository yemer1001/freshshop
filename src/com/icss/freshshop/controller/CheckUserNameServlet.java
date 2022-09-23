package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/23/023 14:01
 * @Description :
 */

import com.alibaba.fastjson.JSONObject;
import com.icss.freshshop.service.IUserService;
import com.icss.freshshop.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckUserNameServlet", value = "/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        IUserService service = new UserServiceImpl();
        boolean result = service.checkUserName(userName);
        JSONObject obj = new JSONObject();
        obj.put("result",result);
        response.getWriter().println(obj);
    }
}
