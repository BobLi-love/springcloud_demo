package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.mapper")
public class PeopleApplication {
    public static void main(String[] args) {
        SpringApplication.run(PeopleApplication.class);
        System.out.println("------------------------------------------");
        System.out.println("--------------服务提供者启动成功！----------");
        System.out.println("------------------------------------------");
    }
}
