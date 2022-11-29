package com.icss.freshshop.dao.impl;

import com.icss.freshshop.dao.ICartDao;
import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.entity.RecipientEntity;
import com.icss.freshshop.utils.JdbcUtils;
import com.icss.freshshop.vo.CartVo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        try {
            openConn();
            String sql = "insert into t_cart values(null,?,?,1,now())";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,userid);
            pst.setInt(2,Integer.parseInt(goodsid));
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn(conn,pst);
        }
    }

    @Override
    public List<CartVo> findMyCart(int userid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "select t_cart.cartid,t_cart.userid,t_cart.count,t_goods.goodsid,t_goods.goodsname,t_goods.unit,t_goods.price,t_goods.imgpath,t_goods.categoryid "+
                    "from t_cart, t_goods "+
                    "where t_cart.goodsid = t_goods.goodsid "+
                    "and t_cart.userid = ? ";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,userid);
            rs = pst.executeQuery();
            List<CartVo> carts = new ArrayList<>();
            CartVo c = null;
            while (rs.next()){
                c = new CartVo();
                c.setCartid(rs.getInt(1));
                c.setUserid(rs.getInt(2));
                c.setCount(rs.getInt(3));
                c.setGoodsid(rs.getInt(4));
                c.setGoodsname(rs.getString(5));
                c.setUnit(rs.getString(6));
                c.setPrice(rs.getDouble(7));
                c.setImgpath(rs.getString(8));
                c.setCategoryid(rs.getInt(9));
                carts.add(c);
            }
            return carts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnect(pst,rs);
        }
        return null;
    }
    //修改购物车数量
    @Override
    public boolean updateCart(String type, String cartid) {
        PreparedStatement pst = null;
        try {
            openConn();
            String sql = null;
            if (type.equals("add")){
                sql = "update t_cart set count = count +1 where cartid = ?";
            }else {
                sql = "update t_cart set count = count -1 where cartid = ?";
            }
            pst = conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(cartid));
            int res = pst.executeUpdate();
            return res > 0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnect(pst);
        }
        return false;
    }

    @Override
    public boolean delCart(String cartid) {
        PreparedStatement pst = null;
        try {
            openConn();
            String sql = "delete from t_cart where cartid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(cartid));
            int res = pst.executeUpdate();
            return res > 0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnect(pst);
        }
        return false;
    }

    @Override
    public List<RecipientEntity> findAllRecipient(int userid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "select * from t_recipient where userid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,userid);
            rs = pst.executeQuery();
            List<RecipientEntity> recps = new ArrayList<>();
            RecipientEntity r = null;
            while (rs.next()){
                r = new RecipientEntity();
                r.setRecipientid(rs.getInt(1));
                r.setRecipientname(rs.getString(2));
                r.setPhone(rs.getString(3));
                r.setAddress(rs.getString(4));
                recps.add(r);
            }
            return recps;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnect(pst,rs);
        }
        return null;
    }
    @Override
    public List<CartVo> findSelectedGoods(String[] goodsids, int userid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String wherein = " and g.goodsid in ( ";
            for (int i = 0 ;i < goodsids.length;i++) {
                wherein+=goodsids[i];
                if (i!=goodsids.length-1) {
                    wherein += ",";
                }
            }
            wherein+=")";
            openConn();
            String sql = "select c.cartid,c.userid,c.count,g.goodsid,g.goodsname,g.unit,g.price,g.imgpath,g.categoryid "+
                    "from t_cart c, t_goods g " +
                    "where c.goodsid = g.goodsid " +
                    "and c.userid = ? "+wherein;
            pst = conn.prepareStatement(sql);
            pst.setInt(1,userid);
            rs = pst.executeQuery();
            List<CartVo> carts = new ArrayList<>();
            CartVo c = null;
            while (rs.next()){
                c = new CartVo();
                c.setCartid(rs.getInt(1));
                c.setUserid(rs.getInt(2));
                c.setCount(rs.getInt(3));
                c.setGoodsid(rs.getInt(4));
                c.setGoodsname(rs.getString(5));
                c.setUnit(rs.getString(6));
                c.setPrice(rs.getDouble(7));
                c.setImgpath(rs.getString(8));
                c.setCategoryid(rs.getInt(9));
                carts.add(c);
            }
            return carts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn(conn,pst,rs);
        }
        return null;
    }
}
