package com.jnf.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author jnfstart
 * @Create ${DATE} ${TIME}
 * @Version 1.0
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class Main83 {
    public static void main(String[] args) {

        SpringApplication.run(Main83.class,args);
    }
}