package app.innov8r.kafkademo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.innov8r.kafkademo.kafka.KafkaProducer;
import app.innov8r.kafkademo.model.SendMessage;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

	private KafkaProducer kafkaProducer;
	
	public MessageController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("publish")
	public ResponseEntity<String> publish(@RequestBody SendMessage message) {
		
		kafkaProducer.sendMessage(message.getMessage());
		return new ResponseEntity<String>(message.getMessage(), HttpStatus.ACCEPTED);
		
	}
}
