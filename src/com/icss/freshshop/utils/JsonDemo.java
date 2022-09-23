package com.icss.freshshop.utils;

import com.alibaba.fastjson.JSONObject;
import com.icss.freshshop.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/23/023 10:23
 * @Description :
 */
public class JsonDemo {
    public static void main(String[] args) {
        String username ="zhangsan";
        int age = 18;
        boolean result = false;
        double price = 10;
        JSONObject obj = new JSONObject() ;
        obj. put("String" , username);
        obj.put("int",age);
        obj. put("boolean" ,result);
        obj. put("double" , price);
        UserEntity u1 = new UserEntity();
        u1.setUsername("zhangsan");
        UserEntity u2 = new UserEntity();
        u2.setUsername("lisi");
        List<UserEntity> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        //实体对象转json
        obj.put("object",u1);
        obj.put("list",users);
    }

}
