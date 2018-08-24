package com.lkp.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * 作者：LKP
 * 时间：2018/8/2
 */
public interface OrderMapper {

    /**
     * 生成订单
     * @param name
     * @param createTime
     * @return
     */
    @Insert("INSERT INTO `databaseset`.`seckill_order`(`custname`, `create_time`) VALUES (#{name}, #{createTime});")
    int insertOrder(@Param("name") String name, @Param("createTime") String createTime);

}
