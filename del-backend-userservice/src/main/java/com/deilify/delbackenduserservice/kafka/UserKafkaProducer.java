package com.deilify.delbackenduserservice.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.deilify.delbackenduserservice.dto.SampleKafkaDto;
import com.deilify.delbackenduserservice.util.ConstantUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Service
public class UserKafkaProducer {
	

	
	@Value("${topic.userservice.sendTestMessage}")
	private String topicUserServiceToVendorService;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	private static final Logger logger = LogManager.getLogger();
	
	
	public void messageBuilder(SampleKafkaDto sampleKafkaDto) {
		
		
		logger.info("payload is " + sampleKafkaDto);
		try {
			Map<String , Object> headers = setHeaders();
			
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String payload = ow.writeValueAsString(sampleKafkaDto);
			Message<Object> message = MessageBuilder.withPayload((Object) payload).copyHeaders(headers)
					.setHeader(KafkaHeaders.TOPIC, topicUserServiceToVendorService).build(); 
			kafkaTemplate.send(message);
			
		} catch (Exception e) {
			
		}
		
	}


	private Map<String, Object> setHeaders() {
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("requestType", ConstantUserService.TEST_REQUEST);
		headers.put("key", getUniqueKey());
		return null;
	}


	private String getUniqueKey() {
//		choose a charecter randomly from this string
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
//		create StringBuffer size of Alphanumeric String
		StringBuilder sb = new StringBuilder(ConstantUserService.POSITION_EIGHT);
		for (int i=0; i <= ConstantUserService.POSITION_EIGHT; i++) {
//			generate a random number between 
//			0 to AlphanumericString variable length
			int index = (int)(alphaNumericString.length() * Math.random());
//			add Charecter one by one in end of sb
			sb.append(alphaNumericString.charAt(index));
			
		}
		
		return sb.toString();
	}
	

}
