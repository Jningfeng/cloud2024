package com.jnf.cloud;

import java.time.ZonedDateTime;

/**
 * @Author jnfstart
 * @Create ${DATE} ${TIME}
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}