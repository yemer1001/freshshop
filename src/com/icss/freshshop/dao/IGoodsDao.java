package com.icss.freshshop.dao;

import com.icss.freshshop.entity.GoodsEntity;

import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/20/020 15:42
 * @Description :
 */
public interface IGoodsDao {
    List<GoodsEntity> findGoodsByCategoryId(int categoryId);
}
