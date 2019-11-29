package com.ivl.car.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	private static final String API2SEARCHURL="http://localhost:9098/api2/searchcar2";
	private static final String API2BOOKURL="http://localhost:9098/api2/bookcar2";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Map<String,List<CarModel>> searchCar(SearchModel model){
		
		Map<String,List<CarModel>> listCars=new HashMap<>();
		
		List<CarModel> carModel=restTemplate.postForObject(API1SEARCHURL, model, List.class);
		List<CarModel> carModel1=restTemplate.postForObject(API2SEARCHURL, model, List.class);
		listCars.put("api1", carModel);
		listCars.put("api2", carModel1);
		
		return listCars;
	}
	
	public String saveBookedCar(BookedCar bookedCar,String apiAddress) {
		BookedCar savedCar=null;
		if(apiAddress.equals("api1")) {
		 savedCar=restTemplate.postForObject(API1BOOKURL, bookedCar, BookedCar.class);
		}
		else if(apiAddress.equals("api2")) {
			savedCar=restTemplate.postForObject(API2BOOKURL, bookedCar, BookedCar.class);
			}
		
		return (savedCar!=null)?"Your Car Booked Succssfully":"Booking Failed!!!!!!!!";
	}

}