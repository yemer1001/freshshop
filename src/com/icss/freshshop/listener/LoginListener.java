package com.icss.freshshop.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.io.*;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/26/026 14:09
 * @Description :
 */
@WebListener
public class LoginListener implements ServletContextListener, HttpSessionListener,
        HttpSessionAttributeListener, ServletContextAttributeListener, ServletRequestAttributeListener {
    public LoginListener(){
        System.out.println("执行监听器构造方法");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("启动服务");
        //获取上下文对象
        ServletContext application = sce.getServletContext();
        //通过上下文属性访问部署路径
        String realPath = application.getRealPath("/");
        System.out.println(realPath);
        //创建File对象
        File path = new File(realPath+"/visit.txt");
        int count = 0;
        long len = path.length();
        if (len>0){
            BufferedReader br = null;
            String line = null;
            try {
                br = new BufferedReader(new FileReader(path));
                line = br.readLine();
                count = Integer.parseInt(line);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        application.setAttribute("count",count);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("停止服务");
        //获取上下文
        ServletContext application = sce.getServletContext();
        //从上下文对象中获取count
        Integer count = (Integer)application.getAttribute("count");
        String realPath = application.getRealPath("/");
        System.out.println(realPath);

        File path = new File(realPath+"/visit.txt");

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            bw.write(count.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   /* @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session对象被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session对象被销毁");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("向session中添加属性");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("向session对象中移除属性");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("向session对象中覆盖属性");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("上下文对象添加属性");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("上下文对象移除属性");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("请求对象添加属性");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("请求对象中移除属性");
    }*/
}
