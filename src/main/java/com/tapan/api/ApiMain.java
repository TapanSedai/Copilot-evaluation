package com.tapan.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ApiMain {
    public static void main(String[] args) {
        SpringApplication.run(ApiMain.class, args);
    }
}