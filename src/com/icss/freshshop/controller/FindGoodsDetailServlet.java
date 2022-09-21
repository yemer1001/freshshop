package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/21/021 15:19
 * @Description :
 */

import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.service.IGoodsService;
import com.icss.freshshop.service.impl.GoodsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FindGoodsDetailServlet", value = "/FindGoodsDetailServlet")
public class FindGoodsDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsid = request.getParameter("goodsid");
        IGoodsService service = new GoodsServiceImpl();
        GoodsEntity goods = service.findGoodsDetail(goodsid);
        request.setAttribute("goods",goods);
        request.getRequestDispatcher("user/detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
