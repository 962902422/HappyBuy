package com.mll;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mll.mapper")
public class backstageApp {
    public static void main(String[] args) {
        SpringApplication.run(backstageApp.class,args);
    }
}
