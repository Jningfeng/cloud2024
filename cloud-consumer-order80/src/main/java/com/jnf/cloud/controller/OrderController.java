package com.jnf.cloud.controller;

import com.jnf.cloud.entities.PayDTO;
import com.jnf.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jnfstart
 * @Create 2024/2/29 15:39
 * @Version 1.0
 */
@RestController
public class OrderController {

    //public static final String PaymentSrv_URL = "http://localhost:8001"; //先写死
    public static final String PaymentSrv_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){

       return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }

    @DeleteMapping(value = "/consumer/pay/del/{id}")
    public ResultData deletePay(@PathVariable("id") Integer id){

        ResponseEntity<ResultData> exchange = restTemplate.exchange(PaymentSrv_URL + "/pay/del/" + id, HttpMethod.DELETE, null, ResultData.class);

        return exchange.getBody();

    }

    @PutMapping(value = "/consumer/pay/update")
    public ResultData updatePay(@RequestBody PayDTO payDTO){


        restTemplate.put(PaymentSrv_URL+"/pay/update/", payDTO, ResultData.class);

        ResultData resultData = new ResultData();
        return resultData;

    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id){

        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id,ResultData.class,id);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }

}
