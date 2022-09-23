package com.icss.freshshop.service.impl;

import com.icss.freshshop.dao.ICartDao;
import com.icss.freshshop.dao.impl.CartDaoImpl;
import com.icss.freshshop.service.ICartService;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/23/023 14:42
 * @Description :
 */
public class CartServiceImpl implements ICartService {
    ICartDao dao = new CartDaoImpl();
    @Override
    public boolean addCart(String goodsid, int userid) {
        int cartid = dao.findCart(goodsid,userid);
        if (cartid>0){
            dao.updateCart(cartid);
        }else {
            dao.insertCart(goodsid,userid);
        }
        return true;
    }
}
