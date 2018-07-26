package com.jeff.learn.dubbo.provider;

public enum RedisKeyPrefix {
	LOGIN_COUNT("loginC"),
	LOGIN_SESSION("loginS"),
	LOGIN("login_"),
	;
	private RedisKeyPrefix(String value) {
		this.value=value;
	}

	private String value;

	public String getValue() {
		return value;
	}
}
