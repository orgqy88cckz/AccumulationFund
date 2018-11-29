package com.aaa.af;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * className:SpringBootMainApplication
 * discription:
 * author:Cheng Fangying
 * createTime:2018-11-21 10:17
 */
@SpringBootApplication
@MapperScan("com.aaa.af.dao") //扫描dao层接口
public class SpringBootMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainApplication.class);
    }
}
