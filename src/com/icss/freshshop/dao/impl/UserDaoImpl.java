package com.icss.freshshop.dao.impl;

import com.icss.freshshop.dao.IUserDao;
import com.icss.freshshop.entity.UserEntity;
import com.icss.freshshop.utils.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

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

    @Override
    public boolean register(Map<String, String[]> maps) {
        PreparedStatement pst = null;
        try {
            openConn();
            String sql = "insert into t_user (username,password,email,role) values(?,?,?,1)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,maps.get("user_name")[0]);
            pst.setString(2,maps.get("pwd")[0]);
            pst.setString(3,maps.get("email")[0]);
            int res = pst.executeUpdate();
            return res>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnect(pst);
        }
        return false;
    }

    @Override
    public boolean checkUserName(String userName) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "select userid from t_user where username = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,userName);
            rs = pst.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConn(conn,pst,rs);
        }
        return false;
    }
}
