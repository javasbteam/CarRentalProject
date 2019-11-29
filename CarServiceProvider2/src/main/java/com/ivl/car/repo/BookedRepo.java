package com.ivl.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivl.car.model.BookedCar;

@Repository("/bookedCar")
public interface BookedRepo extends JpaRepository<BookedCar, Integer> {

}
