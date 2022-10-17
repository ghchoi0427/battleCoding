package com.dku.dandev.configuration;

import com.dku.dandev.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/");

        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/signup");

        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/home");

        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/login");


        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/home");


       */
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/home");

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/match/new");

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/member");


    }


}
