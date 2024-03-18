package com.jnf.cloud.service;

import com.jnf.cloud.entities.Pay;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jnfstart
 * @Create 2024/2/27 23:37
 * @Version 1.0
 */
@Service
public interface PayService {
    public int add(Pay pay);

    public int delete(Integer id);

    public int update(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();
}
