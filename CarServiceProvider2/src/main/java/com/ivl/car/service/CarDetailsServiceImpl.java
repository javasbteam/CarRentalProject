package com.ivl.car.service;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivl.car.model.BookedCar;
import com.ivl.car.model.CarDetailsInput;
import com.ivl.car.model.CarModel;
import com.ivl.car.repo.BookedRepo;
import com.ivl.car.repo.CarDetailsRepo;

@Service("carService")
public class CarDetailsServiceImpl implements CarDetailsService{
	
	@Autowired
	private CarDetailsRepo carRepo;
	@Autowired
	private BookedRepo bookedRepo;
	
	/**
	 * This method is used to load data into the h2 data base
	 */
	@PostConstruct
	public void loadData() {
		
		Stream.of(new CarModel(201,"SUV", "2019-11-14", "2019-11-18",5000,"XUV-500"),
				new CarModel(202,"SUV", "2019-11-15", "2019-11-19",4000,"KUV-5300"),
				new CarModel(203,"SEDAN", "2019-12-14", "2019-12-18",5000,"Vento"),
				new CarModel(204,"SEDAN", "2019-11-14", "2019-11-18",3000,"Rapido")
				).forEach(carModel->{
					carRepo.save(carModel);
				});
	}
	
		@Override
		public List<CarModel> searchByCarType(CarDetailsInput input) {
			List<CarModel> cm = carRepo.findByCarType(input.getCarType(),input.getStartDt(),input.getEndDt());
			//List<CarModel> cm = carRepo.findAll();
			return cm;
		}
		
	@Override
	public List<CarModel> getAllCar(){
		List<CarModel> listCar=carRepo.findAll();
		return listCar;
	}

	@Override
	public BookedCar bookCar(BookedCar bookedCar) {
		BookedCar car= bookedRepo.save(bookedCar);
		return car;
	}

}
