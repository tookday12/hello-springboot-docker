package com.jeff.kafka.springboot;

import org.springframework.kafka.support.serializer.JsonDeserializer;

public class SampleJsonDeserializer extends JsonDeserializer<SampleMessage> {

	public SampleJsonDeserializer() {
		super(SampleMessage.class);
	}
}
