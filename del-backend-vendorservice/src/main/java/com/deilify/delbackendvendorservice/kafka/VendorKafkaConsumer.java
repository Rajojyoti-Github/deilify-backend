package com.deilify.delbackendvendorservice.kafka;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class VendorKafkaConsumer {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(VendorKafkaConsumer.class);
	
	@KafkaListener(containerFactory="", topics = "#{'${spring.application.kafka.receiveTestMessagetopic}'}", groupId = "$()")
	public void consume(Message<Object> message) {
		
		logger.info("[USER-SERVICE-TEST-MESSAGE] -> Consumed message -> {}", message );
		
	}
	

}
