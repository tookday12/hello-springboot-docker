package com.jeff.kafka.springboot.provider;

import java.time.LocalTime;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.jeff.kafka.springboot.SampleMessage;
@Service
public class KafkaSender {
	protected final Logger logger=LogManager.getLogger(this.getClass());
	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;
	
	public KafkaSender() {
		new Thread(() -> this.autoSend()) .start();
	}
	
	public void autoSend() {
		int i=1;
		while(true) {
			i++;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ListenableFuture futrue= kafkaTemplate.send("springTimeT",new SampleMessage(i, LocalTime.now().toString()));
			futrue.addCallback(e -> this.logger.info("successCallback:{}",((SendResult<String,Object>)e).getProducerRecord().value()), ex -> this.logger.info("failCallback:{}",ex.getMessage()));
			logger.info("send message............");
		}
	}
}
