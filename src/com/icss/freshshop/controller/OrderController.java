package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/3/003 15:55
 * @Description :
 */

import com.icss.freshshop.entity.OrderDto;
import com.icss.freshshop.entity.UserEntity;
import com.icss.freshshop.service.IOrderService;
import com.icss.freshshop.service.impl.OrderServiceImpl;
import com.icss.freshshop.vo.OrderVo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderController", value = "/order/*")
public class OrderController extends HttpServlet {
    IOrderService service = new OrderServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        String[] str = path.split("/");
        String p = str[str.length-1];
        if (p!=null && p.equals("submitOrder.do")){
            submitOrder(req,resp);
        }else if (p!=null && p.equals("findMyOrder.do")){
            findMyOrder(req,resp);
        }
    }

    private void findMyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = ((UserEntity)request.getSession().getAttribute("USER")).getUserid();
        List<OrderVo> orders = service.findMyOrder(userid);
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/user/user_center_order.jsp").forward(request,response);
    }

    //提交订单
    protected void submitOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String totalPrice = request.getParameter("totalPrice");
        String recipientid = request.getParameter("recipientid");
        String pay_style = request.getParameter("pay_style");
        String [] goodsids = request.getParameterValues("pay_style");
        String [] prices = request.getParameterValues("prices");
        String [] counts = request.getParameterValues("counts");

        int userId = ((UserEntity)request.getSession().getAttribute("User")).getUserid();
        OrderDto orderDto = new OrderDto(Double.parseDouble(totalPrice),
                Integer.parseInt(recipientid),Integer.parseInt(pay_style),
                goodsids,prices,counts,userId);
        boolean res = service.submitOrder(orderDto);
        request.setAttribute("res",res);
        request.getRequestDispatcher("/user/order_result.jsp").forward(request,response);
    }
}
