package com.jnf.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author jnfstart
 * @Create ${DATE} ${TIME}
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jnf.cloud.mapper")  //import tk.mybatis.spring.annotation.MapperScan
@EnableDiscoveryClient
@RefreshScope //动态刷新
public class Main8001 {

    public static void main(String[] args) {

        SpringApplication.run(Main8001.class,args);
    }

}