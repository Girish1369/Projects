package com.girish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.girish","com.girish.controller"})
public class SpringSecurity01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity01Application.class, args);
	}

}
