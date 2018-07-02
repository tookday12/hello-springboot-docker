package com.jeff.learn.dubbo.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.jeff.learn.dubbo.api.HelloService;
import com.jeff.learn.dubbo.api.PlayerInfoService;

@Service(interfaceClass=PlayerInfoService.class,
timeout=5000)
public class PlayerInfoServiceImp implements PlayerInfoService {
	@Autowired
	private PlayerInfoMapper playerInfoMapper;
	@Override
	public String getUsername(int id) {
		// TODO Auto-generated method stub
		return playerInfoMapper.getPlayerInfo(id).get(0).getUserName();
	}

}
