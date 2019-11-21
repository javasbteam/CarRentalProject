package com.ivl.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivl.car.model.BookedCar;
import com.ivl.car.model.CarModel;
import com.ivl.car.repo.BookedRepo;
import com.ivl.car.repo.CarDetailsRepo;

@Service("carService")
public class CarDetailsServiceImpl implements CarDetailsService{
	
	@Autowired
	private CarDetailsRepo carRepo;
	@Autowired
	private BookedRepo bookedRepo;

	@Override
	public List<CarModel> searchByCarType(String carType) {
		List<CarModel> cm = carRepo.findByCarType(carType);
		//List<CarModel> cm = carRepo.findAll();
		return cm;
	}

	@Override
	public BookedCar bookCar(BookedCar bookedCar) {
		BookedCar car= bookedRepo.save(bookedCar);
		return car;
	}

}
