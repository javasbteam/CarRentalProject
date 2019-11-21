package com.ivl.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class SpringbootMongodbSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbSecurityApplication.class, args);
    }
    
	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
    
}
