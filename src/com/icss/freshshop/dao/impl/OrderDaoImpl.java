package com.icss.freshshop.dao.impl;

import com.icss.freshshop.dao.IOrderDao;
import com.icss.freshshop.entity.OrderDto;
import com.icss.freshshop.utils.JdbcUtils;
import com.icss.freshshop.vo.CartVo;
import com.icss.freshshop.vo.OrderDetailVo;
import com.icss.freshshop.vo.OrderVo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/3/003 13:40
 * @Description :
 */
public class OrderDaoImpl extends JdbcUtils implements IOrderDao {


    @Override
    public boolean insertOrder(OrderDto orderDto) throws SQLException {
        PreparedStatement pst = null;
        try {
            String sql = "insert into t_order values (?,0,?,now(),1,?,null,?,?,10)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,orderDto.getOrderNum());
            pst.setInt(2,orderDto.getUserId());
            pst.setDouble(3,orderDto.getTotalPrice());
            pst.setInt(4,orderDto.getRecipientId());
            pst.setInt(5,orderDto.getPayStyle());

            int res = pst.executeUpdate();
            return res > 0?true:false;
        }finally {
            closeConnect(pst);
        }
    }

    @Override
    public void insertOrderGoods(String orderNum, String goodsid, String price, String count) throws SQLException{
        PreparedStatement pst = null;
        try {
            String sql = "insert into t_order_goods values (null,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,orderNum);
            pst.setInt(2,Integer.parseInt(goodsid));
            pst.setDouble(3,Double.parseDouble(price));
            pst.setInt(4,Integer.parseInt(count));

            pst.executeUpdate();
        }finally {
            closeConnect(pst);
        }
    }

    @Override
    public void delCart(int userId, String[] goodsids) throws SQLException{
        PreparedStatement pst = null;
        try {
            String wherein = " and goodsid in ( ";
            for (int i = 0 ;i < goodsids.length;i++) {
                wherein+=goodsids[i];
                if (i!=goodsids.length-1) {
                    wherein += ",";
                }
            }
            wherein+=")";
            String sql = "delete from t_cart where userid = ?"+wherein;
            pst = conn.prepareStatement(sql);
            pst.setInt(1,userId);
            pst.executeQuery();
        } finally {
            closeConnect(pst);
        }
    }

    @Override
    public List<OrderVo> findMyOrder(int userid) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select ordernum,createtime,status,totalprice from t_order where userid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, userid);
            rs = pst.executeQuery();
            List<OrderVo> orders = new ArrayList<>();
            OrderVo o = null;
            while (rs.next()) {
                o = new OrderVo();
                o.setOrdernum(rs.getString(1));
                o.setCreatetime(rs.getTimestamp(2));
                o.setStatus(rs.getInt(3));
                o.setTotalprice(rs.getDouble(4));
                orders.add(o);
            }
            return orders;
        } finally {
            closeConnect(pst, rs);
        }
    }

    @Override
    public List<OrderDetailVo> findOrderDetail(String ordernum) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select * from t_order_goods og ,t_goods g " +
                    " where og.goodsid = g.goodsid and og.ordernum = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1, ordernum);
            rs = pst.executeQuery();
            List<OrderDetailVo> orderDetailVos = new ArrayList<>();
            OrderDetailVo d = null;
            while (rs.next()) {
                d = new OrderDetailVo();
                d.setGoodsid(rs.getInt("goodsid"));
                d.setImgpath(rs.getString("imgpath"));
                d.setPrice(rs.getDouble("price"));
                d.setCount(rs.getInt("count"));
                d.setUnit(rs.getString("unit"));
                orderDetailVos.add(d);
            }
            return orderDetailVos;
        } finally {
            closeConnect(pst, rs);
        }
    }

}
