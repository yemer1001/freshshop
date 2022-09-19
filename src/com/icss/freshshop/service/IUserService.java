package com.icss.freshshop.service;

import com.icss.freshshop.entity.UserEntity;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/19/019 15:29
 * @Description :
 */
public interface IUserService {
    UserEntity login(String userName, String pwd);
}
