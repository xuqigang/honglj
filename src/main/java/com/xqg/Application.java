package com.xqg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 */

@EnableScheduling             // Spring Boot的主类中加入@EnableScheduling注解，启用定时任务的配置
@SpringBootApplication        // Spring Boot的启动注解
@EnableCaching                // 注解缓存功能
@EnableTransactionManagement // 启注解事务管理
@MapperScan("com.xqg.mapper.*")
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }

}