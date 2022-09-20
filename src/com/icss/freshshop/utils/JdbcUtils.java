package com.icss.freshshop.utils;

import java.sql.*;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/7/007 15:10
 * @Description :
 */
public class JdbcUtils {
    protected Connection conn;
    public void openConn() throws Exception {
        if(conn == null || conn.isClosed()){
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/freshshop?serverTimezone=UTC";
            String userName = "root";
            String pwd = "123456";
            conn = DriverManager.getConnection(url,userName,pwd);
        }
    }
    public void closeConn(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeConn(Connection conn,PreparedStatement pst){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeConn(Connection conn, PreparedStatement pst, ResultSet rs){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    protected void closeConnect(PreparedStatement pst, ResultSet rs) {
        if (pst != null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void beginTransaction() throws Exception {
        openConn();
        conn.setAutoCommit(false);
    }
    public void commit(){
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void rollback(){
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
