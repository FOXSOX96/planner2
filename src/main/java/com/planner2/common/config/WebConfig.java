package com.planner2.common.config;

import com.planner2.common.filter.LogFilter;
import com.planner2.common.filter.LoginCheckFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    //필터1 로그기록
    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(new LogFilter());  //필터정의
        filterRegistrationBean.setOrder(1);                 //필터순서
        filterRegistrationBean.addUrlPatterns("/*");        //URL
        return  filterRegistrationBean;
    }

    //필터2 세션 인가
    @Bean
    public FilterRegistrationBean loginCheckFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(new LoginCheckFilter());   //필터정의
        filterRegistrationBean.setOrder(2);                         //필터순서
        filterRegistrationBean.addUrlPatterns("/*");                //URL
        return  filterRegistrationBean;
    }

}
