package com.ivl.car.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    
    @Bean
    public ViewResolver viewResolver() {
    	 InternalResourceViewResolver bean = new InternalResourceViewResolver();
    	 
         bean.setViewClass(JstlView.class);
         bean.setPrefix("/WEB-INF/jsp/");
         bean.setSuffix(".jsp");
    
         return bean;
    }
}