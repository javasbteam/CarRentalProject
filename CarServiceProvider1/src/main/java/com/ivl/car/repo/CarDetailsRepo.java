package com.ivl.car.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ivl.car.model.CarModel;

public interface CarDetailsRepo extends MongoRepository<CarModel,Integer> {
	
	@Query("{'CAR_TYPE':?0 ,'CITY':?1 , 'START_DT':?2 , 'END_DT':?3 }")
	public List<CarModel> findByCarType(String carType , String city,String startDt,String endDt);
	/*@Query("{'START_DT':?0 , 'END_DT':?1 }")
	public List<CarModel> findByCarType(String startDt,String endDt);*/

}
