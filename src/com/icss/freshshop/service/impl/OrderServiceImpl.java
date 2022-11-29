package com.icss.freshshop.service.impl;

import com.icss.freshshop.dao.IOrderDao;
import com.icss.freshshop.dao.impl.OrderDaoImpl;
import com.icss.freshshop.entity.OrderDto;
import com.icss.freshshop.service.IOrderService;
import com.icss.freshshop.vo.OrderDetailVo;
import com.icss.freshshop.vo.OrderVo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/3/003 13:42
 * @Description :
 */
public class OrderServiceImpl implements IOrderService {
    OrderDaoImpl dao = new OrderDaoImpl();
    @Override
    public boolean submitOrder(OrderDto orderDto) {
        try {
            //打开事务
            dao.beginTransaction();
            //插入数据到t_order订单表中
            String orderNum = getOrderNum();
            orderDto.setOrderNum(orderNum);
            boolean res = dao.insertOrder(orderDto);
            if (res){
                for (int i = 0;i < orderDto.getGoodsids().length;i++){
                    dao.insertOrderGoods(orderNum,orderDto.getGoodsids()[i],
                            orderDto.getPrices()[i],orderDto.getCounts()[i]);
                }
                //删除购物车
                dao.delCart(orderDto.getUserId(),orderDto.getGoodsids());
                dao.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            dao.rollback();
        }finally {
            dao.closeConnection();
        }
        return false;
    }

    @Override
    public List<OrderVo> findMyOrder(int userid) {
        List<OrderVo> orders = null;
        try {
            dao.openConn();
            orders = dao.findMyOrder(userid);
            for (int i = 0;i < orders.size();i++){
                List<OrderDetailVo> vo = dao.findOrderDetail(orders.get(i).getOrdernum());
                orders.get(i).setLists(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dao.closeConnection();
        }
        return orders;
    }

    public static String getOrderNum() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        return df.format(new Date())+Math.abs(new Random().nextInt());
    }
}
