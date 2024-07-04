package com.example.bookmanagement.config;

import com.example.bookmanagement.filter.Logging2Filter;
import com.example.bookmanagement.filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggingFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2); // 设置过滤器顺序为2
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<Logging2Filter> logging2Filter() {
        FilterRegistrationBean<Logging2Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Logging2Filter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1); // 设置过滤器顺序为1
        return registrationBean;
    }
}
