package com.jnf.cloud.service;

/**
 * @Author jnfstart
 * @Create 2024/3/18 17:48
 * @Version 1.0
 */
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
