package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/26/026 10:22
 * @Description :
 */

import com.alibaba.fastjson.JSONObject;
import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.service.IGoodsService;
import com.icss.freshshop.service.impl.GoodsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindMoreGoodsServlet", value = "/FindMoreGoodsServlet")
public class FindMoreGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryid = request.getParameter("categoryid");
        request.setCharacterEncoding("utf-8");
        response.setContentType("html/text;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        IGoodsService service = new GoodsServiceImpl();
        List<GoodsEntity> lists = service.findMoreGoods(categoryid);
        JSONObject obj = new JSONObject();
        obj.put("lists",lists);
        response.getWriter().println(obj);
    }
}
