package com.girish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceMiniProjectEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMiniProjectEurekaServerApplication.class, args);
	}

}
