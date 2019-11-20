package com.ivl.car.service;

import java.util.List;

import com.ivl.car.model.BookedCar;
import com.ivl.car.model.CarModel;

public interface CarDetailsService {
	
	public List<CarModel> searchByCarType(String carType);
	
	public BookedCar bookCar(BookedCar bookedCar);

}
