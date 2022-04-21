package com.wyl.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器过滤器配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean httpServletRequestReplacedFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AccessFilter());
        // /* 是全部的请求拦截，和Interceptor的拦截地址/**区别开
        registration.addUrlPatterns("/*");
        registration.setName("accessRequestFilter");
        registration.setOrder(1);
        return registration;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
    }
}