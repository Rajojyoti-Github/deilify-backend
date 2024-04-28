package com.deilify.delbackenduserservice.util;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

public class AwsSNSClient {
	
	public static final String AWS_ACCESS_KEY_ID = "aws.accessKeyId";
	public static final String AWS_SECRET_KEY = "aws.secretKey";
	
	static {
		System.setProperty(AWS_ACCESS_KEY_ID, "");
		System.setProperty(AWS_SECRET_KEY, "");
	}
	
	public static void main(String[] args) {
		AwsSNSClient myClient = new AwsSNSClient();
		myClient.sendingOtpSms("The OTP to Login to your Account is 478365", "+91 8013341617");
	}
	
	public void sendingOtpSms(String message, String mobileNumber) {
		AmazonSNS snsClient = AmazonSNSClient.builder().withRegion(Regions.US_EAST_1).build();
		Map<String, MessageAttributeValue> smsAttributes = new HashMap<>();
		smsAttributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue().withStringValue("Deilify.fifo").withDataType("String"));
		smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue().withStringValue("Deilify.fifo").withDataType("String"));
		
		PublishResult result = snsClient.publish(new PublishRequest()
								.withMessage(message)
								.withMessage(mobileNumber)
								.withMessageAttributes(smsAttributes));
		System.out.println("Message send Successfully" + result.getMessageId());
		
	}

}
