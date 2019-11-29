package com.ivl.car.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.ivl.car.domain.BookedCar;
import com.ivl.car.domain.CarModel;
import com.ivl.car.domain.SearchModel;
import com.ivl.car.service.ServiceProvider;

@Controller
public class SearchCarController {

	@Autowired
	private ServiceProvider serviceProvider;

	@Autowired
	private HttpSession session;
	
	
	@GetMapping("/search")
	public String showSearch(Map<String,Object> map) {
		map.put("search", new SearchModel());
		return "search";
	}

	@GetMapping("/searchCar")
	public String getCarData(@ModelAttribute("search") @Valid SearchModel search, BindingResult bindingResult,
			Map<String, Object> map) {

		if (bindingResult.hasErrors()) {
			
			return "search";
		}

		 session.setAttribute("search", search);
		Map<String,List<CarModel>> listOfMap = serviceProvider.searchCar(search);
		if (listOfMap.isEmpty()) {
			map.put("msg1", "No car available on this date");
		} else {
			map.put("api", listOfMap);
		}
		return "search";
	}

	@GetMapping("/bookcar")
	public String bookCar(@RequestParam("carId") String carId,@RequestParam("apiID") String apiAddress, Map<String, Object> map) {
		BookedCar bookedCar = null;
		SearchModel searchModel = null;
		int bookingId = new Random().nextInt(100000);

		searchModel = (SearchModel) session.getAttribute("search");
		bookedCar = new BookedCar();
		bookedCar.setBookId(bookingId);
		bookedCar.setBkFromDt(searchModel.getStartDt());
		bookedCar.setBkToDt(searchModel.getEndDt());
		bookedCar.setCarId(Integer.valueOf(carId));
		String msg = serviceProvider.saveBookedCar(bookedCar,apiAddress);
		map.put("msg", msg);
		map.put("search",new SearchModel());
		return "search";
	}

}