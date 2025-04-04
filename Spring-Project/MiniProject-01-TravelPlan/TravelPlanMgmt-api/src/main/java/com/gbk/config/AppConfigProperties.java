package com.gbk.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="plan.module")
@EnableConfigurationProperties
public class AppConfigProperties {
	
	public Map<String,String> message;

	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AppConfigProperties [message=" + message + "]";
	}
	
	

}
