package com.jeff.learn.dubbo.provider;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface PlayerInfoMapper {

//	@ResultType(PlayerInfo.class)
//	@Results({
//		@Result(property="accountId",column="account_id"),	
//		@Result(property="agentId",column="agent_id"),	
//		@Result(property="userName",column="user_name"),	
//	})
//	@Select("select * from player_info where id =#{id}")
	List<PlayerInfo> getPlayerInfo(int id);
		
//	@Select("select user_name as userName, agent_id as agentId from ${table} where id =#{id}")
	PlayerInfo getPlayerInfo1(@Param("id") long id,@Param("table") String table);
	
	int savePlayer(@Param("table")String table,@Param("player")PlayerInfo player);
	
	int updatePlayerInfo(PlayerInfo player);
	@Transactional
	int savePlayers(@Param("table")String table, @Param("players") Set<PlayerInfo> players);
	
	long getLastId();
	
	Integer getMinId(int accountId);
	
	Integer getMinId1(@Param("field")String field,@Param("fieldValue")int accountId);
	CleanIds getCleanId(@Param("table")String table,@Param("selectField")String selectField,@Param("selectFieldV")int cleanId);
}
