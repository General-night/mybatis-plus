package com.qc.mp.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MP配置类
 *
 * @Author：钱程
 * @Date：2023/4/1/16:47
 */

@Configuration
public class MpConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mpInterceptor = new MybatisPlusInterceptor();

        // 添加分页插件
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // 添加乐观锁插件
        mpInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

        return mpInterceptor;
    }
}
