package com.ivl.car.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ivl.car.model.CarModel;

public interface CarDetailsRepo extends MongoRepository<CarModel,Integer> {
	
	@Query("{'CAR_TYPE':?0 }")
	public List<CarModel> findByCarType(String carType);

}
