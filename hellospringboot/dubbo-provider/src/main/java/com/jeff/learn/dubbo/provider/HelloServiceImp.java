package com.jeff.learn.dubbo.provider;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.jeff.learn.dubbo.api.HelloService;

@Service
@Component
public class HelloServiceImp implements HelloService {

	@Override
	public String hello(String name) {
		return "hello "+name+",welcome to the world of dubbo-springboot";
	}

}
