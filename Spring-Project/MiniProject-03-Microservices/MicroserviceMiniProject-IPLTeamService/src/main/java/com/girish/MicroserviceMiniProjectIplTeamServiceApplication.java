package com.girish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceMiniProjectIplTeamServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMiniProjectIplTeamServiceApplication.class, args);
	}

}
