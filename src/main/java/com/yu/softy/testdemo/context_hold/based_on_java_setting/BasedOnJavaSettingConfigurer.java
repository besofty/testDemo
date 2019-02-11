package com.yu.softy.testdemo.context_hold.based_on_java_setting;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;

/**
 * 自定义配置类
 */
@Configuration
public class BasedOnJavaSettingConfigurer {
    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> testFilterRegistration() {

        FilterRegistrationBean<DelegatingFilterProxy> registration = new FilterRegistrationBean<DelegatingFilterProxy>();
        /**
         * 第一种方式，使用动态代理的方式
         */
        registration.setFilter(new DelegatingFilterProxy("basedOnJavaSettingFilter"));
        /**
         * 第二种方式，直接注入一个filter
         * registration.setFilter(new BasedOnJavaSettingFilter());
         * registration.setName("basedOnJavaSettingFilter");
         **/
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setEnabled(true);
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setOrder(1);
        return registration;
    }

    @Bean(name = "basedOnJavaSettingFilter")
    public BasedOnJavaSettingFilter createCustomPlainFilter() {
        return new BasedOnJavaSettingFilter();
    }
}
