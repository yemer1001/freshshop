package com.icss.freshshop.service;

import com.icss.freshshop.entity.RecipientEntity;
import com.icss.freshshop.vo.CartVo;

import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/23/023 14:43
 * @Description :
 */
public interface ICartService {
    boolean addCart(String goodsid, int userid);

    List<CartVo> findMyCart(int userid);
    boolean updateCart(String type,String cartid);

    boolean delCart(String cartid);

    List<RecipientEntity> findAllRecipient(int userid);

    List<CartVo> findSelectedGoods(String[] goodsids, int userid);
}
