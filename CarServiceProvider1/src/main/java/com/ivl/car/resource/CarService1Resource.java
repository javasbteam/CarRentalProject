package com.ivl.car.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivl.car.model.BookedCar;
import com.ivl.car.model.CarDetailsInput;
import com.ivl.car.model.CarModel;
import com.ivl.car.service.CarDetailsService;

@RestController
@RequestMapping("/api1")
public class CarService1Resource {
	
	@Autowired
	private CarDetailsService carService;
	
	@PostMapping(value = "/searchcar1")
	public List<CarModel> getCarByType( @RequestBody CarDetailsInput carInput){
		return carService.searchByCarType(carInput.getCarType());
	
	}
	
	@PostMapping(value = "/bookcar1")
	public BookedCar bookCar(@RequestBody BookedCar bookedCar) {
		
		return carService.bookCar(bookedCar);
	}

}
