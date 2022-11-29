package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/28/028 19:24
 * @Description :
 */

import com.alibaba.fastjson.JSONObject;
import com.icss.freshshop.entity.CategoryEntity;
import com.icss.freshshop.service.IGoodsService;
import com.icss.freshshop.service.impl.GoodsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllCategoryServlet", value = "/FindAllCategoryServlet")
public class FindAllCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IGoodsService service = new GoodsServiceImpl();
        List<CategoryEntity> categories = service.findAllCategory();
        JSONObject obj = new JSONObject();
        obj.put("categories",categories);
        response.getWriter().print(obj);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
