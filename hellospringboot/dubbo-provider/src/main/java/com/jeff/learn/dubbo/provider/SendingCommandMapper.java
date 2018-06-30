package com.jeff.learn.dubbo.provider;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SendingCommandMapper {
	int save(SendingCommand sendingCommand);
	SendingCommand get(long id);
	
}
