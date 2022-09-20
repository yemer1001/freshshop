package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/20/020 15:42
 * @Description :
 */

import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.service.IGoodsService;
import com.icss.freshshop.service.impl.GoodsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindIndexInfoServlet", value = "/FindIndexInfoServlet")
public class FindIndexInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IGoodsService service = new GoodsServiceImpl();
        for (int i = 0; i < 6; i++) {
            List<GoodsEntity> goods = service.findGoodsByCategoryId(i);
            //把数据保存到请求属性中
            request.setAttribute("goods"+i,goods);
        }
        //请求转发到index.jsp
        request.getRequestDispatcher("user/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
