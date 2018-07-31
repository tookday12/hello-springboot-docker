package com.jeff.kafka.springboot.consumer;

import java.util.concurrent.CountDownLatch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.stereotype.Service;

import com.jeff.kafka.springboot.SampleMessage;
@Service
public class KafkaConsumer {
	protected final Logger logger=LogManager.getLogger(this.getClass());
	private final CountDownLatch latch = new CountDownLatch(10);

	@KafkaListener(topics = "springTimeT")
	public void processMessage(SampleMessage message) {
		logger.info("receive message SampleMessage:{}",message);
//		this.latch.countDown();
	}
	
//	@KafkaListener(topics = "springTimeT")
//	public void processMessage(String message) {
//		logger.info("receive message:{}",message);
////		this.latch.countDown();
//	}
}
