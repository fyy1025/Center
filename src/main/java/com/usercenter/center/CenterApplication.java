package com.usercenter.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.usercenter.center.mappers")
public class CenterApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(CenterApplication.class, args);
    }

}
