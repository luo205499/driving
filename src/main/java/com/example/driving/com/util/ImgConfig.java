package com.example.driving.com.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ${lcl}
 * @Title: ImgConfig
 * @ProjectName driving
 * @Description: TODO
 * @date 2018/12/22 002215:43
 */
public class ImgConfig {
    @Configuration
    public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry){
            //指向外部目录
            registry.addResourceHandler("img//**").addResourceLocations("file:H:/img/");
            super.addResourceHandlers(registry);
        }
    }

}
