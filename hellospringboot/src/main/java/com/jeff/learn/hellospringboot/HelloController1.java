//package com.jeff.learn.hellospringboot;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.UUID;
//import java.util.stream.IntStream;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HelloController1 {
////	@Autowired
////	private SiteProperties siteProperties;
//	@Autowired
//	private PlayerInfoDao playerInfoDao;
//	@RequestMapping("/")
//	public String hello() {
//		return "hello world,it's the beginning of the springboot";
//	}
//	
//	@RequestMapping("/saves1/{id}")
//	@Transactional
//	public String savePlayers(@PathVariable int id) {
//		Set<PlayerInfo> set=new HashSet<>();
//		IntStream.range(0,5).forEach(i -> {
//			PlayerInfo player=new PlayerInfo();
//			player.setAccountId(23333);
//			player.setAgentId(23456);
//			player.setSiteId("testingamaze");
//			player.setStatus("test");
//			player.setTray(1);
//			player.setUserName("saveUser");
//			set.add(player);
//		});
//		
//		return playerInfoDao.savePlayers(set).toString();
//	}
//	
//	@RequestMapping("/getLastId1")
//	public String getLastId() {
//		return playerInfoDao.getLastId().toString();
//	}
//	
//}
