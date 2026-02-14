package com.coding.demo.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class RedisDebug {

    @Autowired
    private RedisConnectionFactory factory;

    @PostConstruct
    public void printRedisInfo() {
        System.out.println(">>> Redis factory class: " + factory.getClass());
    }
}