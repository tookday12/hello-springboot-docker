package com.jeff.learn.dubbo.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KafkaListener {
	protected final Logger logger=LogManager.getLogger(this.getClass());
	
	@org.springframework.kafka.annotation.KafkaListener(topics="springT")
	    public void processMessage(String content) {
		  logger.warn("received content:{}",content);
	    }
}
