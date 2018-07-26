package com.jeff.learn.dubbo.provider;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.jeff.learn.dubbo.api.LoginService;

@Service(timeout=5000)
public class LognServiceImp implements LoginService {
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Override
	public String login(int playerId) {
		long loginCount=redisTemplate.opsForHash().increment(RedisKeyPrefix.LOGIN.getValue()+playerId,RedisKeyPrefix.LOGIN_COUNT.getValue(),1);
		String loginCountStr=fillXX(loginCount+"",3,"x");
		String uuid=UUID.randomUUID().toString();
		String loginSession=uuid.substring(5,10)+new Date().getTime()%1000000000l+uuid.substring(11,16)+loginCountStr+uuid.substring(30,35)+playerId;
		redisTemplate.opsForHash().put(RedisKeyPrefix.LOGIN.getValue()+playerId, RedisKeyPrefix.LOGIN_SESSION.getValue(), loginSession);
		redisTemplate.expire(RedisKeyPrefix.LOGIN.getValue()+playerId,6*60*60, TimeUnit.SECONDS);
		return loginSession;
	}

	@Override
	public boolean isValidate(String loginSession) {
		String playerIdStr=loginSession.substring(27);
		return redisTemplate.opsForHash().get(RedisKeyPrefix.LOGIN.getValue()+playerIdStr, RedisKeyPrefix.LOGIN_SESSION.getValue()).equals(loginSession);
	}
	
	private String fillXX(String str,int fillSize,String fillChar) {
		if(str.length()==fillSize) {
			return str;
		}else {
			return fillXX(str,fillSize-1,fillChar)+fillChar;
		}
	}
	
}
