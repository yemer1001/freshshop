package com.icss.freshshop.dao;

import com.icss.freshshop.entity.UserEntity;

import java.util.Map;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/19/019 14:12
 * @Description :
 */
public interface IUserDao {
    UserEntity login(String userName, String pwd);

    boolean register(Map<String, String[]> maps);

    boolean checkUserName(String userName);

    void updateIsFace(int userid, String y);

    UserEntity findUserById(int userid);
}
