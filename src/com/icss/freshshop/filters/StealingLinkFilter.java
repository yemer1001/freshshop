package com.icss.freshshop.filters; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/29/029 10:41
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "StealingLinkFilter")
public class StealingLinkFilter implements Filter {
    private List<String> urls ;  //存放的是不需要过滤的资源
    public void init(FilterConfig config) throws ServletException {
        urls = new ArrayList<>();
        urls.add("/user/login.jsp");
        System.out.println("StealingLinkFilter---init");
    }
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //1.获取请求和响应的对象
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse rep = (HttpServletResponse)response;

        //2.判断访问路径是否需要过滤  不需要-放行  需要-继续判断
        if (urls.contains(req.getServletPath())){
            chain.doFilter(request, response);
        }else {
            //2.获取项目路径
            String path = req.getContextPath();
            //3.获取本站截至到context root的域名信息
            String basePath = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + path + "/";
            System.out.println(basePath);   //http://localhost:8080/FreshShop_war_exploded/
            //4. 获取上一个页面的地址
            String fromUrl = req.getHeader("referer");

            //5.判定是否外站请求并返回结果   true--是本站请求  false--不是本站请求
            boolean res = fromUrl != null && fromUrl.startsWith(basePath) ? true : false;

            //6.是--放行  不是--跳转到指定资源
            if (res) {
                chain.doFilter(request, response);
            } else {
                rep.sendRedirect(path + "/error/visit.jsp");
            }
        }
    }
}
