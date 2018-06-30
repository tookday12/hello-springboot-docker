package com.jeff.learn.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
public class App 
{
    public static void main( String[] args )
    {
    	 SpringApplication.run(App.class, args);
    }
}
