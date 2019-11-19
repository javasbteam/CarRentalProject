package com.ivl.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ivl.car.entity.SearchModel;

@Controller
public class SearchCarController {

	
	
	@GetMapping("/searchCar")
	public String getCarData(@ModelAttribute SearchModel search) {
		
		System.out.println(search.getCarType() + ", " + search);
		return "bookingCar";
	}
}
