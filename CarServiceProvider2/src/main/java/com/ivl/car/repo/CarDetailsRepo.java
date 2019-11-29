package com.ivl.car.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ivl.car.model.CarModel;

public interface CarDetailsRepo extends JpaRepository<CarModel, Integer> {

		@Query("select c from CarModel c where c.carType=?1 AND c.startDt=?2 AND c.endDt=?3")
		public List<CarModel> findByCarType(String carType ,String startDt,String endDt);

}
