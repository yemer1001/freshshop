package com.icss.freshshop.dao;

import com.icss.freshshop.entity.CategoryEntity;
import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.vo.GoodsVo;

import java.util.List;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/9/20/020 15:42
 * @Description :
 */
public interface IGoodsDao {
    List<GoodsEntity> findGoodsByCategoryId(int categoryId);

    GoodsEntity findGoodsDetail(String goodsid);

    List<GoodsEntity> findMoreGoods(String categoryid);

    List<CategoryEntity> findAllCategory();

    boolean addGoods(GoodsEntity goods);

    List<GoodsVo> findAllGoodsPage(int firstSize, int pageSize);

    int findTotalCount();
}
