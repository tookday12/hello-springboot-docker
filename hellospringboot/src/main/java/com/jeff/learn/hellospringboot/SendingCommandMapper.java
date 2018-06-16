package com.jeff.learn.hellospringboot;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SendingCommandMapper {
	int save(SendingCommand sendingCommand);
	SendingCommand get(long id);
}
