package com.jeff.learn.dubbo.consumer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jeff.learn.dubbo.api.HelloService;
import com.jeff.learn.dubbo.api.PlayerInfoService;

@RestController
public class HelloDubboSpringBoot {
	@Reference
	private HelloService helloService;
	@Reference
	private PlayerInfoService playerInfoService;
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name")String name) {
		return helloService.hello(name);
	}
	
	@RequestMapping("/username/{id}")
	public String username(@PathVariable("id")int id) {
		return playerInfoService.getUsername(id);
	}
}
