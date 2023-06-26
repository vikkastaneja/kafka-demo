package app.innov8r.kafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import app.innov8r.kafkademo.model.User;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	
	@KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(User message) {
		
		LOGGER.info(String.format("Message received: %s", message.toString()));
		
	}
}
