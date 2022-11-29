package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/29/029 14:49
 * @Description :
 */

import com.icss.freshshop.entity.RecipientEntity;
import com.icss.freshshop.entity.UserEntity;
import com.icss.freshshop.service.ICartService;
import com.icss.freshshop.service.impl.CartServiceImpl;
import com.icss.freshshop.vo.CartVo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartController", value = "/cart/*")
public class CartController extends HttpServlet {
    ICartService service = new CartServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        String[]str = path.split("/");
        String p = str[str.length-1];

        if (p!=null && p.equals("findMyCart.do")){
            findMyCart(req,resp);
        }else if (p!=null && p.equals("updateCart.do")){
            updateCart(req,resp);
        }else if (p!=null && p.equals("delCart.do")){
            delCart(req,resp);
        }else if (p!=null && p.equals("checkOut.do")){
            checkOut(req,resp);
        }
    }

    //购物车结算
    protected void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收页面参数  goodsids
        String[] goodsids = request.getParameterValues("goodsids");
        //2.从session中获取userid
        int userid = ((UserEntity)request.getSession().getAttribute("USER")).getUserid();
        //3.查看我的账户下的所有收货地址  参数：userid  返回值：List<RecipientEntity>
        List<RecipientEntity> recps = service.findAllRecipient(userid);
        //4.查询所有选中的商品列表 参数:goodsids[] 返回值:List<CartVo>
        List<CartVo> carts = service.findSelectedGoods(goodsids,userid);
        //5.根据商品列表，计算总金额和总件数
        double totalPrice = 0;
        int totalCount = 0;
        for (CartVo c : carts){
            totalPrice+=c.getPrice()*c.getCount();
            totalCount+=c.getCount();
        }
        //6.把数据保存到请求属性中
        request.setAttribute("recps",recps);
        request.setAttribute("carts",carts);
        request.setAttribute("totalPrice",totalPrice);
        request.setAttribute("totalCount",totalCount);
        //7.请求转发到place_order.jsp
        request.getRequestDispatcher("/user/place_order.jsp").forward(request,response);
    }


    //查询我的购物车
    protected void findMyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = ((UserEntity)request.getSession().getAttribute("USER")).getUserid();
        List<CartVo> carts = service.findMyCart(userid);
        request.setAttribute("carts",carts);
        request.getRequestDispatcher("/user/cart.jsp").forward(request,response);
    }

    //修改购物车数量
    private void updateCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        String cartid = request.getParameter("cartid");
        boolean res = service.updateCart(type,cartid);
        response.getWriter().print(res);
    }
    //删除购物车
    private void delCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cartid = request.getParameter("cartid");
        boolean res = service.delCart(cartid);
        response.getWriter().print(res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
