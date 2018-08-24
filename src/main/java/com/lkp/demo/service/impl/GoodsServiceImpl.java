package com.lkp.demo.service.impl;

import com.lkp.demo.entity.Goods;
import com.lkp.demo.mapper.GoodsMapper;
import com.lkp.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作者：LKP
 * 时间：2018/8/2
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper userMapper;

    @Override
    public int updateGoodsCount(Goods goods) {
        return userMapper.updateGoodsCount(goods);
    }

    @Override
    public int updateGoodsCountOptimisticLock(Goods goods,int version) {
        return userMapper.updateGoodsCountOptimisticLock(goods,version);
    }

    @Override
    public Goods getGoods() {
        return userMapper.getGoods();
    }
}