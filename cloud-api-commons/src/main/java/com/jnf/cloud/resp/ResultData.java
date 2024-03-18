package com.jnf.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author jnfstart
 * @Create 2024/2/29 14:49
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {
    private String code;
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data){
        ResultData resultData = new ResultData();

        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());

        resultData.setData(data);

        return resultData;
    }

    public static <T> ResultData<T> fail(String code, String message){
        ResultData resultData = new ResultData();

        resultData.setCode(code);
        resultData.setMessage(message);

        resultData.setData(null);

        return resultData;
    }
}
