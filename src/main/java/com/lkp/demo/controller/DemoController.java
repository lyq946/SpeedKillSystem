package com.lkp.demo.controller;

import com.lkp.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * 作者：LKP
 * 时间：2018/8/2
 */
@Controller
@EnableAutoConfiguration
public class DemoController {

    @Autowired
    private OrderService orderService;

    /**
     * 访问nginx
     */
    @RequestMapping("/nginx")
    @ResponseBody
    public String nginx(){
        RestTemplate restTemplate = new RestTemplate();
        String conent = restTemplate.getForObject("http://127.0.0.1/",String.class);
        if(conent.contains("Welcome to nginx!")){
            return "success";
        }
        return null;
    }

    /**
     * 无锁
     * @return
     */
    @RequestMapping(value = "/seckill")
    @ResponseBody
    public void seckill(){
        orderService.seckill();
    }

    /**
     * 悲观锁
     * @return
     */
    @RequestMapping(value = "/seckillPessimisticLock")
    @ResponseBody
    public void seckillPessimisticLock(){
        try {
            orderService.seckillPessimism();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 乐观锁
     * @return
     */
    @RequestMapping(value = "/seckillOptimisticLock")
    @ResponseBody
    public void OptimisticLock(){
        orderService.seckillOptimistic();
    }

    /**
     * 失败会重试乐观锁
     * @return
     */
    @RequestMapping(value = "/seckillOptimisticLockretry")
    @ResponseBody
    public void OptimisticLockRetry(){

        while (true){
            int i = orderService.seckillWithOptimistic();
            //如果卖光了 或者卖出成功跳出循环，否者一直循环，直到卖出去位置
            if(i==-1 || i>0){
                break;
            }
        }
    }

    /**
     * 使用redis原子操作保障原子性
     */
    @RequestMapping(value = "/seckillRedis")
    @ResponseBody
    public void seckillRedis(){
        orderService.seckillwithRedis();
    }
}
