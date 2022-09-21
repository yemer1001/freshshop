package com.icss.freshshop.service.impl;

import com.icss.freshshop.dao.IGoodsDao;
import com.icss.freshshop.dao.impl.GoodsDaoImpl;
import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.service.IGoodsService;

import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/20/020 15:47
 * @Description :
 */
public class GoodsServiceImpl implements IGoodsService {
    IGoodsDao dao = new GoodsDaoImpl();
    @Override
    public List<GoodsEntity> findGoodsByCategoryId(int categoryId) {

        return dao.findGoodsByCategoryId(categoryId);
    }

    @Override
    public GoodsEntity findGoodsDetail(String goodsid) {
        return dao.findGoodsDetail(goodsid);
    }
}
