package com.icss.freshshop.dao.impl;

import com.icss.freshshop.dao.IUserDao;
import com.icss.freshshop.entity.UserEntity;
import com.icss.freshshop.utils.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/19/019 14:05
 * @Description :
 */
public class UserDaoImpl extends JdbcUtils implements IUserDao {
    @Override
    public UserEntity login(String userName, String pwd) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "select * from t_user where username = ? and password = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,userName);
            pst.setString(2,pwd);
            rs = pst.executeQuery();

            UserEntity user = null;
            while (rs.next()){
                //
                user = new UserEntity();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getInt("role"));
                user.setStatus(rs.getInt("status"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnect(pst,rs);
        }
        return null;
    }


}
