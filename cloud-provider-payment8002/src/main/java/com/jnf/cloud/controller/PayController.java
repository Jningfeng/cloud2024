package com.jnf.cloud.controller;

import com.jnf.cloud.entities.Pay;
import com.jnf.cloud.entities.PayDTO;
import com.jnf.cloud.resp.ResultData;
import com.jnf.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author jnfstart
 * @Create 2024/2/27 23:43
 * @Version 1.0
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());

        int i = payService.add(pay);

        return ResultData.success("插入成功：" + i) ;
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id ){

        int i = payService.delete(id);

        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){

        Pay pay = new Pay();

        BeanUtils.copyProperties(payDTO,pay);

        int i = payService.update(pay);

        return ResultData.success("修改成功：" + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public  ResultData<Pay> getById(@PathVariable("id") Integer id){

        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/getAll")
    @Operation(summary = "查所有",description = "查询支付流水方法")
    public ResultData<List<Pay>> getAll(){

        List<Pay> all = payService.getAll();

        return ResultData.success(all);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    public String getInfoByConsul(@Value("${jnf.info}") String jnfInfo){

        return "jnfInfo:"+jnfInfo+"\t"+"prot:"+port ;
    }

}
