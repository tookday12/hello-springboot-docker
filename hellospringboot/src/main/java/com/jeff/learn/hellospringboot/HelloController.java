package com.jeff.learn.hellospringboot;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//	@Autowired
//	private SiteProperties siteProperties;
	@Autowired
	private PlayerInfoMapper playerInfoMapper;
	
	@Autowired
	private SendingCommandMapper sendingCommandMapper;
	
	@Autowired
	private StringRedisTemplate redisTem;
	
	@RequestMapping("/")
	public String hello() {
		return "hello world,it's the beginning of the springboot";
	}
	
	@RequestMapping("/hello/docker")
	public String helloDocker() {
		return "hello world,it's the beginning of the docker";
	}
	
	@RequestMapping("/site/{id}")
	public String helloSite(@PathVariable int id) {
		List<PlayerInfo> players=playerInfoMapper.getPlayerInfo(id);
		return players.get(0).getUserName();
	}
	
	@RequestMapping("/sitemin/{id}")
	public String helloMinSite(@PathVariable int id) {
		return playerInfoMapper.getMinId(id)+"";
	}
	
	@RequestMapping("/sitemin1/{id}")
	public String helloMinSite1(@PathVariable int id) {
		CleanIds cleanIds=playerInfoMapper.getCleanId("player_info", "id", id);
		return cleanIds.getMinId()+"_"+cleanIds.getMaxId();
	}
	
	@RequestMapping("/save/sen")
	public String saveSen() {
		SendingCommand sendingCommand=new SendingCommand();
		sendingCommand.setCommandId(UUID.randomUUID().toString());
		sendingCommand.setCommandObj("test".getBytes());
		sendingCommand.setCommandType("mybatisTest");
		sendingCommand.setDetails("mybatisTest");
		sendingCommand.setLotteryType("ffffffff");
		sendingCommand.setSendTime(new Date());
		sendingCommandMapper.save(sendingCommand);
		return "success";
	}
	
	@RequestMapping("/get/sen")
	public String getSen() {
		return sendingCommandMapper.get(25911819l).getDetails();
	}
	
	
	@RequestMapping("/site1/{id}")
	public String helloSite1(@PathVariable long id) {
		PlayerInfo player=playerInfoMapper.getPlayerInfo1(id,"player_info");
		System.out.println("account:"+player.getAccountId());
		System.out.println("username:"+player.getUserName());
		System.out.println("tray:"+player.getTray());
		return player.getUserName();
	}
	
	@RequestMapping("/save/{id}")
	public int savePlayer(@PathVariable int id) {
		PlayerInfo player=new PlayerInfo();
		player.setAccountId(23333);
		player.setAgentId(23456);
		player.setSiteId("testingamazed");
		player.setStatus("testdf");
		player.setTray(1);
		player.setUserName("saveUser");
		SendingCommand sendingCommand=new SendingCommand();
		sendingCommand.setCommandId("rrrrrr123");
		player.setSendingCommand(sendingCommand);
		playerInfoMapper.savePlayer("player_info",player);
		return player.getId();
	}
	
	@RequestMapping("/update/{id}")
	public int updatePlayer(@PathVariable int id) {
		PlayerInfo player=new PlayerInfo();
		player.setId(id);
		player.setAccountId(23333);
		player.setAgentId(23456);
		player.setSiteId("testingamaze");
		player.setStatus("test11");
		player.setTray(1);
		player.setUserName(null);
		return playerInfoMapper.updatePlayerInfo(player);
	}
	
	
	@RequestMapping("/saves/{id}")
	public String savePlayers(@PathVariable int id) {
		Set<PlayerInfo> set=new HashSet<>();
		IntStream.range(0,5).forEach(i -> {
			PlayerInfo player=new PlayerInfo();
			player.setAccountId(23333);
			player.setAgentId(23456);
			player.setSiteId("testinga");
			if(i==4) {
				player.setSiteId("testingadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
			}
			player.setStatus("test");
			player.setTray(1);
			player.setUserName("saveUser");
			set.add(player);
		});
		System.out.println(playerInfoMapper.savePlayers("player_info",set));
		
		PlayerInfo player=new PlayerInfo();
		player.setAccountId(23333);
		player.setAgentId(23456);
		player.setSiteId("testingamaze");
		player.setStatus("1111");
		player.setTray(1);
		player.setUserName("saveUser");
		playerInfoMapper.savePlayer("player_info",player);
		return playerInfoMapper.getLastId()+"";
	}
	
	@RequestMapping("/getLastId")
	public String getLastId() {
		return playerInfoMapper.getLastId()+"";
	}
	
	@RequestMapping("/redis/{id}")
	public String helloSite2(@PathVariable int id) {
		redisTem.opsForValue().set(id+"", id+"redis");
		return redisTem.opsForValue().get(id+"");
	}
}
