package com.wangning.example.demo.config;


import com.wangning.example.demo.interceptor.MyInterceptor1;
import com.wangning.example.demo.interceptor.MyInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class MyConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private MyInterceptor1 mMyInterceptor1;
    @Autowired
    private MyInterceptor2 mMyInterceptor2;


    public MyConfig() {
        super();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mMyInterceptor1);
        registry.addInterceptor(mMyInterceptor2);
    }
}
