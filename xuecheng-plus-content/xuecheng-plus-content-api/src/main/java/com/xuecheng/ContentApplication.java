package com.xuecheng;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ragnarok
 * @version 1.0
 * @description 内容管理服务启动类
 * @create 2023-06-29 22:34
 * @github https://github.com/Ragnarokoo
 */
@SpringBootApplication
@EnableSwagger2Doc
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xuecheng.content.feignclient")
public class ContentApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ContentApplication.class, args);
    }
}