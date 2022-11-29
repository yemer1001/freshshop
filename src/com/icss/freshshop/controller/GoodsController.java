package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/29/029 13:48
 * @Description :
 */

import com.icss.freshshop.service.IGoodsService;
import com.icss.freshshop.service.impl.GoodsServiceImpl;
import com.icss.freshshop.vo.GoodsVo;
import com.icss.freshshop.vo.PageResultVo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GoodsServlet", value = "/goods/*")
public class GoodsController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String path = req.getRequestURI();
        String[] paths = path.split("/");
        String p = paths[paths.length-1];

        if (p!=null && p.equals("findAllGoods.do")){
            findAllGoods(req,rep);
        }else if (p!=null && p.equals("delGoods.do")){
            delGoods(req,rep);
        }
    }
    //分页查看所有商品
    protected void findAllGoods(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //接受页面参数
        String currentPage = request.getParameter("currentPage");
        //创建对象
        PageResultVo<GoodsVo> page = new PageResultVo<>();
        page.setCurrentPage(Integer.parseInt(currentPage));
        IGoodsService service = new GoodsServiceImpl();
        service.findAllGoodsPage(page);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/admin/goodslist.jsp").forward(request,response);
    }
    //删除商品的方法
    protected void delGoods(HttpServletRequest request,HttpServletResponse response){
        System.out.println("========删除商品的方法=======");
    }
}
