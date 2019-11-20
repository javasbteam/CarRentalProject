package com.ivl.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ivl.car.entity.CarModel;
import com.ivl.car.entity.SearchModel;

@Service
public class ServiceProvider {
	
	
	private static final String API1URL="http://localhost:9090/api1/searchcar1";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<CarModel> searchCar(SearchModel model){
		
		List<CarModel> carModel=restTemplate.postForObject(API1URL, model, List.class);
		return carModel;
	}

}
