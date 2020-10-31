package com.jxd.follow_sys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author:zff
 * @Description:跨域名配置文件
 * @Date:2020/4/19
 */
@Configuration
public class CrosConfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")// 允许跨域访问的路径
                .allowedOrigins("*")// 允许跨域访问的源
                .allowedMethods("GET", "HEAD", "POST", "DELETE", "OPTIONS")// 允许请求方法
                .allowCredentials(true)// 是否发送cookie
                .maxAge(3600)// 预检间隔时间
                .allowedHeaders("*");// 允许头部设置
    }
}
