package com.girish.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.girish.producer.MessageProducer;
import com.girish.store.MessageStore;

@RestController
@RequestMapping("/kafka")
public class KafkaMessagingOperationController {

	@Autowired
	private MessageProducer producer;
	
	@Autowired
	private MessageStore store;
	
	@GetMapping("/send")
	public ResponseEntity<?> sendMessage(@RequestParam("message" )String message){
		String sendMessage = producer.sendMessage(message);
		return new ResponseEntity<String>(sendMessage,HttpStatus.OK);
		
	}
	@GetMapping("/read")
	public ResponseEntity<?> readMessage(){
		List<String> allMessage = store.readAllMessage();
		return new ResponseEntity<>(allMessage,HttpStatus.OK);
	}
}
