package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/26/026 15:11
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TestListenerServlet", value = "/TestListenerServlet")
public class TestListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = getServletContext();
        application.setAttribute("count",1);
        application.removeAttribute("count");

        request.setAttribute("userid",001);
        request.removeAttribute("userid");

        HttpSession session = request.getSession();
        session.setAttribute("username","zhangsan");
        session.setAttribute("username","tom");
        session.removeAttribute("username");

        session.invalidate();//销毁对象
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
