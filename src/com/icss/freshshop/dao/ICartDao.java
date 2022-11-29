package com.icss.freshshop.dao;

import com.icss.freshshop.entity.RecipientEntity;
import com.icss.freshshop.vo.CartVo;

import java.util.List;

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

    List<CartVo> findMyCart(int userid);

    boolean updateCart(String type, String cartid);

    boolean delCart(String cartid);

    List<RecipientEntity> findAllRecipient(int userid);

    List<CartVo> findSelectedGoods(String[] goodsids, int userid);
}
