package com.czy.sboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.czy.sboot.mapper")
public class SbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootApplication.class, args);
    }

}
