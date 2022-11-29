package com.icss.freshshop.service.impl;

import com.icss.freshshop.dao.ICartDao;
import com.icss.freshshop.dao.impl.CartDaoImpl;
import com.icss.freshshop.entity.RecipientEntity;
import com.icss.freshshop.service.ICartService;
import com.icss.freshshop.vo.CartVo;

import java.util.List;

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
    //查看购物车
    @Override
    public List<CartVo> findMyCart(int userid) {
        return dao.findMyCart(userid);
    }
    //修改购物车数量
    @Override
    public boolean updateCart(String type,String cartid){
        return dao.updateCart(type,cartid);
    }

    @Override
    public boolean delCart(String cartid) {
        return dao.delCart(cartid);
    }

    @Override
    public List<RecipientEntity> findAllRecipient(int userid) {
        return dao.findAllRecipient(userid);
    }

    @Override
    public List<CartVo> findSelectedGoods(String[] goodsids, int userid) {
        return dao.findSelectedGoods(goodsids,userid);
    }
}
