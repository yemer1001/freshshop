package com.icss.freshshop.dao;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/23/023 14:41
 * @Description :
 */
public interface ICartDao {
    int findCart(String goodsid, int userid);

    void updateCart(int cartid);

    void insertCart(String goodsid, int userid);
}
