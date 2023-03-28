package com.qc.mp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author：钱程
 * @Date：2023/3/28/19:55
 */

@Slf4j
@SpringBootApplication
// 扫描指定包下的mapper接口
//@MapperScan("com.qc.mp.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("mybatis-plus学习项目已启动...");
    }
}
