package com.jeff.learn.dubbo.api;

public interface LoginService {

	String login(int playerId);
	
	boolean isValidate(String loginSession);
}
