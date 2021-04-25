package com.siemens.brownfield.femanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.siemens.brownfield.femanagement.dao")
public class FemanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(FemanagementApplication.class, args);
    }

}
