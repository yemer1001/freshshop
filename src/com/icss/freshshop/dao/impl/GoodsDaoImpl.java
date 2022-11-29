package com.icss.freshshop.dao.impl;
import com.icss.freshshop.dao.IGoodsDao;
import com.icss.freshshop.entity.CategoryEntity;
import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.utils.JdbcUtils;
import com.icss.freshshop.vo.GoodsVo;

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

    @Override
    public List<GoodsEntity> findMoreGoods(String categoryid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "select * from t_goods where categoryid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(categoryid));
            rs = pst.executeQuery();
            List<GoodsEntity> goodsList = new ArrayList<>();
            GoodsEntity goods = null;
            while (rs.next()){
                goods = new GoodsEntity();
                goods.setGoodsid(rs.getInt("goodsid"));
                goods.setGoodsname(rs.getString("goodsname"));
                goods.setPrice(rs.getDouble("price"));
                goods.setImgpath(rs.getString("imgpath"));
                goods.setUnit(rs.getString("unit"));
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
    public List<CategoryEntity> findAllCategory() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "select * from t_category?";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            List<CategoryEntity> categoryLists = new ArrayList<>();
            CategoryEntity category = null;
            while (rs.next()){
                category= new CategoryEntity();
                category.setCategoryid(rs.getInt(1));
                category.setCategoryname(rs.getString(2));
                categoryLists.add(category);
            }
            return categoryLists;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn(conn,pst,rs);
        }
        return null;
    }

    @Override
    public boolean addGoods(GoodsEntity goods) {
        PreparedStatement pst = null;
        try {
            openConn();
            String sql = "insert into t_goods(categoryid, goodsname, "+
                    "price, unit, goodsinfo, stock, createtime, addtime, imgpath)"+
                    "values(?,?,?,?,?,?,now(),now(),?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,goods.getCategoryid());
            pst.setString(2,goods.getGoodsname());
            pst.setDouble(3,goods.getPrice());
            pst.setString(4,goods.getUnit());
            pst.setString(5,goods.getGoodsinfo());
            pst.setInt(6,goods.getStock());
            pst.setString(7,goods.getImgpath());
            int res = pst.executeUpdate();
            return res>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn(conn,pst);
        }
        return false;
    }

    @Override
    public List<GoodsVo> findAllGoodsPage(int firstSize, int pageSize) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            openConn();
            String sql = "select * "+
                    "from t_goods g ,t_category c" +
                    "where g.categoryid = c.categoryid"+
                    "limit ?,?";
            pst = conn.prepareStatement(sql);

            pst.setInt(1,firstSize);
            pst.setInt(2,pageSize);
            rs = pst.executeQuery();
            List<GoodsVo> goodsList = new ArrayList<>();
            GoodsVo goods = null;
            while (rs.next()){
                goods = new GoodsVo();
                goods.setGoodsid(rs.getInt("goodsid"));
                goods.setGoodsname(rs.getString("goodsname"));
                goods.setPrice(rs.getDouble("price"));
                goods.setUnit(rs.getString("unit"));
                goods.setCategoryname(rs.getString("categoryname"));
                goods.setCategoryid(rs.getInt("categoryid"));
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
    public int findTotalCount() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from t_goods";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs.next() == true ? rs.getInt(1) : 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConn(conn,pst,rs);
        }
        return 0;
    }
}
