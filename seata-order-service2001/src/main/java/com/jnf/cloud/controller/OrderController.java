package com.jnf.cloud.controller;

import com.jnf.cloud.entities.Order;
import com.jnf.cloud.resp.ResultData;
import com.jnf.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jnfstart
 * @Create 2024/3/18 17:35
 * @Version 1.0
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService ;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public ResultData create(Order order){
        orderService.create(order);
        return ResultData.success(order);
    }
}
