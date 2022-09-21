package com.icss.freshshop.dao.impl;
import com.icss.freshshop.dao.IGoodsDao;
import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.utils.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/20/020 15:43
 * @Description :
 */
public class GoodsDaoImpl extends JdbcUtils implements IGoodsDao{
    @Override
    public List<GoodsEntity> findGoodsByCategoryId(int categoryId) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "select * from t_goods where categoryid = ? limit 4";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,categoryId);
            rs = pst.executeQuery();
            List<GoodsEntity> goodsList = new ArrayList<>();
            GoodsEntity goods = null;
            while (rs.next()){
                goods = new GoodsEntity();
                goods.setGoodsid(rs.getInt("goodsid"));
                goods.setGoodsname(rs.getString("goodsname"));
                goods.setPrice(rs.getDouble("price"));
                goods.setImgpath(rs.getString("imgpath"));
                goodsList.add(goods);
            }
            return goodsList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnect(pst,rs);
        }
        return null;
    }

    @Override
    public GoodsEntity findGoodsDetail(String goodsid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "select * from t_goods where goodsid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(goodsid));
            rs = pst.executeQuery();
            GoodsEntity goods = null;
            while (rs.next()){
                goods = new GoodsEntity();
                goods.setGoodsid(rs.getInt("goodsid"));
                goods.setGoodsname(rs.getString("goodsname"));
                goods.setPrice(rs.getDouble("price"));
                goods.setImgpath(rs.getString("imgpath"));
                goods.setCategoryid(rs.getInt("categoryid"));
                goods.setUnit(rs.getString("unit"));
                goods.setGoodsinfo(rs.getString("goodsinfo"));
            }
            return goods;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnect(pst,rs);
        }
        return null;
    }
}
