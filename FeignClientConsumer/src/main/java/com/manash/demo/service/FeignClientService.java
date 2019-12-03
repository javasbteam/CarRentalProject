package com.manash.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("msg-service")
public interface FeignClientService {
	
	@RequestMapping("/msg")
	public String getGreting();

}
