package com.manash.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manash.demo.service.FeignClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.loadbalancer.reactive.ExecutionContext;

@RestController()
public class FeignConsumerResource {
	
	@Autowired
	private FeignClientService feignClientService;
	
	@RequestMapping("/{name}")
	@HystrixCommand(fallbackMethod = "getFallbackMethod")
	public String getWish(@PathVariable("name") String name) {
		return "Hi, "+name+" "+feignClientService.getGreting();
	}
	
	public String getFallbackMethod(@PathVariable("name") String name) {
		
		return "Get Fallback Method executed!!!!!";
		
	}

}
