package com.jeff.learn.dubbo.provider;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
@Service
public class KafkaSender {
	protected final Logger logger=LogManager.getLogger(this.getClass());
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaSender() {
		new Thread(() -> this.autoSend()) .start();
	}
	
	
	public void autoSend() {
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ListenableFuture futrue= kafkaTemplate.send("springT", new Date().getTime()+"");
			logger.info("send message............");
		}
	}
}
