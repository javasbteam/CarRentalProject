package com.ivl.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ivl.car.entity.UserModel;

@Controller
public class CarIntermediateController {

	
	@RequestMapping("/home_car")
	public String getHomePage() {
		
		return "home";
	}
	
	
	
}
