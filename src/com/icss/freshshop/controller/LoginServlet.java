package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/19/019 14:03
 * @Description :
 */

import com.icss.freshshop.entity.UserEntity;
import com.icss.freshshop.service.IUserService;
import com.icss.freshshop.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受页面数据
        String userName = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        //调用model,处理数据
        //创建service对象
        IUserService service = new UserServiceImpl();
        //调用service中登录的方法，类型entity
        UserEntity user = service.login(userName,pwd);
        //判断是否登录成功
        if (user != null){
           /* Cookie userNamecookie = new Cookie("username",user.getUsername());
            Cookie passwordcookie = new Cookie("password",user.getPassword());
            userNamecookie.setMaxAge(7*24*60*60);
            passwordcookie.setMaxAge(7*24*60*60);
            response.addCookie(userNamecookie);
            response.addCookie(passwordcookie);*/

            HttpSession session = request.getSession();
            session.setAttribute("USER",user);

            ServletContext application = this.getServletContext();
            Integer count = (Integer)application.getAttribute("count");
            if (count==null){
                application.setAttribute("count",1);
            }else {
                application.setAttribute("count",count+1);
            }

            response.sendRedirect("welcome.jsp");
        }else {
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("user/login.jsp").forward(request,response);
        }
    }
}
