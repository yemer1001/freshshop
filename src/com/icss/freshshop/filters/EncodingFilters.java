package com.icss.freshshop.filters;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/26/026 17:00
 * @Description :
 */
@WebFilter(filterName = "EncodingFilters",urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "version",value = "2.0")})
public class EncodingFilters implements Filter {
    public void init(FilterConfig config) throws ServletException{
        String filterName = config.getFilterName();
        System.out.println("过滤器名："+filterName);
        String version = config.getInitParameter("version");
        System.out.println("版本号："+version);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(request,response);
    }
    public void destroy(){
    }
}
