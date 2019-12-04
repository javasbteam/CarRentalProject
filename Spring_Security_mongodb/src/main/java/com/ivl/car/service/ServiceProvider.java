package com.ivl.car.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ivl.car.domain.BookedCar;
import com.ivl.car.domain.CarModel;
import com.ivl.car.domain.SearchModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ServiceProvider {
	
	
	private static final String API1SEARCHURL="http://localhost:9090/searchcar1";
	private static final String API1BOOKURL="http://localhost:9090/bookcar1";
	
	private static final String API2SEARCHURL="http://localhost:9098/searchcar2";
	private static final String API2BOOKURL="http://localhost:9098/bookcar2";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Map<String,List<CarModel>> searchCar(SearchModel model){
		//List<CarModel> carModel,carModel1=null;
		
		Map<String,List<CarModel>> listCars=new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTc1MzkxMjg0LCJpYXQiOjE1NzUzNTUyODR9.aGnYk6-aEtiuc03QFXL5n7dm0iWkcvDF34sM-wuI13k");
		HttpEntity<Object> reqEntity=new HttpEntity<Object>(model, headers);
		
		//List<CarModel> carModel=restTemplate.postForObject(API1SEARCHURL,model, List.class);
	   //response1= restTemplate.exchange(API1SEARCHURL,HttpMethod.POST,reqEntity,List.class);
		//List<CarModel> carModel1=restTemplate.postForObject(API2SEARCHURL, model, List.class);
	   //response2= restTemplate.exchange(API2SEARCHURL,HttpMethod.POST,reqEntity,List.class);
		List<CarModel> carModel1=getCarDetailsFromService1(reqEntity);
		System.out.println("after carModel1====");
		List<CarModel> carModel2=getCarDetailsFromService2(reqEntity);
		listCars.put("api1",carModel1 );
		
		listCars.put("api2", carModel2);
		
		return listCars;
	}
	
	/*@HystrixCommand(fallbackMethod = "serverDown",commandProperties = {
		      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})*/
	@HystrixCommand(fallbackMethod ="serverDown" )
	public List<CarModel> getCarDetailsFromService1(HttpEntity<Object> reqEntity ){
		ResponseEntity<List> response1=null;
		System.out.println("in get car details from serevice 1");
		 response1= restTemplate.exchange(API1SEARCHURL,HttpMethod.POST,reqEntity,List.class);
			System.out.println("in get car details from serevice 2");

		return response1.getBody();
	}
	
	public List<CarModel> serverDown(HttpEntity<Object> reqEntity) {
		System.out.println("Request fails. It takes long time to response");
	      return new ArrayList<CarModel>();
	   }
	
	public List<CarModel> getCarDetailsFromService2(HttpEntity<Object> reqEntity){
		ResponseEntity<List> response2=null;
		 response2= restTemplate.exchange(API2SEARCHURL,HttpMethod.POST,reqEntity,List.class);
		return response2.getBody();
	}
	
	
	public String saveBookedCar(BookedCar bookedCar,String apiAddress) {
		BookedCar savedCar=null;
		ResponseEntity<BookedCar> response=null;
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTc1MzkxMjg0LCJpYXQiOjE1NzUzNTUyODR9.aGnYk6-aEtiuc03QFXL5n7dm0iWkcvDF34sM-wuI13k");
		HttpEntity<Object> reqEntity=new HttpEntity<Object>(bookedCar, headers);
		
		if(apiAddress.equals("api1")) {
			response=restTemplate.exchange(API1BOOKURL,HttpMethod.POST,reqEntity,BookedCar.class);
		}
		else if(apiAddress.equals("api2")) {
			response=restTemplate.exchange(API2BOOKURL,HttpMethod.POST,reqEntity,BookedCar.class);
			}
		return (response.getBody()!=null)?"Your Car Booked Succssfully":"Booking Failed!!!!!!!!";
	}

}