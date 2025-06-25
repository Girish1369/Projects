package com.girish.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {
	List<String> listMessage=new ArrayList<>();
	
	public void addMessage(String message) {
		listMessage.add(message);
	}

	public List<String> readAllMessage(){
		return listMessage;
	}
}
