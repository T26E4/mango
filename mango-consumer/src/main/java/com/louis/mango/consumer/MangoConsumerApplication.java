package com.louis.mango.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MangoConsumerApplication {
	public static void main(String args[]) {
		SpringApplication.run(MangoConsumerApplication.class, args);
	}
}
