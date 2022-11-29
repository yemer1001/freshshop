package com.icss.freshshop.service;

import com.icss.freshshop.entity.OrderDto;
import com.icss.freshshop.vo.OrderVo;

import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/3/003 13:41
 * @Description :
 */
public interface IOrderService {
    boolean submitOrder(OrderDto orderDto);

    List<OrderVo> findMyOrder(int userid);
}
