package com.coding.demo.config;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebugConfig {
    @Value("${spring.data.mongodb.uri:NOT_FOUND}")
    private String uri;

    @PostConstruct
    public void printUri() {
        System.out.println(">>> MONGO URI FROM SPRING: " + uri);
    }
}
