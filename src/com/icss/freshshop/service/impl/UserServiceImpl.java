package com.icss.freshshop.service.impl;

import com.icss.freshshop.dao.IUserDao;
import com.icss.freshshop.dao.impl.UserDaoImpl;
import com.icss.freshshop.entity.UserEntity;
import com.icss.freshshop.service.IUserService;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/19/019 14:17
 * @Description :
 */
public class UserServiceImpl implements IUserService {
    //创建dao层对象
    IUserDao dao = new UserDaoImpl();
    @Override
    public UserEntity login(String userName, String pwd) {
        UserEntity user = dao.login(userName,pwd);
        return user;
    }
}
