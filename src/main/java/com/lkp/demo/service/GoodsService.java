package com.lkp.demo.service;

import com.lkp.demo.entity.Goods;

/**
 * 作者：LKP
 * 时间：2018/8/2
 */
public interface GoodsService {
    /**
     * 减掉商品库存——悲观锁
     * @return
     */
    int updateGoodsCount(Goods goods);

    /**
     * 减掉商品库存——乐观锁
     * @return
     */
    int updateGoodsCountOptimisticLock(Goods goods, int version);

    /**
     * 查询商品
     * @return
     */
    Goods getGoods();
}
