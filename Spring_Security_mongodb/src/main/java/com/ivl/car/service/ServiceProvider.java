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
/**
 * 
 * @author Priyanka.Ronge,Manash Kumar
 * @version 1.0
 *
 */
@Service
public class ServiceProvider {

	private static final String API1SEARCHURL = "http://localhost:9090/searchcar1";
	private static final String API1BOOKURL = "http://localhost:9090/bookcar1";

	private static final String API2SEARCHURL = "http://localhost:9098/searchcar2";
	private static final String API2BOOKURL = "http://localhost:9098/bookcar2";

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * This method will get data from ServiceProvider1 
	 * If the service is down then it will call the fallback method that is defined in @HystrixCommand()
	 * @param model
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "fallback")
	public List<CarModel> getCarDetailsFromService1(SearchModel model) {
		ResponseEntity<List> response1 = null;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization",
				"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTc1NTU1MzA0LCJpYXQiOjE1NzU1MTkzMDR9.1YUnvVljZXU-Igrw-ELD5DtXXZa5C0SwMGhYYXeFSjE");
		HttpEntity<Object> reqEntity = new HttpEntity<Object>(model, headers);

		response1 = restTemplate.exchange(API1SEARCHURL, HttpMethod.POST, reqEntity, List.class);

		List<CarModel> carList = response1.getBody();

		return carList;
	}

	/**
	 * This method will get data from ServiceProvider2 
	 * If the service is down then it will call the fallback method that is defined in @HystrixCommand()
	 * @param model
	 * @return arrayList
	 */
	@HystrixCommand(fallbackMethod = "fallback")
	public List<CarModel> getCarDetailsFromService2(SearchModel model) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization",
				"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTc1NTU1MzA0LCJpYXQiOjE1NzU1MTkzMDR9.1YUnvVljZXU-Igrw-ELD5DtXXZa5C0SwMGhYYXeFSjE");
		HttpEntity<Object> reqEntity = new HttpEntity<Object>(model, headers);
		ResponseEntity<List> response2 = null;
		response2 = restTemplate.exchange(API2SEARCHURL, HttpMethod.POST, reqEntity, List.class);
		return response2.getBody();
	}

	/**
	 * This method will execute if any service is down.
	 * @param model
	 * @return arrayList
	 */
	public List<CarModel> fallback(SearchModel model) {
		System.out.println("Request fails. It takes long time to response");
		return new ArrayList<CarModel>();
	}

	/**
	 * This method is used to save booked car details.
	 * @param bookedCar
	 * @param apiAddress
	 * @return String
	 */
	public String saveBookedCar(BookedCar bookedCar, String apiAddress) {
		BookedCar savedCar = null;
		ResponseEntity<BookedCar> response = null;

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization",
				"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTc1NTU1MzA0LCJpYXQiOjE1NzU1MTkzMDR9.1YUnvVljZXU-Igrw-ELD5DtXXZa5C0SwMGhYYXeFSjE");
		HttpEntity<Object> reqEntity = new HttpEntity<Object>(bookedCar, headers);

		if (apiAddress.equals("api1")) {
			response = restTemplate.exchange(API1BOOKURL, HttpMethod.POST, reqEntity, BookedCar.class);
		} else if (apiAddress.equals("api2")) {
			response = restTemplate.exchange(API2BOOKURL, HttpMethod.POST, reqEntity, BookedCar.class);
		}
		return (response.getBody() != null) ? "Your Car Booked Succssfully" : "Booking Failed!!!!!!!!";
	}

}