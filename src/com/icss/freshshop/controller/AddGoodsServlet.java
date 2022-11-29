package com.icss.freshshop.controller; /**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/28/028 19:55
 * @Description :
 */

import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.service.IGoodsService;
import com.icss.freshshop.service.impl.GoodsServiceImpl;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddGoodsServlet", value = "/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        SmartUpload smu = new SmartUpload();
        smu.setCharset("utf-8");
        smu.initialize(this.getServletConfig(),request,response);//初始化组件
        try {
            smu.upload();//上传
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Files files = smu.getFiles();//获取上传文件的列表
        File file = files.getFile(0);//获取第一个文件
        String imgpath = "";
        if (files.getSize()>0&&file.getSize()>0){
            try {
                file.saveAs("E:\\upload\\goods"+file.getFieldName());
            } catch (SmartUploadException e) {
                e.printStackTrace();
            }
            imgpath = "/upload/goods/"+file.getFileName();
        }
        String goodsname = smu.getRequest().getParameter("goodsname");
        String price = smu.getRequest().getParameter("price");
        String categoryid = smu.getRequest().getParameter("categoryid");
        String unit = smu.getRequest().getParameter("unit");
        String goodsinfo = smu.getRequest().getParameter("goodsinfo");
        String stock = smu.getRequest().getParameter("stock");
        GoodsEntity goods = new GoodsEntity(Integer.parseInt(categoryid),goodsname,
                Double.parseDouble(price),unit,goodsinfo,Integer.parseInt(stock),imgpath);
        IGoodsService service = new GoodsServiceImpl();
        boolean res = service.addGoods(goods);
        response.getWriter().print(res==true?"商品添加成功":"商品添加失败");
    }
}
