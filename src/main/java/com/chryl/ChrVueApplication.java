package com.chryl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.chryl.mapper")
public class ChrVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChrVueApplication.class, args);
    }

}
