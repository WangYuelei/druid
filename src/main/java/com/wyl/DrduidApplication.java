package com.wyl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyl.dao")
public class DrduidApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrduidApplication.class, args);
    }

}
