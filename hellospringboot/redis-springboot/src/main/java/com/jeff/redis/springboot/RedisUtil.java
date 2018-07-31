package com.jeff.redis.springboot;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

@Service
public class RedisUtil {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public <T> T executeScript(String luaFilePath,Class<T> resultType,List<String> keys,Object... args) {
		DefaultRedisScript<T> redisScript = new DefaultRedisScript<>();
		ClassPathResource resource = new ClassPathResource(luaFilePath);
		redisScript.setScriptSource(new ResourceScriptSource(resource));
		redisScript.setResultType(resultType);
		return stringRedisTemplate.execute(redisScript,keys,args);
	}
	
	@PostConstruct
	public void init() {
		this.executeScript("/hcopy.lua", Integer.class, Arrays.asList("htest","htest1"), "htest1111","htest2111");
	}
	
}
