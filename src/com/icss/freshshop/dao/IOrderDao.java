package com.icss.freshshop.dao;

import com.icss.freshshop.entity.OrderDto;
import com.icss.freshshop.vo.OrderDetailVo;
import com.icss.freshshop.vo.OrderVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/3/003 13:40
 * @Description :
 */
public interface IOrderDao {

    boolean insertOrder(OrderDto orderDto) throws SQLException;

    void insertOrderGoods(String orderNum, String goodsid, String price, String count) throws SQLException;

    void delCart(int userId, String[] goodsids) throws SQLException;

    List<OrderVo> findMyOrder(int userid) throws SQLException;

    List<OrderDetailVo> findOrderDetail(String ordernum) throws SQLException;
}
