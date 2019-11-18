package com.manash.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	@RequestMapping(value = "/hello")
	public @ResponseBody String welcome() {
		return "WelCome to spring Boot";
	}

}
