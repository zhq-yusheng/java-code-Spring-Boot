package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


public class WebConfig {
    //内置的资源定位器，默认如果返回标准的资源找
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp");//指定默认资源在web-inf的jsp文件夹下面查找
        internalResourceViewResolver.setSuffix(".jsp");//资源的后缀名默认添加.jsp
        return internalResourceViewResolver;
    }

    @Bean
    public BeanNameUrlHandlerMapping getBeanNameUrlHandlerMapping() {
        return new BeanNameUrlHandlerMapping();
    }

    @Bean
    public SimpleControllerHandlerAdapter
    getSimpleControllerHandlerAdapter() {
        return new SimpleControllerHandlerAdapter();
    }


    /**
     * restful springmvc支持
     * @return
     */
    @Bean("hiddenHttpMethodFilter")
    public HiddenHttpMethodFilter initRestFulFilter() {
        return  new HiddenHttpMethodFilter();
    }
}
