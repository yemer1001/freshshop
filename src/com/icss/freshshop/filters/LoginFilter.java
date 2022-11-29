package com.icss.freshshop.filters; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/28/028 09:46
 * @Description :
 */

import com.icss.freshshop.entity.UserEntity;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/*"},
        initParams = {@WebInitParam(name="version",value = "2.0")},
        dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST,
        DispatcherType.ERROR,DispatcherType.INCLUDE})
public class LoginFilter implements Filter {
    private List<String> urls;
    public void init(FilterConfig config) throws ServletException {
        urls = new ArrayList<>();
        urls.add("/user/login.jsp");
        urls.add("/user/register.jsp");
        urls.add("/welcome.jsp");
        urls.add("/user/index.jsp");
        urls.add("/user/list.jsp");
        urls.add("/user/detail.jsp");
        urls.add("/user/header.jsp");
        urls.add("/CheckUserNameServlet");
        urls.add("/FindGoodsDetailServlet");
        urls.add("/FindIndexInfoServlet");
        urls.add("/FindMoreGoodsServlet");
        urls.add("/LoginServlet");
        urls.add("/RegisterServlet");
        urls.add("/error/visit.jsp");
        urls.add("user/face_login.jsp");
        urls.add("/FaceLoginServlet");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //获取请求和响应数据
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse rep = (HttpServletResponse)response;
        //获取访问路径
        String path = req.getServletPath();
        //获取项目路径
        String base = req.getContextPath();
        System.out.println(path+"----"+base);
        //获取session对象
        HttpSession session = req.getSession();
        //从session中获取用户信息
        UserEntity user = (UserEntity)session.getAttribute("USER");
        //判断是否是需要过滤的资源
        if (!urls.contains(path)&&!path.endsWith(".js")
            &&!path.endsWith(".css")
            &&!path.endsWith(".jpg")&&!path.endsWith(".png")){
            if (user==null){
                rep.sendRedirect(base+"/user/login.jsp");
            }else {
                chain.doFilter(request, response);
            }
        }else {
            chain.doFilter(request, response);
        }
    }
}
