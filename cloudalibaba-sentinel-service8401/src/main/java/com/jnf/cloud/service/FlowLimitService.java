package com.jnf.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Author jnfstart
 * @Create 2024/3/14 14:25
 * @Version 1.0
 */
@Service
public class FlowLimitService {

    @SentinelResource(value = "common")
    public void common()
    {
        System.out.println("------FlowLimitService come in");
    }
}
