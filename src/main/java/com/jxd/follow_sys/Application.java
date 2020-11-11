package com.jxd.follow_sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Application
 * @Description TODO
 * @Author zhangyingjie
 * @Date 2020/10/26
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jxd.follow_sys.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
