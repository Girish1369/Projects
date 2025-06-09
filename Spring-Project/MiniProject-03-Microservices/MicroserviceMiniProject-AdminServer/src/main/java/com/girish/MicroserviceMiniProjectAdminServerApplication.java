package com.girish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class MicroserviceMiniProjectAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMiniProjectAdminServerApplication.class, args);
	}

}
