package com.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.*;

@Configuration   //表示 这个类 里面的符合spring 注解规范的对象都要生成
@ComponentScan("com") //扫描指定包下面 符合spring 注解规范的对象
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableCaching
@EnableScheduling

public class SpringConfig extends WebMvcConfigurerAdapter {



    @Bean("propertyConfigurer")  //propertie的配置器将指定的properies添加
    public PropertyPlaceholderConfigurer getPropertyPalce(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = 	new PropertyPlaceholderConfigurer();//生成配置类
        //生成资源数组
        ClassPathResource[]  classPathResources = {new ClassPathResource("log4j.properties"),new ClassPathResource("log4jdbc.log4j2.properties")};
        //classpth就是部署出来的classes的根目录
        propertyPlaceholderConfigurer.setLocations(classPathResources);//将指定资源注册加载
        return propertyPlaceholderConfigurer;
    }

    // 静态资源访问
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    //添加绑定的资源，参数registry从来哪里来,spring给的 spring将所以资源装入自己，也生成资源注册器，让这个资源注册器把静态资源注册了，以前这个资源注册器只注册了和controller绑定的url
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler("/static/**") 表示将所有的static下的资源请映射到后面指定的路径.addResourceLocations("classpath:/static/")
        //如果要访问css下资源 请到classpath 服务器目录下的static下的css文件夹下面去找
        //就能找到因为 资源注册器把这里面的资源和url都绑好了 按文件名绑好了

        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/html/**").addResourceLocations("classpath:/static/html/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/").setCachePeriod(31556926);
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/").setCachePeriod(31556926);
    }



}
