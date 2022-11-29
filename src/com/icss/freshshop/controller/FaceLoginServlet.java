package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/5/005 15:11
 * @Description :
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icss.freshshop.entity.UserEntity;
import com.icss.freshshop.service.IUserService;
import com.icss.freshshop.service.impl.UserServiceImpl;
import com.icss.freshshop.utils.FaceUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FaceLoginServlet", value = "/FaceLoginServlet")
public class FaceLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String img = request.getParameter("base");
        String groupIdList = "face_login";
        String resp = FaceUtil.faceLogin(img,groupIdList);

        JSONObject jsonObject = JSONObject.parseObject(resp);
        String msg = jsonObject.get("error_msg").toString();
        JSONObject resultObj = new JSONObject();
        if ("SUCCESS".equals(msg)){
            JSONObject result = jsonObject.getJSONObject("result");
            JSONArray userList = result.getJSONArray("user_list");
            JSONObject info = userList.getJSONObject(0);
            int userid = Integer.parseInt(info.getString("user_id"));
            IUserService service = new UserServiceImpl();
            UserEntity user = service.findUserById(userid);
            request.getSession().setAttribute("USER",user);
            resultObj.put("result","SUCCESS");
            resultObj.put("role",user.getRole());
        }else {
            resultObj.put("result","FAIL");
        }
        response.getWriter().print(resultObj);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
