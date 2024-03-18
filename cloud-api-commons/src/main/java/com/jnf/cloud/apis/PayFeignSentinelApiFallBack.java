package com.jnf.cloud.apis;

import com.jnf.cloud.resp.ResultData;
import com.jnf.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @Author jnfstart
 * @Create 2024/3/18 14:00
 * @Version 1.0
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {

    @Override
    public ResultData getPayByOrderNo(String orderNo)
    {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}