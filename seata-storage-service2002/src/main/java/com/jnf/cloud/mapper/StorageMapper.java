package com.jnf.cloud.mapper;

import com.jnf.cloud.entities.Storage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author jnfstart
 * @Create 2024/3/18 17:45
 * @Version 1.0
 */

public interface StorageMapper extends Mapper<Storage> {
    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}

