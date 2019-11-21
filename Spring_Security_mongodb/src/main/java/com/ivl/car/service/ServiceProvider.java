package com.ivl.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ivl.car.domain.BookedCar;
import com.ivl.car.domain.CarModel;
import com.ivl.car.domain.SearchModel;

@Service
public class ServiceProvider {
	
	
	private static final String API1SEARCHURL="http://localhost:9090/api1/searchcar1";
	private static final String API1BOOKURL="http://localhost:9090/api1/bookcar1";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<CarModel> searchCar(SearchModel model){
		
		List<CarModel> carModel=restTemplate.postForObject(API1SEARCHURL, model, List.class);
		//List<CarModel> carModel=restTemplate.postForObject(API1SEARCHURL, model, List.class);
		//List<CarModel> carModel=restTemplate.postForObject(API1SEARCHURL, model, List.class);
		return carModel;
	}
	
	public String saveBookedCar(BookedCar bookedCar) {
		BookedCar savedCar=restTemplate.postForObject(API1BOOKURL, bookedCar, BookedCar.class);
		
		return (savedCar!=null)?"Your Car Booked Succssfully":"Booking Failed!!!!!!!!";
	}

}