package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumerService {
	private final Logger logger = LoggerFactory.getLogger(KafKaConsumerService.class);

	@KafkaListener(topics = "test", groupId = "group_id")
	public void consume(String message) {
		logger.info(String.format("Message recieved -> %s", message));
	}

	@KafkaListener(groupId = "group_id", topicPartitions = {
			@TopicPartition(topic = "testpartitions", partitions = { "0", "1" }) })
	void listenToPartitionWithOffset(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.OFFSET) int offset) {
		logger.info("Received message [{}] from partition-{} with offset-{}", message, partition, offset);
	}
}
