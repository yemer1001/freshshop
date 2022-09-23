package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/23/023 14:40
 * @Description :
 */

import com.alibaba.fastjson.JSONObject;
import com.icss.freshshop.entity.UserEntity;
import com.icss.freshshop.service.ICartService;
import com.icss.freshshop.service.impl.CartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCartServlet", value = "/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsid = request.getParameter("goodsid");
        HttpSession session = request.getSession();
        int userid = ((UserEntity)session.getAttribute("USER")).getUserid();
        ICartService service = new CartServiceImpl();
        boolean res = service.addCart(goodsid,userid);
        JSONObject obj = new JSONObject();
        obj.put("result",res);
        response.getWriter().println(obj);
      }
}
