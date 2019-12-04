package com.ivl.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CarServiceProvider1Application {

	public static void main(String[] args) {
		SpringApplication.run(CarServiceProvider1Application.class, args);
	}

}
