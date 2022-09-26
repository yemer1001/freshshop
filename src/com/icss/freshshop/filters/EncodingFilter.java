package com.icss.freshshop.filters; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/26/026 19:26
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",urlPatterns = {"/*"})
public class EncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        req.setCharacterEncoding("utf-8");
        rep.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }
}
