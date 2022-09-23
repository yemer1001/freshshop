package com.icss.freshshop.dao.impl;

import com.icss.freshshop.dao.ICartDao;
import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.utils.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/23/023 14:41
 * @Description :
 */
public class CartDaoImpl extends JdbcUtils implements ICartDao {
    @Override
    public int findCart(String goodsid, int userid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "select cartid from t_cart where userid = ? and goodsid=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,userid);
            pst.setInt(2,Integer.parseInt(goodsid));
            rs = pst.executeQuery();
            return rs.next()==true? rs.getInt(1) :0 ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn(conn,pst,rs);
        }
        return 0;
    }

    @Override
    public void updateCart(int cartid) {
        PreparedStatement pst = null;
        try {
            openConn();
            String sql = "update t_cart set count = count + 1 where cartid =?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,cartid);
            pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnect(pst);
        }
    }

    @Override
    public void insertCart(String goodsid, int userid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "insert into t_cart values (null,?,?,1,now())";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,userid);
            pst.setInt(2,Integer.parseInt(goodsid));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn(conn,pst);
        }
    }
}
