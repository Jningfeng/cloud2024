package com.jnf.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author jnfstart
 * @Create 2024/3/12 16:21
 * @Version 1.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced //赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){return new RestTemplate();}
}
