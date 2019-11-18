package com.ivl.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/home")
	public String viewHome() {
		
		return "home";
	}
}
