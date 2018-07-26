package com.jeff.learn.dubbo.provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

	protected final Logger logger=LogManager.getLogger(this.getClass());
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		logger.warn("event:...........{}",()-> "w"+"w");
	}

}
