package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/5/005 14:37
 * @Description :
 */

import com.alibaba.fastjson.JSONObject;
import com.icss.freshshop.entity.UserEntity;
import com.icss.freshshop.service.IUserService;
import com.icss.freshshop.service.impl.UserServiceImpl;
import com.icss.freshshop.utils.FaceUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FaceRegisterServlet", value = "/FaceRegisterServlet")
public class FaceRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String img = request.getParameter("base");
        UserEntity user = (UserEntity) request.getSession().getAttribute("USER");
        String resp = FaceUtil.faceRegister(img,user.getUsername(),user.getUserid()+"","face_login");
        //解析结果
        JSONObject jsonObject = JSONObject.parseObject(resp);
        String msg = jsonObject.get("error_msg").toString();
        boolean res  = false;
        if ("SUCCESS".equals(msg)){
            IUserService service = new UserServiceImpl();
            service.updateIsFace(user.getUserid(),"y");
            res = true;
        }
        response.getWriter().print(res);
    }
}
