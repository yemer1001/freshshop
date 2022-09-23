package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/23/023 13:43
 * @Description :
 */

import com.alibaba.fastjson.JSONObject;
import com.icss.freshshop.service.IUserService;
import com.icss.freshshop.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> maps = request.getParameterMap();
        IUserService service = new UserServiceImpl();
        boolean res = service.register(maps);
        JSONObject obj = new JSONObject();
        obj.put("result",res);
        response.getWriter().println(obj);
    }
}
