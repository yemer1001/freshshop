package com.icss.freshshop.service;

import com.icss.freshshop.entity.GoodsEntity;

import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/20/020 15:46
 * @Description :
 */
public interface IGoodsService {
    List<GoodsEntity> findGoodsByCategoryId(int categoryId);

    GoodsEntity findGoodsDetail(String goodsid);

   List<GoodsEntity>  findMoreGoods(String categoryid);
}
