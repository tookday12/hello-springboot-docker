package com.jeff.learn.dubbo.provider;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.jeff.learn.dubbo.api.HelloService;

@Service(
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}",
        timeout=5000
)
public class HelloServiceImp implements HelloService {

	@Override
	public String hello(String name) {
		return "hello "+name+",welcome to the world of dubbo-springboot"+RpcContext.getContext().getLocalPort();
	}

}
