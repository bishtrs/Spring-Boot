package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafKaProducerService {
	private static final Logger logger = LoggerFactory.getLogger(KafKaProducerService.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		
		this.kafkaTemplate.send("test", message);
		//ListenableFuture<SendResult<String, String>> future = 
			//    this.kafkaTemplate.send("numbers", message, message);
		logger.info(String.format("Message sent -> %s", message));
	}
}
