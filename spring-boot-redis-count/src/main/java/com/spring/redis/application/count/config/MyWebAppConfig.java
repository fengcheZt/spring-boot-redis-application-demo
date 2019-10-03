package com.spring.redis.application.count.config;

import com.spring.redis.application.count.interceptor.CounterInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableTransactionManagement
public class MyWebAppConfig implements WebMvcConfigurer {
    @Bean
    CounterInterceptor counterInterceptor(){
        return new CounterInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(counterInterceptor());
    }
}
