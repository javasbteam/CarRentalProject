package com.manash.demo.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderResource {
	
	@RequestMapping("/msg")
	public String getGreting(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Welcome To IVL";
	}

}
