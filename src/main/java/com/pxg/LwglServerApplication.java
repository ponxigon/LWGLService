package com.pxg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//为war包提供启动器
@SpringBootApplication
public class LwglServerApplication  {
//extends SpringBootServletInitializer
    public static void main(String[] args) {
        SpringApplication.run(LwglServerApplication.class, args);
    }

    //重写父类初始化启动的类是谁
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(LwglServerApplication.class);
//    }
}
