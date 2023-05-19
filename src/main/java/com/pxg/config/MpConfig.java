package com.pxg.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//拦截器
@Configuration//定义配置类
public class MpConfig {
    @Bean
    public MybatisPlusInterceptor mpinterceptor(){
        MybatisPlusInterceptor mpinterceptor = new MybatisPlusInterceptor();
        mpinterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpinterceptor;
    }
}
