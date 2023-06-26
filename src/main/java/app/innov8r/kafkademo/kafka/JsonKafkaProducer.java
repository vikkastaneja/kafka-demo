package app.innov8r.kafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import app.innov8r.kafkademo.model.User;


@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

	@Value("${spring.kafka.topic-json.name}")
	private String topicJsonName;

    
	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
    
    
	public void sendMessage(User user) {
		Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, topicJsonName).build();
		kafkaTemplate.send(message);
		LOGGER.info(String.format("Message sent: %s", user.toString()));
	}
}
