package com.lkp.demo.service;


/**
 * 作者：LKP
 * 时间：2018/8/21
 */
public interface OrderService {
    /**
     * 生成订单
     * @param name
     * @param createTime
     * @return
     */
    int insertOrder(String name, String createTime);

    /**
     * 悲观锁
     * @return
     */
    void seckillPessimism() throws Exception;

    /**
     * 不重试乐观锁
     * @return
     */
    void seckillOptimistic();

    /**
     * 会重试的乐观锁
     * @return
     */
    int seckillWithOptimistic();

    /**
     * 无锁
     */
    void seckill();

    /**
     * 使用redis原子操作保障原子性
     */
    void seckillwithRedis();
}
