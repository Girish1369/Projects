package com.girish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class BootMicroserviceProj09ZuulserverApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMicroserviceProj09ZuulserverApiGatewayApplication.class, args);
	}

}
