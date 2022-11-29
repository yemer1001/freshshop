package com.icss.freshshop.service.impl;

import com.icss.freshshop.dao.IGoodsDao;
import com.icss.freshshop.dao.impl.GoodsDaoImpl;
import com.icss.freshshop.entity.CategoryEntity;
import com.icss.freshshop.entity.GoodsEntity;
import com.icss.freshshop.service.IGoodsService;
import com.icss.freshshop.vo.GoodsVo;
import com.icss.freshshop.vo.PageResultVo;

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

    @Override
    public List<GoodsEntity> findMoreGoods(String categoryid) {
        return dao.findMoreGoods(categoryid);
    }

    @Override
    public List<CategoryEntity> findAllCategory() {
        return dao.findAllCategory();
    }

    @Override
    public boolean addGoods(GoodsEntity goods) {
        return dao.addGoods(goods);
    }
    @Override
    public void findAllGoodsPage(PageResultVo<GoodsVo>page){
        //每页展示条数
        int pageSize = 5;
        //计算起始条数
        int firstSize = (page.getCurrentPage()-1*pageSize);
        //展示查询数据
        List<GoodsVo> goodsList = dao.findAllGoodsPage(firstSize,pageSize);
        page.setLists(goodsList);
        int totalCount = dao.findTotalCount();
        page.setTotalCount(totalCount);
        int totalPage = totalCount%pageSize ==0?totalCount/pageSize:totalCount/pageSize+1;
        page.setTotalPage(totalPage);
    }
}
