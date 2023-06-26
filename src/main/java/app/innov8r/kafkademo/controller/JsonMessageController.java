package app.innov8r.kafkademo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.innov8r.kafkademo.kafka.JsonKafkaProducer;
import app.innov8r.kafkademo.model.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
	private JsonKafkaProducer kafkaProducer;

	public JsonMessageController(JsonKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@PostMapping("/publishJson")
	public ResponseEntity<String> publish(@RequestBody User user) {
		kafkaProducer.sendMessage(user);
		return new ResponseEntity<String>(String.format("Message sent: %s", user.toString()), HttpStatus.ACCEPTED);
	}
}
